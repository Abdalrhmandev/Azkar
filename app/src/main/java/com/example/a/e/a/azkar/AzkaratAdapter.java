package com.example.a.e.a.azkar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Doctors-AEA on 11/9/2016.
 */

class AzkaratAdapter extends RecyclerView.Adapter<AzkaratAdapter.MyMViewHolder> {


    private LayoutInflater inflater;


    private List<AzkarInformation> data = Collections.emptyList();

    AzkaratAdapter(Context context, List<AzkarInformation> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyMViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = inflater.inflate(R.layout.custom_row, parent, false);
        return new MyMViewHolder(v);


    }

    @Override
    public void onBindViewHolder(MyMViewHolder holder, final int position) {

        AzkarInformation current = data.get(position);

        holder.textView.setText(current.zikr);
        holder.textView1.setText(current.fadl);
        holder.textView2.setText(current.repeat);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyMViewHolder extends RecyclerView.ViewHolder {

        TextView textView, textView1, textView2;

        MyMViewHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textzikr);
            textView1 = (TextView) itemView.findViewById(R.id.textfadl);
            textView2 = (TextView) itemView.findViewById(R.id.textrepeat);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    delete(getAdapterPosition());
                    notifyItemChanged(getAdapterPosition());

                }
            });


        }

    }

    private void delete(int position) {
        if (position!=-1) {
            data.remove(position);
            notifyItemRemoved(position);
        }
    }


}
