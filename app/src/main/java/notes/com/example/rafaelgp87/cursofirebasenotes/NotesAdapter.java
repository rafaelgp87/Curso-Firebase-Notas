package notes.com.example.rafaelgp87.cursofirebasenotes;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rgutierrez on 08/02/2018.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    List<Notes> notesList;
    Context context;

    public NotesAdapter(Context context, List<Notes> notes) {
        this.context = context;
        this.notesList = notes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.count.setText(String.valueOf(notesList.get(position).count));
        holder.name.setText(notesList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView name, count;
        ImageView trash;

        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view.findViewById(R.id.card);
            count = (TextView) view.findViewById(R.id.count);
            name = (TextView) view.findViewById(R.id.name);
            trash = (ImageView) view.findViewById(R.id.trash);
        }


    }
}
