package com.example.pet_dairy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class WalkingMate_Board_RecyclerAdapter extends RecyclerView.Adapter<WalkingMate_Board_RecyclerAdapter.ViewHolder> {
    ArrayList<Board> listBundle = new ArrayList<>();
    Context mContext;

    public WalkingMate_Board_RecyclerAdapter(ArrayList<Board> bundle){
        this.listBundle = bundle;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context mContext  = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.walingmate_board_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Board  board = listBundle.get(position);

        holder.PliceView.setText(board.getPlace());
        holder.TimeView.setText(board.getTime());
        holder.Dog_breedView.setText(board.getDog_breed());
        holder.IDView.setText(board.getID());
    }

    @Override
    public int getItemCount() {
        return listBundle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView PliceView;
        TextView TimeView;
        TextView Dog_breedView;
        TextView IDView;

        public ViewHolder(@NonNull View View) {
            super(View);
            PliceView = View.findViewById(R.id.list_Place);
            TimeView = View.findViewById(R.id.list_Time);
            Dog_breedView = View.findViewById(R.id.list_Dog_breed);
            IDView = View.findViewById(R.id.list_ID);
        }
    }


}