package com.example.labprog;

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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList userItems;
    Context context;
    public Adapter(Context context, ArrayList userItems) {
        this.context = context;
        this.userItems = userItems;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Utiliza o list_item.xml definido
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        Adapter.ViewHolder viewHolder = new Adapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        UserItem item = (UserItem) userItems.get(position);

        Picasso.get().load(item.getImgUrl()).into(holder.image);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
    }

    @Override
    public int getItemCount() {
        return userItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, email;
        public ViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            email = (TextView) view.findViewById(R.id.email);
        }
    }
}
