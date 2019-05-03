package corp.juhnjg.appborninhollyscoffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;


import java.util.ArrayList;

import corp.juhnjg.appborninhollyscoffee.adapters.NotesRecyclerAdapter;
import corp.juhnjg.appborninhollyscoffee.models.Note;
import corp.juhnjg.appborninhollyscoffee.util.VerticalSpacingItemDecorator;

public class MainActivity extends AppCompatActivity implements NotesRecyclerAdapter.OnNoteListener {

    private static final String TAG = "MainActivity";

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

        //아래 한줄의 소스코드는 다음의 코드가 요약된 것이다.
        // Toolbar toolbar = (Toolbar) findViewById(R.id.note_toolbar));
        // setSupportActionBar(toolbar);
        setSupportActionBar((Toolbar) findViewById(R.id.note_toolbar));
        setTitle("Notes");

    }

    private void insertFakeNotes() {

        for (int i = 0; i < 100; i++) {
            Note note = new Note("Title #" + i, "Content #" + i, "May 2019");
            mNotes.add(note);
        }
        mNotesRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        mNotesRecyclerAdapter = new NotesRecyclerAdapter(mNotes, this);
        mRecyclerView.setAdapter(mNotesRecyclerAdapter);
    }

    @Override
    public void onNoteClick(int position) {
        Log.d(TAG, "onNoteClick: clicked" + position);

    }
}
