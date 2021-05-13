package ru.com.relax;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.MyViewHolder> {

    String data1[], data2[];
    Context context;

    public RecyclerAdaptor(Context context, String arr1[], String arr2[]) {
        this.context = context;
        data1 = arr1;
        data2 = arr2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =  layoutInflater.inflate(R.layout.recycler_design, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1, myText2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.number_name);
            myText2 = itemView.findViewById(R.id.text_guide);

        }
    }
}
