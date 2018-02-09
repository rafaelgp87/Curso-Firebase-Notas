package notes.com.example.rafaelgp87.cursofirebasenotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        textView = (TextView) findViewById(R.id.textview);

        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("title"));
    }
}
