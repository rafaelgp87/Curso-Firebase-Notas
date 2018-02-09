package notes.com.example.rafaelgp87.cursofirebasenotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserActivity extends AppCompatActivity {

    EditText usuario, correo, edad;
    Button guardar;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        usuario = (EditText) findViewById(R.id.usuario);
        correo = (EditText) findViewById(R.id.correo);
        edad = (EditText) findViewById(R.id.edad);
        guardar = (Button) findViewById(R.id.guardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usuario.getText().toString().trim();
                String mail = correo.getText().toString().trim();
                String age  = edad.getText().toString().trim();

                Users users1 = new Users(user, mail, Integer.valueOf(age));

                databaseReference.child("usuarios").child(user).setValue(users1);
            }
        });
    }
}
