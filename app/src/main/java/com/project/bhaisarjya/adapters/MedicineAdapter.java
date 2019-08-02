package com.project.bhaisarjya.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.bhaisarjya.RecyclerViewConfig;
import com.project.bhaisarjya.modal.Medicine;

import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<RecyclerViewConfig.MedicineItemView> {
    private List<Medicine> mMedicineList;
    private List<String> mKeys;

    public MedicineAdapter(List<Medicine> mMedicineList, List<String> mKeys) {
        this.mMedicineList = mMedicineList;
        this.mKeys = mKeys;
    }

    @NonNull
    @Override
    public RecyclerViewConfig.MedicineItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewConfig.MedicineItemView(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewConfig.MedicineItemView holder, int position) {
        holder.bind(mMedicineList.get(position), mKeys.get(position));
    }

    @Override
    public int getItemCount() {
        return mMedicineList.size();
    }
}

