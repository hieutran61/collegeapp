package com.fpt.collegeapp.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fpt.collegeapp.R;
import com.fpt.collegeapp.faculty.TeacherAdapter;
import com.fpt.collegeapp.faculty.TeacherData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {
    private RecyclerView csDepartment, mechanicalDepartment, physicsDepartment, chemistryDepartment;
    private LinearLayout csNoData, mechNoData, physicsNoData, chemistryNoData;
    private List<User_TeacherData> list1, list2, list3, list4;
    private User_TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        csDepartment = view.findViewById(R.id.csDepartment);
        mechanicalDepartment = view.findViewById(R.id.mechanicaalDepartment);
        physicsDepartment = view.findViewById(R.id.physicsDepartment);
        chemistryDepartment = view.findViewById(R.id.chemistryDepartment);

        csNoData = view.findViewById(R.id.csNoData);
        mechNoData = view.findViewById(R.id.mechNoData);
        physicsNoData = view.findViewById(R.id.physicsNoData);
        chemistryNoData = view.findViewById(R.id.chemistryNoData);

        reference = FirebaseDatabase.getInstance("https://my-college-app-060102-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("teacher");

        csDepartment();
        mechanicalDepartment();
        physicsDepartment();
        chemistryDepartment();

        return view;
    }

    private void csDepartment() {
        dbRef = reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                } else {
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()) {
                        User_TeacherData data = snapshot1.getValue(User_TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new User_TeacherAdapter(list1, getContext());
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mechanicalDepartment() {
        dbRef = reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()){
                    mechNoData.setVisibility(View.VISIBLE);
                    mechanicalDepartment.setVisibility(View.GONE);
                } else {
                    mechNoData.setVisibility(View.GONE);
                    mechanicalDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()) {
                        User_TeacherData data = snapshot1.getValue(User_TeacherData.class);
                        list2.add(data);
                    }
                    mechanicalDepartment.setHasFixedSize(true);
                    mechanicalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new User_TeacherAdapter(list2, getContext());
                    mechanicalDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void physicsDepartment() {
        dbRef = reference.child("Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()){
                    physicsNoData.setVisibility(View.VISIBLE);
                    physicsDepartment.setVisibility(View.GONE);
                } else {
                    physicsNoData.setVisibility(View.GONE);
                    physicsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()) {
                        User_TeacherData data = snapshot1.getValue(User_TeacherData.class);
                        list3.add(data);
                    }
                    physicsDepartment.setHasFixedSize(true);
                    physicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new User_TeacherAdapter(list3, getContext());
                    physicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void chemistryDepartment() {
        dbRef = reference.child("Chemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()){
                    chemistryNoData.setVisibility(View.VISIBLE);
                    chemistryDepartment.setVisibility(View.GONE);
                } else {
                    chemistryNoData.setVisibility(View.GONE);
                    chemistryDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1: snapshot.getChildren()) {
                        User_TeacherData data = snapshot1.getValue(User_TeacherData.class);
                        list4.add(data);
                    }
                    chemistryDepartment.setHasFixedSize(true);
                    chemistryDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new User_TeacherAdapter(list4, getContext());
                    chemistryDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}