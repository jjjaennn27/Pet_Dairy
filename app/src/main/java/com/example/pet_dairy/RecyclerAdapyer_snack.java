package com.example.pet_dairy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapyer_snack extends RecyclerView.Adapter<RecyclerAdapyer_snack.ViewHolder> {
    ArrayList<Snack> listSnack = new ArrayList<>();
    Context mContext;

    public RecyclerAdapyer_snack(ArrayList<Snack> bundle){
        this.listSnack = bundle;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context mContext  = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_snack, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Snack snack = listSnack.get(position);

        holder.GiveView.setText(snack.getGive());
        holder.TypeView.setText(snack.getType());
        holder.DateView.setText(snack.getDate());
        holder.ManyView.setText(snack.getMany());
    }

    @Override
    public int getItemCount() {
        return listSnack.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView GiveView;
        TextView TypeView;
        TextView DateView;
        TextView ManyView;

        public ViewHolder(@NonNull View View) {
            super(View);
            GiveView = View.findViewById(R.id.list_Give);
            TypeView = View.findViewById(R.id.list_Type);
            DateView = View.findViewById(R.id.list_Date);
            ManyView = View.findViewById(R.id.list_Many);
        }
    }
}