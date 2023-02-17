package ru.dashkovskajanastassia.listexempleapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.viewHolder> {
    private  OnItemClickListener itemClickListener;
    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    private String[] dataSource;
    public ListAdapter(String[] dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int getItemCount() {
        return dataSource.length;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
                holder.getTextView().setText(dataSource[position]);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);

        return new viewHolder(v);
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textView = (TextView)itemView;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                int position = getAdapterPosition();
                if(itemClickListener != null)
                    itemClickListener.onItemClick(v, position);
                }
            });

        }

        public TextView getTextView(){
            return textView;
        }
    }

}
