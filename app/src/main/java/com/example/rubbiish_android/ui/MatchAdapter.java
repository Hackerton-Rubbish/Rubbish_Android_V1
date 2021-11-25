package com.example.rubbiish_android.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rubbiish_android.R;

import java.util.ArrayList;
import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {
    private List<MatchData> matchList;

    public MatchAdapter(ArrayList<MatchData> matchList){
        this.matchList=matchList;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName, itemCnt;

        public ViewHolder(View itemView){
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemCnt = (TextView) itemView.findViewById(R.id.item_cnt);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_match, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        MatchData matchData = matchList.get(position);
        holder.itemName.setText(matchData.getMatchItemName());
        holder.itemCnt.setText("재고: "+String.valueOf(matchData.getMatchItemCnt())+"개");
        holder.itemImage.setImageResource(matchData.getMatchItemImage());
    }

    @Override
    public int getItemCount(){
        return matchList.size();
    }
}
