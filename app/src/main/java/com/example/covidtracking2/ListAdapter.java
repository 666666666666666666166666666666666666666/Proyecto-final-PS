package com.example.covidtracking2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public  ListAdapter(List<ListElement>itemList,Context context)
    {
        this.mInflater=LayoutInflater.from(context);
        this.context=context;
        this.mData=itemList;

    }

    @Override
    public int getItemCount(){ return mData.size(); }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view=mInflater.inflate(R.layout.list_eval,null);
        return  new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        holder.bindData(mData.get(position));
    }
    public void setItems(List<ListElement>items){mData=items;}

    public class  ViewHolder extends  RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView name,fecha,eval;
        ViewHolder(View itemView)
        {
            super(itemView);
            iconImage=itemView.findViewById(R.id.iconImageView);
            name=itemView.findViewById(R.id.nameTextView);
            fecha=itemView.findViewById(R.id.horaTextView);
            eval=itemView.findViewById(R.id.EvalTextView);
        }
        void bindData(final ListElement item)
        {
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getName());
            fecha.setText(item.getFecha());
            eval.setText(item.getEval());
        }
    }

}
