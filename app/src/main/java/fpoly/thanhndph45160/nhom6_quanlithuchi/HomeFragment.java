package com.sidv.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment {
    IncomeFragment incomeFragment = new IncomeFragment();
    ExpenseFragment expenseFragment = new ExpenseFragment();

    private Button expenseButton;
    private Button incomeButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_layout, container, false);

        expenseButton = view.findViewById(R.id.radioButtonTienChi);
        incomeButton = view.findViewById(R.id.radioButtonTienThu);

        expenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragmentContent(expenseFragment);
            }
        });

        incomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragmentContent(incomeFragment);
            }
        });

        replaceFragmentContent(expenseFragment);

        return view;
    }

    protected void replaceFragmentContent(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fmgr = getChildFragmentManager();
            FragmentTransaction ft = fmgr.beginTransaction();

            Fragment existingFragment = fmgr.findFragmentById(R.id.fragment_container);
            if (existingFragment != null) {
                ft.remove(existingFragment);
            }

            ft.replace(R.id.fragment_container, fragment);
            ft.commit();
        }
    }
}