package corp.juhnjg.appborninhollyscoffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;

import corp.juhnjg.appborninhollyscoffee.adapters.NotesRecyclerAdapter;
import corp.juhnjg.appborninhollyscoffee.models.Note;
import corp.juhnjg.appborninhollyscoffee.util.VerticalSpacingItemDecorator;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "NotificationFromJK";

    //UI components
    private RecyclerView mRecyclerView;

    //vars
    private ArrayList<Note> mNotes = new ArrayList<>();
    private NotesRecyclerAdapter mNotesRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);

        initRecyclerView();
        insertFakeNotes();

        Log.d(TAG, "onCreate: " + mNotes.get(2).getTitle());
        Log.d(TAG, "onCreate: " + mNotes.get(2).getContent());
        Log.d(TAG, "onCreate: " + mNotes.get(2).getTimestamp());
    }

    private void insertFakeNotes(){

        for (int i = 0; i < 5; i++) {
            Note note = new Note("Title #"+i, "Content #" + i, "May 2019" );
            mNotes.add(note);
        }
        mNotesRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        mNotesRecyclerAdapter = new NotesRecyclerAdapter(mNotes);
        mRecyclerView.setAdapter(mNotesRecyclerAdapter);
    }
}
