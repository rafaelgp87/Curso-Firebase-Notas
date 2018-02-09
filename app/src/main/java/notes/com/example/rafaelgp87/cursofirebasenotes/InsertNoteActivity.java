package notes.com.example.rafaelgp87.cursofirebasenotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsertNoteActivity extends AppCompatActivity {

    EditText id, name, count;
    Button add;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_note);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);
        count = (EditText) findViewById(R.id.count);
        add = (Button) findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mId = id.getText().toString().trim();
                String mName = name.getText().toString().trim();
                int mCount = Integer.valueOf(count.getText().toString().trim());

                Notes note = new Notes(mId, mName, mCount);
                databaseReference.child("Items").push().setValue(note);
            }
        });
    }
}
