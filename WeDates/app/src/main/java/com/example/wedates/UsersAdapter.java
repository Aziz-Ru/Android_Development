package com.example.wedates;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder>  {

ArrayList<UserData> list;
Context context;

    public UsersAdapter(ArrayList<UserData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.chat_friends,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.ViewHolder holder, int position) {
     UserData User=list.get(position);
        Picasso.get().load(User.getProfile_pic()).placeholder(R.drawable.baseline_account_circle_24).into(holder.image);
     holder.profile_name.setText(User.getUser_name());
     holder.Last_message.setText(User.getLast_message());
     holder.last_time.setText(User.getSend_Time());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView profile_name,Last_message,last_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.profile_image);
            profile_name=itemView.findViewById(R.id.Profile_Name);
            Last_message=itemView.findViewById(R.id.Last_message);
            last_time=itemView.findViewById(R.id.Last_time);
        }
    }


}
