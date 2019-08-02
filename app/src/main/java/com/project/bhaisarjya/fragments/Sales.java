package com.project.bhaisarjya.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.project.bhaisarjya.R;

public class Sales extends Fragment {
    private TextView amount;
    private EditText mrp_rate;
    private EditText quantity;
    private Button add;
    private Button add_sec;
    private float amount_num;
    private float mrp;
    private int quantity_num;
    private String[] billtype = {"Credit", "Cash"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sales_layout, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        amount = view.findViewById(R.id.amount_med_sales);
        mrp_rate = view.findViewById(R.id.mrp_med_sales);
        quantity = view.findViewById(R.id.quantity_med_sales);
        add_sec = view.findViewById(R.id.add_sales_medicine_list);
        add = view.findViewById(R.id.addsalesbtn);
        AutoCompleteTextView simpleAutoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.salesbilltype);
        ArrayAdapter<String> billTypes = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, billtype);
        simpleAutoCompleteTextView.setAdapter(billTypes);
        simpleAutoCompleteTextView.setThreshold(1);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        quantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mrp = Integer.parseInt(String.valueOf(mrp_rate.getText()));
                quantity_num = Integer.parseInt(String.valueOf(quantity.getText()));
                if ((mrp != 0.0) && (quantity_num != 0)) {
                    amount_num = mrp * quantity_num;
                    amount.setText(String.valueOf(amount_num));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}

