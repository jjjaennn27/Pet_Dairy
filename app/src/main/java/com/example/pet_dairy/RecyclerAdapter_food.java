package com.example.pet_dairy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter_food extends RecyclerView.Adapter<RecyclerAdapter_food.ViewHolder> {
    ArrayList<Food> listFood = new ArrayList<>();
    Context mContext;

    public RecyclerAdapter_food(ArrayList<Food> bundle){
        this.listFood = bundle;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context mContext  = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_food, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = listFood.get(position);

        holder.PersonView.setText(food.getperson());
        holder.NowView.setText(food.getnow());
        holder.Food1View.setText(food.getfood1());
        holder.Food2View.setText(food.getfood2());
    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView PersonView;
        TextView NowView;
        TextView Food1View;
        TextView Food2View;

        public ViewHolder(@NonNull View View) {
            super(View);
            PersonView = View.findViewById(R.id.list_person);
            NowView = View.findViewById(R.id.list_now);
            Food1View = View.findViewById(R.id.list_food1);
            Food2View = View.findViewById(R.id.list_food2);
        }
    }
}
