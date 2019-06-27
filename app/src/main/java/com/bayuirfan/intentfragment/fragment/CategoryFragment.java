package com.bayuirfan.intentfragment.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bayuirfan.intentfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.btn_home);

        button.setOnClickListener(v -> {
            DetailCategoryFragment detailCategoryFragment = new DetailCategoryFragment();

            Bundle bundle = new Bundle();
            bundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle");
            String desc = "Description of Lifestyle Category";

            detailCategoryFragment.setArguments(bundle);
            detailCategoryFragment.setDescription(desc);

            FragmentManager fm = getFragmentManager();
            if (fm != null) {

                FragmentTransaction ft = fm.beginTransaction();

                ft.replace(R.id.frame, detailCategoryFragment, detailCategoryFragment.getClass().getSimpleName());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }
}
