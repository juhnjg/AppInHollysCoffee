package corp.juhnjg.appborninhollyscoffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import corp.juhnjg.appborninhollyscoffee.models.Note;

public class NoteActivity extends AppCompatActivity {

    private static final String TAG = "NoteActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        if(getIntent().hasExtra("selected note")){
            Note note = getIntent().getParcelableExtra("selected note");
            Log.d(TAG, "onCreate: " + note.toString());
        }
    }
}
