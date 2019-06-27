package com.bayuirfan.intentfragment.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bayuirfan.intentfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailCategoryFragment extends Fragment {
    public DetailCategoryFragment() {
        // Required empty public constructor
    }

    Button profile, dialog;
    TextView name, desc;

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DESC = "extra_desc";
    private String description;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profile = view.findViewById(R.id.btn_profile);
        dialog = view.findViewById(R.id.btn_show_dialog);
        name = view.findViewById(R.id.tv_category_name);
        desc = view.findViewById(R.id.tv_category_description);

        assert getArguments() != null;
        name.setText(getArguments().getString(EXTRA_NAME));
        desc.setText(getDescription());

        profile.setOnClickListener(v -> {

        });

        dialog.setOnClickListener(v -> {
            OptionDialogFragment optionDialogFragment = new OptionDialogFragment();

            FragmentManager fragmentManager = getChildFragmentManager();
            optionDialogFragment.show(fragmentManager, OptionDialogFragment.class.getSimpleName());
        });
    }

    OptionDialogFragment.OnOptionDialogListener optionDialogListener = text -> {
        Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show();
    };

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
