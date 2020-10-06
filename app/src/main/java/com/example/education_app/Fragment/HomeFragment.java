package com.example.education_app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.education_app.Adapter.Book_Adapter;
import com.example.education_app.Adapter.Cities_Adapter;
import com.example.education_app.Adapter.Coaching_Adapter;
import com.example.education_app.Adapter.Offer_Adapter;
import com.example.education_app.Adapter.School_Adapter;
import com.example.education_app.Adapter.Tutors_Adapter;
import com.example.education_app.Adapter.ViewPagerAdapter;
import com.example.education_app.Model.Book_Model;
import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.Offer_Model;
import com.example.education_app.Model.School_Model;
import com.example.education_app.Model.Tutors_Model;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {

    TextView all_books;

    RecyclerView recycler_cities,rv_rcmnd_schols,rv_userOffer,rv_coaching,rv_books,rv_privateTutor;
    List<Cities_Model> cities_modelList;
    List<School_Model> school_modelList;
    List<School_Model> prvt_tutionsList;
    List<Offer_Model> offer_models;
    List<Book_Model> book_modelList;
    List<Tutors_Model> tutors_models;
    Cities_Adapter cities_adapter;
    School_Adapter school_adapter;
    Offer_Adapter offer_adapter;
    Book_Adapter book_adapter;
    Tutors_Adapter tutors_adapter;
    Coaching_Adapter coaching_adapter;

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    int slideImages[];
    private static int currentPage=0;
    private static int numPages=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = root.findViewById(R.id.viewPager);
        all_books = root.findViewById(R.id.all_books);

        cities_modelList =new ArrayList<>();
        school_modelList =new ArrayList<>();
        prvt_tutionsList =new ArrayList<>();
        offer_models =new ArrayList<>();
        book_modelList =new ArrayList<>();
        tutors_models =new ArrayList<>();

        slideImages = new int[]{R.drawable.pic_1, R.drawable.pic_2, R.drawable.pic_3, R.drawable.pic_4};
        viewPagerAdapter =new ViewPagerAdapter(getActivity(),slideImages);
        viewPager.setAdapter(viewPagerAdapter);
        CircleIndicator indicator = root.findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentPage = i;

            }

            @Override
            public void onPageScrollStateChanged(int i) {

                if (i == ViewPager.SCROLL_STATE_IDLE) {
                    int pagecount = slideImages.length;
                    if (currentPage == 0) {
                        viewPager.setCurrentItem(pagecount - 1, false);
                    } else if (currentPage == pagecount - 1) {
                        viewPager.setCurrentItem(0, false);
                    }
                }
            }
        });
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPage==numPages){
                    currentPage=0;
                }
                viewPager.setCurrentItem(currentPage++,true);
            }
        };
        Timer swipe = new Timer();
        swipe.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },1000,1000);

        recycler_cities = root.findViewById(R.id.recycler_cities);
        recycler_cities.setHasFixedSize(true);
        recycler_cities.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        cities_modelList.add(new Cities_Model(R.drawable.location,"Nearby"));
        cities_modelList.add(new Cities_Model(R.drawable.kol,"Kolkata"));
        cities_modelList.add(new Cities_Model(R.drawable.delhi,"Delhi"));
        cities_modelList.add(new Cities_Model(R.drawable.kol,"Kolkata"));
        cities_modelList.add(new Cities_Model(R.drawable.delhi,"Delhi"));
        cities_modelList.add(new Cities_Model(R.drawable.kol,"Kolkata"));
        cities_modelList.add(new Cities_Model(R.drawable.delhi,"Delhi"));
        cities_adapter = new Cities_Adapter(getActivity(),cities_modelList);
        recycler_cities.setAdapter(cities_adapter);

        rv_rcmnd_schols = root.findViewById(R.id.rv_rcmnd_schols);
        rv_rcmnd_schols.setHasFixedSize(true);
        rv_rcmnd_schols.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        school_modelList.add(new School_Model("","4.2","Narayana Schools","2nd Floor, Rajpur marketing Sonarpur Kichukhon",
                "913","50","46 % OFF"));
        school_modelList.add(new School_Model("","4.2","Narayana Schools","2nd Floor, Rajpur marketing Sonarpur Kichukhon",
                "913","50","46 % OFF"));
        school_modelList.add(new School_Model("","4.2","Narayana Schools","2nd Floor, Rajpur marketing Sonarpur Kichukhon",
                "913","50","46 % OFF"));
        school_modelList.add(new School_Model("","4.2","Narayana Schools","2nd Floor, Rajpur marketing Sonarpur Kichukhon",
                "913","50","46 % OFF"));
        school_adapter = new School_Adapter(getActivity(),school_modelList);
        rv_rcmnd_schols.setAdapter(school_adapter);

        rv_books = root.findViewById(R.id.rv_books);
        rv_books.setHasFixedSize(true);
        rv_books.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        book_modelList.add(new Book_Model(R.drawable.book_1,"Nuclear Physics","by Priyanka Jangid","Publishers","750","4.6"));
        book_modelList.add(new Book_Model(R.drawable.book_2,"ISC Chemistry","by Sannkish Devo","Publishers","850","5.0"));
        book_modelList.add(new Book_Model(R.drawable.book_3,"Applied Biology","by Priyanka Jangid","Publishers","900","4.8"));
        book_modelList.add(new Book_Model(R.drawable.book_1,"Nuclear Physics","by Sannkish Devo","Publishers","850","4.2"));
        book_modelList.add(new Book_Model(R.drawable.book_2,"ISC Chemistry","by Priyanka Jangid","Publishers","750","3.8"));
        book_adapter = new Book_Adapter(getActivity(),book_modelList);
        rv_books.setAdapter(book_adapter);

        rv_userOffer = root.findViewById(R.id.rv_userOffer);
        rv_userOffer.setHasFixedSize(true);
        rv_userOffer.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        offer_models.add(new Offer_Model("We're open today & everyday","599"));
        offer_models.add(new Offer_Model("Enjoy 50% of discount on your books","342"));
        offer_adapter = new Offer_Adapter(getActivity(),offer_models);
        rv_userOffer.setAdapter(offer_adapter);

        rv_coaching = root.findViewById(R.id.rv_coaching);
        rv_coaching.setHasFixedSize(true);
        rv_coaching.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        prvt_tutionsList.add(new School_Model("","5.0","Maths and Economics private home tuition","2, Swami Vivekananda Rd, West Rajapur,",
                "500","000",""));
        prvt_tutionsList.add(new School_Model("","4.2","Surajita Private Tuition Centre","6/1 A, Green Park, Kusum Kanan, Garia,",
                "600","000","46 % OFF"));
        prvt_tutionsList.add(new School_Model("","4.2","Maths and Economics private home tuition","2nd Floor, Rajpur marketing Sonarpur Kichukhon",
                "750","000",""));
        prvt_tutionsList.add(new School_Model("","4.2","Surajita Private Tuition Centre","6/1 A, Green Park, Kusum Kanan, Garia,",
                "900","000","46 % OFF"));
        coaching_adapter = new Coaching_Adapter(getActivity(),prvt_tutionsList);
        rv_coaching.setAdapter(coaching_adapter);

        rv_privateTutor = root.findViewById(R.id.rv_privateTutor);
        rv_privateTutor.setHasFixedSize(true);
        rv_privateTutor.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        tutors_models.add(new Tutors_Model("","Debjit Mukherjee","2nd Floor, Rajpur marketing Sonarpur Kichukhon","4.3"));
        tutors_models.add(new Tutors_Model("","Debjit Mukherjee","2nd Floor, Rajpur marketing Sonarpur Kichukhon","4.3"));
        tutors_models.add(new Tutors_Model("","Debjit Mukherjee","2nd Floor, Rajpur marketing Sonarpur Kichukhon","4.3"));
        tutors_models.add(new Tutors_Model("","Debjit Mukherjee","2nd Floor, Rajpur marketing Sonarpur Kichukhon","4.3"));
        tutors_adapter = new Tutors_Adapter(getActivity(),tutors_models);
        rv_privateTutor.setAdapter(tutors_adapter);

        return root;
    }
}
