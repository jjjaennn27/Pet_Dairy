package com.example.pet_dairy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerAdapter_run extends RecyclerView.Adapter<RecyclerAdapter_run.ViewHolder> {
    ArrayList<Walk> listRun = new ArrayList<>();
    Context mContext;

    public RecyclerAdapter_run(ArrayList<Walk> bundle){
        this.listRun = bundle;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context mContext  = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_run, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Walk walk = listRun.get(position);

        holder.TimeView.setText(walk.getTime());
        holder.PlaceView.setText(walk.getPlace());
        holder.PersonView.setText(walk.getPerson());
        holder.NowView.setText(walk.getNow());
    }

    @Override
    public int getItemCount() {
        return listRun.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView TimeView;
        TextView PlaceView;
        TextView PersonView;
        TextView NowView;

        public ViewHolder(@NonNull View View) {
            super(View);
            TimeView = View.findViewById(R.id.list_time);
            PlaceView = View.findViewById(R.id.list_place);
            PersonView = View.findViewById(R.id.list_person);
            NowView = View.findViewById(R.id.list_now);
        }
    }
}