package notes.com.example.rafaelgp87.cursofirebasenotes;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    List<Notes> notesList;
    //NotesAdapter notesAdapter;
    DatabaseReference databaseReference;
    FirebaseRecyclerAdapter<Notes,NotesAdapter.ViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //createData();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        fab = (FloatingActionButton) findViewById(R.id.fab);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //notesAdapter = new NotesAdapter(this,notesList);
        adapter = new FirebaseRecyclerAdapter<Notes, NotesAdapter.ViewHolder>(
                Notes.class, R.layout.note, NotesAdapter.ViewHolder.class, databaseReference.child("Items")
        ) {
            @Override
            protected void populateViewHolder(NotesAdapter.ViewHolder viewHolder, Notes model, final int position) {
                viewHolder.count.setText(String.valueOf(model.getCount()));
                viewHolder.name.setText(model.getName());
                viewHolder.trash.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        adapter.getRef(position).removeValue();
                    }
                });
            }
        };

        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    fab.show();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(dy > 0 || dy < 0 && fab.isShown()) {
                    fab.hide();
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,InsertNoteActivity.class);
                startActivity(intent);
            }
        });
    }

    /*
    public void createData(){
        notesList = new ArrayList<>();
        notesList.add(new Notes("001","Rafa",0));
        notesList.add(new Notes("002","Rafa",1));
        notesList.add(new Notes("003","Rafa",2));
        notesList.add(new Notes("004","Rafa",3));
        notesList.add(new Notes("005","Rafa",4));
        notesList.add(new Notes("006","Rafa",5));
        notesList.add(new Notes("007","Rafa",6));
        notesList.add(new Notes("008","Rafa",7));
        notesList.add(new Notes("009","Rafa",8));
        notesList.add(new Notes("010","Rafa",9));
        notesList.add(new Notes("011","Rafa",10));
        notesList.add(new Notes("012","Rafa",11));
    }
    */
}
