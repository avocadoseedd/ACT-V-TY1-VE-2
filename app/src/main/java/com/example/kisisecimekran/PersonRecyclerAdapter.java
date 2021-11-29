package com.example.kisisecimekran;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonRecyclerAdapter extends RecyclerView.Adapter<PersonRecyclerAdapter.PersonHolder>{
    private ArrayList<Person> persons;

    public PersonRecyclerAdapter(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.person_layout,parent,false);
        return new PersonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonHolder holder, int position) {
     holder.tvName.setText(persons.get(position).getName());
     holder.tvPhone.setText(persons.get(position).getPhone());
     holder.ivPhoto.setImageResource(persons.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class PersonHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvPhone;
        ImageView ivPhoto;

        public PersonHolder(@NonNull View personLayout){
            super(personLayout);
            tvName=personLayout.findViewById(R.id.tv_name);
            tvPhone=personLayout.findViewById(R.id.tv_phone);
            ivPhoto=personLayout.findViewById(R.id.iv_photo);
        }



    }
}
