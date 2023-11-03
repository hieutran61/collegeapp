package com.fpt.collegeapp.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fpt.collegeapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1);

        setSliderViews();

        return view;
    }

    private void setSliderViews() {
        for (int i=0; i<5; i++) {
            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fdanang3-school.fpt.edu.vn%2Flien-he-voi-chung-toi%2F&psig=AOvVaw3707Jv08p_m6gKZa4VJLB_&ust=1699052037400000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCOihw5u0poIDFQAAAAAdAAAAABAE");
                    break;
                case 1:
                    sliderView.setImageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fdanang3-school.fpt.edu.vn%2F&psig=AOvVaw3707Jv08p_m6gKZa4VJLB_&ust=1699052037400000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCOihw5u0poIDFQAAAAAdAAAAABAJ");
                    break;
                case 2:
                    sliderView.setImageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2F253690388018085%2Fposts%2F-tuy%25E1%25BB%2583n-sinh-%25C4%2591%25E1%25BA%25A1i-h%25E1%25BB%258Dc-fpt-%25C4%2591%25C3%25A0-n%25E1%25BA%25B5ng-d%25C3%25A0nh-%25F0%259D%259F%2591%25F0%259D%259F%2597-ch%25E1%25BB%2589-ti%25C3%25AAu-b%25E1%25BB%2595-sung-2020-%25EF%25B8%258F-%25C4%2591%25C4%2583ng-k%25C3%25BD-ngay-t%25E1%25BA%25A1i%2F3296138750439885%2F&psig=AOvVaw3707Jv08p_m6gKZa4VJLB_&ust=1699052037400000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCOihw5u0poIDFQAAAAAdAAAAABAQ");
                    break;
                case 3:
                    sliderView.setImageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Fdaihocfptdanang%2F&psig=AOvVaw3707Jv08p_m6gKZa4VJLB_&ust=1699052037400000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCOihw5u0poIDFQAAAAAdAAAAABA_");
                    break;
                case 4:
                    sliderView.setImageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Ffptschoolshaiphong%2F&psig=AOvVaw3707Jv08p_m6gKZa4VJLB_&ust=1699052037400000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCOihw5u0poIDFQAAAAAdAAAAABBH");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);
        }
    }
}