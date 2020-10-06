package com.example.education_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.AllPaymentHistory_Activity;
import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.MyBounceInterpolator;
import com.example.education_app.MyBio_Activity;
import com.example.education_app.MyParentDetails_Activity;
import com.example.education_app.PaymentHistory_Activity;
import com.example.education_app.ProductPurchaseHistory_Activity;
import com.example.education_app.R;
import com.example.education_app.Report_Activity;
import com.example.education_app.SchoolPaymentHistory_Activity;

import java.util.List;

public class History_Adapter extends RecyclerView.Adapter<History_Adapter.MyViewHolder> {

    Context context;
    List<Cities_Model> school_cats;

    public History_Adapter(Context context, List<Cities_Model> school_cats) {
        this.context = context;
        this.school_cats = school_cats;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_school_cat, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.img_cats.setImageResource(school_cats.get(position).getImage());
        holder.text_title.setText(school_cats.get(position).getText_cities());

        holder.school_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.bounce);
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.4, 40);
                myAnim.setInterpolator(interpolator);
                holder.card_img.startAnimation(myAnim);
                Intent intent = new Intent();
                switch (position){
                    case 0:
                        intent =  new Intent(context, AllPaymentHistory_Activity.class);
                        break;
                    case 1:
                        intent =  new Intent(context, ProductPurchaseHistory_Activity.class);
                        break;
                    case 2:
                        intent =  new Intent(context, PaymentHistory_Activity.class);
                        break;
                    case 3:
                        intent =  new Intent(context, Report_Activity.class);
                        break;

                    default:
                        break;
                }
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return school_cats.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_cats;
        TextView text_title;
        LinearLayout school_cat;
        CardView card_img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_cats = itemView.findViewById(R.id.img_cats);
            text_title = itemView.findViewById(R.id.text_title);
            school_cat = itemView.findViewById(R.id.school_cat);
            card_img = itemView.findViewById(R.id.card_img);
        }
    }
}
