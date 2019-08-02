package com.project.bhaisarjya;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.bhaisarjya.modal.Medicine;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceMedicine;
    private List<Medicine> medicines = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Medicine> medicines,List<String> Keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceMedicine=mDatabase.getReference("medicines");
    }
    public void readMedicines(final DataStatus dataStatus){
        mReferenceMedicine.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                medicines.clear();
                List<String> keys= new ArrayList<>();
                for (DataSnapshot keyNode :dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Medicine medicine = keyNode.getValue(Medicine.class);
                    medicines.add(medicine);
                }
                dataStatus.DataIsLoaded(medicines,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
