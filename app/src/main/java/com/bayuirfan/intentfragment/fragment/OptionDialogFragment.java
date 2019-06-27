package com.bayuirfan.intentfragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bayuirfan.intentfragment.R;

public class OptionDialogFragment extends DialogFragment {

    public OptionDialogFragment(){

    }

    Button btnChoose, btnClose;
    RadioGroup optionGroup;
    RadioButton opt1, opt2, opt3, opt4;
    OnOptionDialogListener optionDialogListener;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnChoose = view.findViewById(R.id.btn_select_dialog);
        btnClose = view.findViewById(R.id.btn_close);
        opt1 = view.findViewById(R.id.radio_1_d);
        opt2 = view.findViewById(R.id.radio_2_d);
        opt3 = view.findViewById(R.id.radio_3_d);
        opt4 = view.findViewById(R.id.radio_4_d);
        optionGroup = view.findViewById(R.id.radio_group_dialog);

        btnChoose.setOnClickListener(v -> {
            int checkedRadioButtonId = optionGroup.getCheckedRadioButtonId();

            if (checkedRadioButtonId != -1){
                String selectedValue = null;
                switch (checkedRadioButtonId){
                    case R.id.radio_1_d:
                        selectedValue = opt1.getText().toString().trim();
                        break;
                    case R.id.radio_2_d:
                        selectedValue = opt2.getText().toString().trim();
                        break;
                    case R.id.radio_3_d:
                        selectedValue = opt3.getText().toString().trim();
                        break;
                    case R.id.radio_4_d:
                        selectedValue = opt4.getText().toString().trim();
                        break;
                    default:
                        selectedValue = "";
                        break;
                }

                if (optionDialogListener != null){
                    optionDialogListener.onOptionSelected(selectedValue);
                }
                getDialog().dismiss();
            }
        });

        btnClose.setOnClickListener(v -> getDialog().cancel());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Fragment fragment = getParentFragment();

        if (fragment instanceof DetailCategoryFragment){
            DetailCategoryFragment detailCategoryFragment = (DetailCategoryFragment) fragment;
            this.optionDialogListener = detailCategoryFragment.optionDialogListener;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }

    interface OnOptionDialogListener{
        void onOptionSelected(String text);
    }
}
