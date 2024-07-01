package com.example.fragmentapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    //private List<Item> itemList;
    private final List<PersonItem> itemList;

    public MyAdapter(List<PersonItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PersonItem item = itemList.get(position);
        holder.firstName.setText(item.getFirstName());
        holder.lastName.setText(item.getLastName());
        holder.phone.setText(item.getPhone());
        holder.email.setText(item.getEmail());
        holder.imageView.setImageResource(item.getImageResId());

//        Item item = itemList.get(position);
//        holder.title.setText(item.getTitle());
//        holder.description.setText(item.getDescription());
//        holder.imageView.setImageResource(item.getImageResId());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView firstName;
        public TextView lastName;
        public  TextView phone;
        public TextView email;
        public ImageView imageView;

        @SuppressLint("CutPasteId")
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.item_first_name);
            lastName = itemView.findViewById(R.id.item_last_name);
            phone = itemView.findViewById(R.id.item_phone);
            email = itemView.findViewById(R.id.item_email);
            imageView = itemView.findViewById(R.id.item_image);
        }
    }

//    public static class MyViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView title;
//        public TextView description;
//        public ImageView imageView;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            title = itemView.findViewById(R.id.item_title);
//            description = itemView.findViewById(R.id.item_description);
//            imageView = itemView.findViewById(R.id.item_image);
//        }
//    }
}
