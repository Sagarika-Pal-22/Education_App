package com.example.education_app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.education_app.Model.Nearby_Model;
import com.example.education_app.R;
import com.example.education_app.SchoolDetails_Activity;

import java.util.ArrayList;
import java.util.List;

public class NearbyCoachingFragment extends Fragment {

    RecyclerView rv_nearbyCoaching;
    List<Nearby_Model> nearby_models;
    Nearby_Adapter nearby_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_nearby_coaching,container,false);

        nearby_models =new ArrayList<>();

        rv_nearbyCoaching = root.findViewById(R.id.rv_nearbyCoaching);
        rv_nearbyCoaching.setHasFixedSize(true);
        rv_nearbyCoaching.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        nearby_models.add(new Nearby_Model("","Narayana Schools","2nd Floor, Rajpur marketing Sonarpur Kichukhon restaurant Building, Kolkata, West Bengal 700150",
                "4.3","2km"));
        nearby_models.add(new Nearby_Model("","Narayana Schools","2nd Floor, Rajpur marketing Sonarpur Kichukhon restaurant Building, Kolkata, West Bengal 700150",
                "4.3","2km"));
        nearby_models.add(new Nearby_Model("","Narayana Schools","2nd Floor, Rajpur marketing Sonarpur Kichukhon restaurant Building, Kolkata, West Bengal 700150",
                "4.3","2km"));
        nearby_models.add(new Nearby_Model("","Narayana Schools","2nd Floor, Rajpur marketing Sonarpur Kichukhon restaurant Building, Kolkata, West Bengal 700150",
                "4.3","2km"));
        nearby_adapter = new Nearby_Adapter(getActivity(),nearby_models);
        rv_nearbyCoaching.setAdapter(nearby_adapter);

        return root;
    }

    public class Nearby_Adapter extends RecyclerView.Adapter<Nearby_Adapter.MyViewHolder> {

        Context context;
        List<Nearby_Model> nearby_models;

        public Nearby_Adapter(Context context, List<Nearby_Model> nearby_models) {
            this.context = context;
            this.nearby_models = nearby_models;
        }

        @NonNull
        @Override
        public Nearby_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.single_nearby, parent, false);
            return new Nearby_Adapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final Nearby_Adapter.MyViewHolder holder, final int position) {

            holder.text_name.setText(nearby_models.get(position).getText_name());
            holder.text_adrss.setText(nearby_models.get(position).getText_adrss());
            holder.text_review.setText(nearby_models.get(position).getText_review());
            holder.distance.setText(nearby_models.get(position).getDistance());

            holder.animBlink = AnimationUtils.loadAnimation(context, R.anim.blink);
            holder.btn_admission.setVisibility(View.VISIBLE);
            holder.btn_admission.startAnimation(holder.animBlink);

            holder.linear_nearby.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,holder.img_nearby, ViewCompat.getTransitionName(holder.img_nearby));
                    context.startActivity(new Intent(context, SchoolDetails_Activity.class),optionsCompat.toBundle());
                }
            });

        }

        @Override
        public int getItemCount() {
            return nearby_models.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            Animation animBlink;
            ImageView img_nearby;
            TextView text_name,text_adrss,text_review,distance;
            Button btn_admission;
            LinearLayout linear_nearby;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                text_name = itemView.findViewById(R.id.text_name);
                text_adrss = itemView.findViewById(R.id.text_adrss);
                text_review = itemView.findViewById(R.id.text_review);
                distance = itemView.findViewById(R.id.distance);
                img_nearby = itemView.findViewById(R.id.img_nearby);
                btn_admission = itemView.findViewById(R.id.btn_admission);
                linear_nearby = itemView.findViewById(R.id.linear_nearby);
            }
        }

    }
}
