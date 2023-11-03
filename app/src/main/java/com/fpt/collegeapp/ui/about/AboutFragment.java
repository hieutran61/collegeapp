package com.fpt.collegeapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fpt.collegeapp.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {
    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        list=new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_computer,"Computer Science", "Nothign here but a long text to display an example for UI"));
        list.add(new BranchModel(R.drawable.ic_computer,"Mechanical Product", "Nothign here but a long text to display an example for UI"));

        adapter = new BranchAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/my-college-app-060102.appspot.com/o/gallery%2F%5BB%4039121bjpg?alt=media&token=ba636d98-e978-496f-af86-77a2e24a33d2&fbclid=IwAR0QE3HK2O0t2xmioFL8LEl257hkQIH5kiG7JcG0YzSocXmnniFFrp-JtYw")
                .into(imageView);

        return view;
    }
}