package com.aziz.mynotes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class NoteAdapter extends FirestoreRecyclerAdapter<Notes,NoteAdapter.NoteViewHolder> {


    Context context;
    public NoteAdapter(@NonNull FirestoreRecyclerOptions<Notes> options, Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteViewHolder holder, int position, @NonNull Notes model) {
    holder.title_r.setText(model.title);
        holder.content_r.setText(model.content);
        holder.time.setText(Utility.timestamptoString(model.timestamp));

        holder.itemView.setOnClickListener(v -> {
            Intent intent=new Intent(context, NoteCreate.class);
            intent.putExtra("title",model.title);
            intent.putExtra("content",model.content);
            String docId=this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("docId",docId);
            context.startActivity(intent);
        });

    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritem,parent,false);
        return new NoteViewHolder(view);
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView title_r,content_r,time;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            title_r=itemView.findViewById(R.id.recycle_title);
            content_r=itemView.findViewById(R.id.recycle_content);
            time=itemView.findViewById(R.id.recycle_time);
        }
    }
}
