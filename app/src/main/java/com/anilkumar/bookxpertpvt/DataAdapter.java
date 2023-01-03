package com.anilkumar.bookxpertpvt;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {


    List<Pojo> myArray = new ArrayList();

    public DataAdapter(String body) {

    }

    public void updateList(List<Pojo> myArray) {
        this.myArray = myArray;
        Log.d("TAG_5", "" + myArray.size());

    }

    public DataAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layou_tdata, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.actId.setText(String.valueOf(myArray.get(position).getActID()));
        holder.actName.setText(String.valueOf(myArray.get(position).getActName()));
        holder.amount.setText(String.valueOf(myArray.get(position).getAmount()));

    }

    @Override
    public int getItemCount() {
        return myArray.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView actId, actName, amount;
        Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            actId = itemView.findViewById(R.id.act_Id);
            actName = itemView.findViewById(R.id.act_name);
            amount = itemView.findViewById(R.id.amount);
            button = itemView.findViewById(R.id.delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = button.getContext();
                    CharSequence text = "passing data to another activity !";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    String ActId = actId.getText().toString();
                    String ActName = actName.getText().toString();
                    String Amount = amount.getText().toString();
                    Intent intent = new Intent(context, SecondActivity.class);

                    intent.putExtra("ActId", actId.getText());
                    intent.putExtra("AcName", actName.getText());
                    intent.putExtra("Amount", amount.getText());

//                    intent.putExtra("ActId",actId.getText().toString());
//                    intent.putExtra("ActName",actName.getText().toString());
//                    intent.putExtra("Amount",amount.getText().toString());
                    context.startActivity(intent);


                }
            });
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = button.getContext();
                    CharSequence text = "Hello toast!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    actId.setText(String.valueOf(actId));
                    actName.setText(String.valueOf(actName));
                    amount.setText(String.valueOf(amount));


                }
            });
        }
    }
}



