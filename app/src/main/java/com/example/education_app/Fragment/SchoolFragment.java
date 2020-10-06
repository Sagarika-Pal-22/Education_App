package com.example.education_app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.education_app.Adapter.Award_Adapter;
import com.example.education_app.Adapter.Facility_Adapter;
import com.example.education_app.Adapter.Faculty_Adapter;
import com.example.education_app.Adapter.Next_Adapter;
import com.example.education_app.Adapter.SchoolActivity_Adapter;
import com.example.education_app.Adapter.MyClass_Adapter;
import com.example.education_app.Adapter.ViewPagerAdapter;
import com.example.education_app.Model.Award_Model;
import com.example.education_app.Model.Cities_Model;
import com.example.education_app.Model.Facility_Model;
import com.example.education_app.Model.Faculty_Model;
import com.example.education_app.Model.Next_Model;
import com.example.education_app.Model.SchoolActivity_Model;
import com.example.education_app.MyTabsActivity;
import com.example.education_app.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class SchoolFragment extends Fragment {

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    int slideImages[];
    private static int currentPage=0;
    private static int numPages=0;

    LinearLayout more_activity;
    RelativeLayout rel_seeMore;

    RecyclerView rv_options,rv_school_facility,rv_awards,rv_faculty,rv_gallery;
    List<Cities_Model> cities_models;
    List<Facility_Model> facility_models;
    List<Award_Model> award_models;
    List<Faculty_Model> faculty_models;
    List<Next_Model> gallery_model;
    MyClass_Adapter myClass_adapter;
    Facility_Adapter facility_adapter;
    Faculty_Adapter faculty_adapter;
    Award_Adapter award_adapter;
    Next_Adapter gallery_adapter;
    RecyclerView rv_school_activity;
    List<SchoolActivity_Model> schoolActivity_modelList;
    SchoolActivity_Adapter schoolActivity_adapter;
//    private Toolbar toolbar;
//    private ViewPager viewPager;
//    private TabLayout tabLayout;
//
//    private Notice_Fragment notice_fragment;
//    private TimeTable_Fragment timeTable_fragment;
//    private Attendance_Fragment attendance_fragment;
//    private Homework_Fragment homework_fragment;
//    private ExamSchedule_Fragment examSchedule_fragment;
//    private PaymentStatus_Fragment paymentStatus_fragment;
//    private ReportCard_Fragment reportCard_fragment;
//    private RatingReviews_Fragment ratingReviews_fragment;
//    private Ediary_Fragment ediary_fragment;
//    private Library_fragment library_fragment;
//    private Tranportation_Fragment tranportation_fragment;
//    private SchoolActivities_Fragment schoolActivities_fragment;
//    private Communication_Fragment communication_fragment;
//    private AdmissionDetails_Fragment admissionDetails_fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root =inflater.inflate(R.layout.fragment_school,container,false);

        cities_models = new ArrayList<>();
        facility_models = new ArrayList<>();
        award_models = new ArrayList<>();
        faculty_models =new ArrayList<>();
        gallery_model =new ArrayList<>();
        schoolActivity_modelList = new ArrayList<>();

        viewPager = root.findViewById(R.id.viewPager);
        more_activity = root.findViewById(R.id.more_activity);
        rel_seeMore = root.findViewById(R.id.rel_seeMore);

        slideImages = new int[]{R.drawable.schl_1, R.drawable.sch_2, R.drawable.sch_3};
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

        rv_options = root.findViewById(R.id.rv_options);
        rv_options.setHasFixedSize(true);
        rv_options.setLayoutManager(new GridLayoutManager(getActivity(),3));
        cities_models.add(new Cities_Model(R.drawable.library,"Syllabus"));
        cities_models.add(new Cities_Model(R.drawable.person,"My Teacher"));
        cities_models.add(new Cities_Model(R.drawable.rate_tchr,"Class Work"));
        cities_models.add(new Cities_Model(R.drawable.homework,"Home Work"));
        cities_models.add(new Cities_Model(R.drawable.e_diary,"Assigned projects"));
        myClass_adapter = new MyClass_Adapter(getActivity(),cities_models);
        rv_options.setAdapter(myClass_adapter);

        rel_seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyTabsActivity.class);
                startActivity(intent);
            }
        });

        rv_school_activity = root.findViewById(R.id.rv_school_activity);
        rv_school_activity.setHasFixedSize(true);
        rv_school_activity.setLayoutManager(new GridLayoutManager(getActivity(),2));
        schoolActivity_modelList.add(new SchoolActivity_Model(R.drawable.karate,"Karate"));
        schoolActivity_modelList.add(new SchoolActivity_Model(R.drawable.yoga,"Yoga"));
        schoolActivity_modelList.add(new SchoolActivity_Model(R.drawable.swim,"Swimming"));
        schoolActivity_modelList.add(new SchoolActivity_Model(R.drawable.dance,"Dancing"));
        schoolActivity_adapter = new SchoolActivity_Adapter(getActivity(),schoolActivity_modelList);
        rv_school_activity.setAdapter(schoolActivity_adapter);

        rv_school_facility =root.findViewById(R.id.rv_school_facility);
        rv_school_facility.setHasFixedSize(true);
        rv_school_facility.setLayoutManager(new GridLayoutManager(getActivity(),2));
        facility_models.add(new Facility_Model("Free Wifi"));
        facility_models.add(new Facility_Model("CCTV Cameras"));
        facility_models.add(new Facility_Model("Reception"));
        facility_models.add(new Facility_Model("School Bus"));
        facility_models.add(new Facility_Model("Computer Lab"));
        facility_models.add(new Facility_Model("First Aid"));
        facility_models.add(new Facility_Model("Security"));
        facility_models.add(new Facility_Model("Toilets"));
        facility_models.add(new Facility_Model("Fire Extinguisher"));
        facility_models.add(new Facility_Model("Fire Alarm"));
        facility_models.add(new Facility_Model("Air Conditioned classrooms"));
        facility_models.add(new Facility_Model("Water Purifier"));
        facility_models.add(new Facility_Model("Nice Sitting Arrangements"));
        facility_models.add(new Facility_Model("Playground"));
        facility_models.add(new Facility_Model("Library and Study rooms"));
        facility_models.add(new Facility_Model("Canteen"));
        facility_models.add(new Facility_Model("Hall rooms"));
        facility_adapter = new Facility_Adapter(getActivity(),facility_models);
        rv_school_facility.setAdapter(facility_adapter);

        rv_awards = root.findViewById(R.id.rv_awards);
        rv_awards.setHasFixedSize(true);
        rv_awards.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        award_models.add(new Award_Model(""));
        award_models.add(new Award_Model(""));
        award_models.add(new Award_Model(""));
        award_models.add(new Award_Model(""));
        award_models.add(new Award_Model(""));
        award_adapter = new Award_Adapter(getActivity(),award_models);
        rv_awards.setAdapter(award_adapter);

        rv_faculty = root.findViewById(R.id.rv_faculty);
        rv_faculty.setHasFixedSize(true);
        rv_faculty.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_models.add(new Faculty_Model(R.drawable.tutor,"Santanu Kasyap"));
        faculty_adapter = new Faculty_Adapter(getActivity(),faculty_models);
        rv_faculty.setAdapter(faculty_adapter);

        rv_gallery = root.findViewById(R.id.rv_gallery);
        rv_gallery.setHasFixedSize(true);
        rv_gallery.setLayoutManager(new GridLayoutManager(getActivity(),3));
        gallery_model.add(new Next_Model(""));
        gallery_model.add(new Next_Model(""));
        gallery_model.add(new Next_Model(""));
        gallery_model.add(new Next_Model(""));
        gallery_model.add(new Next_Model(""));
        gallery_model.add(new Next_Model(""));
        gallery_model.add(new Next_Model(""));
        gallery_model.add(new Next_Model(""));
        gallery_adapter = new Next_Adapter(getActivity(),gallery_model);
        rv_gallery.setAdapter(gallery_adapter);



//        viewPager = root.findViewById(R.id.viewpager);
//        tabLayout = root.findViewById(R.id.tabLayout);
//
//        notice_fragment = new Notice_Fragment();
//        timeTable_fragment = new TimeTable_Fragment();
//        attendance_fragment = new Attendance_Fragment();
//        homework_fragment = new Homework_Fragment();
//        examSchedule_fragment = new ExamSchedule_Fragment();
//        paymentStatus_fragment = new PaymentStatus_Fragment();
//        reportCard_fragment = new ReportCard_Fragment();
//        ratingReviews_fragment = new RatingReviews_Fragment();
//        ediary_fragment = new Ediary_Fragment();
//        library_fragment = new Library_fragment();
//        tranportation_fragment = new Tranportation_Fragment();
//        schoolActivities_fragment = new SchoolActivities_Fragment();
//        communication_fragment = new Communication_Fragment();
//        admissionDetails_fragment = new AdmissionDetails_Fragment();
//
//        tabLayout.setupWithViewPager(viewPager);

//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getParentFragmentManager(), 0);
//        viewPagerAdapter.addFragment(tranportation_fragment, "Transportation Track");
//        viewPagerAdapter.addFragment(schoolActivities_fragment, "School Activity");
//        viewPagerAdapter.addFragment(notice_fragment, "Notice Board");
//        viewPagerAdapter.addFragment(ediary_fragment, "E-Diary");
//        viewPagerAdapter.addFragment(timeTable_fragment, "Time table");
//        viewPagerAdapter.addFragment(attendance_fragment, "Attendance");
//        viewPagerAdapter.addFragment(communication_fragment, "Communication");
//        viewPagerAdapter.addFragment(homework_fragment, "Homework");
//        viewPagerAdapter.addFragment(examSchedule_fragment, "Exam Schedule");
//        viewPagerAdapter.addFragment(reportCard_fragment, "Report Card");
//        viewPagerAdapter.addFragment(ratingReviews_fragment, "Rating & Reviews");
//        viewPagerAdapter.addFragment(library_fragment, "Library Books");
//        viewPagerAdapter.addFragment(paymentStatus_fragment, "Payment Status");
//        viewPagerAdapter.addFragment(admissionDetails_fragment, "Admission Details");
//        viewPager.setAdapter(viewPagerAdapter);
//
//        tabLayout.getTabAt(0).setIcon(R.drawable.transportation);
//        tabLayout.getTabAt(1).setIcon(R.drawable.activity);
//        tabLayout.getTabAt(2).setIcon(R.drawable.notice);
//        tabLayout.getTabAt(3).setIcon(R.drawable.e_diary);
//        tabLayout.getTabAt(4).setIcon(R.drawable.timetable);
//        tabLayout.getTabAt(5).setIcon(R.drawable.progress);
//        tabLayout.getTabAt(6).setIcon(R.drawable.communication);
//        tabLayout.getTabAt(7).setIcon(R.drawable.homework);
//        tabLayout.getTabAt(8).setIcon(R.drawable.exam);
//        tabLayout.getTabAt(9).setIcon(R.drawable.report_card);
//        tabLayout.getTabAt(10).setIcon(R.drawable.rate_tchr);
//        tabLayout.getTabAt(11).setIcon(R.drawable.library);
//        tabLayout.getTabAt(12).setIcon(R.drawable.payment);
//        tabLayout.getTabAt(13).setIcon(R.drawable.admission_details);

        return root;
    }


//    private class ViewPagerAdapter extends FragmentPagerAdapter {
//
//        private List<Fragment> fragments = new ArrayList<>();
//        private List<String> fragmentTitle = new ArrayList<>();
//
//        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
//            super(fm, behavior);
//        }
//
//        public void addFragment(Fragment fragment, String title) {
//            fragments.add(fragment);
//            fragmentTitle.add(title);
//        }
//
//        @NonNull
//        @Override
//        public Fragment getItem(int position) {
//            return fragments.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return fragments.size();
//        }
//
//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return fragmentTitle.get(position);
//        }
//    }
}
