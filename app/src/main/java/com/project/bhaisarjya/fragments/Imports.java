package com.project.bhaisarjya.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
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

import com.project.bhaisarjya.InputFilterMinMax;
import com.project.bhaisarjya.R;

public class Imports extends Fragment {
    private TextView amount;
    private EditText mrp_rate;
    private EditText quantity;
    private Button add;
    private Button add_sec;
    private Button remove;
    private EditText exp_date_year;
    private EditText exp_date_month;
    private EditText exp_date_day;
    private String[] billtype = {"Credit", "Cash"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.import_layout, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        amount = view.findViewById(R.id.amount_med_import);
        mrp_rate = view.findViewById(R.id.mrp_med_import);
        quantity = view.findViewById(R.id.quantity_med_import);
        add_sec = view.findViewById(R.id.add_import_medicine_list);
        add = view.findViewById(R.id.addimportsbtn);
        remove = view.findViewById(R.id.remove_med_from_list);
        exp_date_year = view.findViewById(R.id.expiry_year_med_import);
        exp_date_month = view.findViewById(R.id.expiry_month_med_import);
        exp_date_day = view.findViewById(R.id.expiry_day_med_import);

        exp_date_year.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "2050")});

        exp_date_month.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "12")});

        exp_date_day.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "31")});

        AutoCompleteTextView simpleAutoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.billtype);
        ArrayAdapter<String> billTypes = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, billtype);
        simpleAutoCompleteTextView.setAdapter(billTypes);
        simpleAutoCompleteTextView.setThreshold(1);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        add_sec.setOnClickListener(new View.OnClickListener() {
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
                float mrp = Integer.parseInt(String.valueOf(mrp_rate.getText()));
                int quantity_num = Integer.parseInt(String.valueOf(quantity.getText()));
                if ((mrp != 0.0) && (quantity_num != 0)) {
                    float amount_num = mrp * quantity_num;
                    amount.setText(String.valueOf(amount_num));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}

