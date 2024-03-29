package com.project.bhaisarjya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.bhaisarjya.modal.Medicine;

import java.util.List;

public class RecyclerViewConfig {
    private Context mContext;
    private MedicineAdapter mMedicineAdapter;

    public void setConfig(RecyclerView recyclerView, Context context,List<Medicine> medicines,List<String> keys){
        mContext = context;
        mMedicineAdapter = new MedicineAdapter(medicines,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mMedicineAdapter);
    }

    public class MedicineItemView extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mCategory;
        private TextView mComposition;
        private TextView mRate;

        private String key;

        public MedicineItemView(ViewGroup viewGroup) {
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.medicine_list_item, viewGroup, false));

            mName =(TextView) viewGroup.findViewById(R.id.name);
            mCategory =(TextView) viewGroup.findViewById(R.id.category);
            mComposition =(TextView) viewGroup.findViewById(R.id.composition);
            mRate =(TextView) viewGroup.findViewById(R.id.rate);

        }

        public void bind(Medicine medicine, String key) {
            mName.setText(medicine.getName());
            mCategory.setText(medicine.getCategory());
            mComposition.setText(medicine.getComposition());
            mRate.setText(medicine.getRate());
            this.key = key;

        }
    }

    public class MedicineAdapter extends RecyclerView.Adapter<MedicineItemView> {
        private List<Medicine> mMedicineList;
        private List<String> mKeys;

        public MedicineAdapter(List<Medicine> mMedicineList, List<String> mKeys) {
            this.mMedicineList = mMedicineList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public RecyclerViewConfig.MedicineItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MedicineItemView(parent);
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

}
