package corp.juhnjg.appborninhollyscoffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import corp.juhnjg.appborninhollyscoffee.models.Note;

public class NoteActivity extends AppCompatActivity implements View.OnTouchListener,
        GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private static final String TAG = "NoteActivity";

    //ui components
    private LinedEditText mLineEditText;
    private EditText mEditTitle;
    private TextView mViewTitle;

    //vars
    private boolean mIsNewNote;
    private Note mInitialNote;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mLineEditText = findViewById(R.id.note_text);
        mEditTitle = findViewById(R.id.note_edit_title);
        mViewTitle = findViewById(R.id.note_text_title);

        if(getIncomingIntent()){
            // this is a new note, (EDIT MODE)
            setNewNoteProperties();

        }
        else{
            // this is NOT a new note, (VIEW MODE)
            setNoteProperties();

        }

        setListeners();
    }

    private void setListeners(){
        mLineEditText.setOnTouchListener(this);
        mGestureDetector = new GestureDetector(this,this);
    }

    private boolean getIncomingIntent() {
        if (getIntent().hasExtra("selected_note")) {
            mInitialNote = getIntent().getParcelableExtra("selected_note");
            Log.d(TAG, "onCreate: " + mInitialNote.toString());
            mIsNewNote = false;
            return false;
        }
        mIsNewNote = true;
        return true;
    }

    private void setNoteProperties(){
        mViewTitle.setText(mInitialNote.getTitle());
        mEditTitle.setText(mInitialNote.getTitle());
        mLineEditText.setText(mInitialNote.getContent());
    }

    private void setNewNoteProperties(){
        mViewTitle.setText("Note Title");
        mEditTitle.setText("Note Title");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {

        Log.d(TAG, "onDoubleTap: double tabbed");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }
}
