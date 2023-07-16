package com.aziz.recycler_view;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class cyclerAdapter extends RecyclerView.Adapter<cyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<NotesModel> notes;

    public cyclerAdapter(Context context,ArrayList<NotesModel> notes) {
        this.context = context;
        this.notes=notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cyclerAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        setAnimation(holder.itemView,position);
        EditText phone_deo,name_deo;
        Button btn;
      holder.name.setText(notes.get(position).getName());
      holder.phone.setText(notes.get(position).getPhone());

      holder.itemView.setOnClickListener(v -> {
          Dialog dialog=new Dialog(context);
          dialog.setContentView(R.layout.custome_add);
          EditText phone_edit,name_edit;
          Button btn_edit;
          btn_edit=dialog.findViewById(R.id.add_deo);
          name_edit=dialog.findViewById(R.id.Name_neo);
          phone_edit=dialog.findViewById(R.id.Phone_neo);
          String name_previous=name_edit.getText().toString();
          holder.name.setText(notes.get(position).getName());

          btn_edit.setText("Edit");
          btn_edit.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  String name=name_edit.getText().toString();
                  if(name.isEmpty()){
                      name_edit.setError("Enter Name");
                      return;
                  }
                  String phone=phone_edit.getText().toString();
                  if(phone.isEmpty()){
                      phone_edit.setError("Enter Phone");
                      return ;
                  }

                  else {
                      notes.add(new NotesModel(name,phone));
                      notifyItemChanged(notes.size()-1);
                      dialog.dismiss();
                  }
              }
          });
          dialog.show();


      });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EditText name,phone;
        CardView AddHelp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.Name);
            phone=itemView.findViewById(R.id.Phone);
            AddHelp=itemView.findViewById(R.id.add_helper);
        }
    }
    public void setAnimation(View view,int position){
        Animation slideIn= AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        view.setAnimation(slideIn);
    }
}
