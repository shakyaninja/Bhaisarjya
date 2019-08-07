package com.project.bhaisarjya.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.project.bhaisarjya.FirebaseDatabaseHelper;
import com.project.bhaisarjya.R;
import com.project.bhaisarjya.RecyclerViewConfig;
import com.project.bhaisarjya.modal.Medicine;

import java.util.List;

public class Medicines extends Fragment {
    private RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.medicine_layout, container, false);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.recyclerview_medicines);
        new FirebaseDatabaseHelper().readMedicines(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Medicine> medicines, List<String> Keys) {
                new RecyclerViewConfig().setConfig(mRecyclerView,getContext(),medicines,Keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
   }
}
