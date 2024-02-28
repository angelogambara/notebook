package com.example.serializable;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final Address[] addresses;

    public Adapter(Address[] addresses) {
        this.addresses = addresses;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout layout;
        public TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView.findViewById(R.id.recyclerview_item);
            this.textView = itemView.findViewById(R.id.textView);
        }
    }

    @Override @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.recyclerview_item, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final int adapterPosition = holder.getAdapterPosition();

        holder.textView.setText(addresses[adapterPosition].toString());
        holder.layout.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), NextActivity.class);
            intent.putExtra("Address", addresses[adapterPosition]);
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return addresses.length;
    }
}
