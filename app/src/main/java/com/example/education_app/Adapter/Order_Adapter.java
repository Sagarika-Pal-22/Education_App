package com.example.education_app.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.BookDetyails_Activity;
import com.example.education_app.Model.Order_Model;
import com.example.education_app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class Order_Adapter extends RecyclerView.Adapter<Order_Adapter.MyViewHolder> {
    Context context;
    List<Order_Model> order_models = new ArrayList<>();

    public Order_Adapter(Context context, List<Order_Model> order_models) {
        this.context = context;
        this.order_models = order_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_order_history, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
          holder.text_title_order.setText(order_models.get(position).getText_title_order());
          holder.text_dlvrd_date.setText(order_models.get(position).getText_dlvrd_date());

          holder.card_order_details.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialogTheme);
                  View bottomSheetView = LayoutInflater.from(context).inflate(R.layout.bottomsheet_orders_details,null);
                  final ImageView imageView= bottomSheetView.findViewById(R.id.img_close);
                  final CardView back_to_details= bottomSheetView.findViewById(R.id.back_to_details);

                  imageView.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          bottomSheetDialog.dismiss();
                      }
                  });
                  back_to_details.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          Toast.makeText(context,"product",Toast.LENGTH_LONG).show();
                          context.startActivity(new Intent(context, BookDetyails_Activity.class));
                          bottomSheetDialog.dismiss();
                      }
                  });
                  bottomSheetDialog.setContentView(bottomSheetView);
                  bottomSheetDialog.show();
              }
          });

          holder.card_review.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  AlertDialog.Builder builder = new AlertDialog.Builder(context);
                  LayoutInflater inflater = LayoutInflater.from(context);
                  final View dialogView = inflater.inflate(R.layout.dialog_product_review, null);
                  final EditText edit_review= dialogView.findViewById(R.id.edit_review);
                  final RatingBar ratingBar= dialogView.findViewById(R.id.ratingBar);
                  Button btn_submit= dialogView.findViewById(R.id.btn_submit);
                  Button btn_cancel= dialogView.findViewById(R.id.btn_cancel);
                  builder.setView(dialogView);
                  final AlertDialog alert = builder.create();
                  alert.setCanceledOnTouchOutside(true);
                  alert.show();
                  btn_cancel.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          alert.dismiss();

                      }
                  });
              }
          });
    }

    @Override
    public int getItemCount() {
        return order_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text_title_order, text_dlvrd_date;
        CardView card_review, card_order_details;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_title_order = itemView.findViewById(R.id.text_title_order);
            text_dlvrd_date = itemView.findViewById(R.id.text_dlvrd_date);
            card_review = itemView.findViewById(R.id.card_review);
            card_order_details = itemView.findViewById(R.id.card_order_details);
        }
    }
}
