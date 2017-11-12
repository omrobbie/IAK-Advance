package com.omrobbie.myfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by omrobbie on 12/11/2017.
 */

public class OneFragment extends Fragment implements View.OnClickListener {

    private static final String KEY_NAME = "KEY_NAME";
    private static final String KEY_COUNT = "KEY_COUNT";

    private int count;

    private Button btnAdd;
    private TextView tvText;

    public static OneFragment newInstance(String name, int count) {
        OneFragment fragment = new OneFragment();

        Bundle bundle = new Bundle();
        bundle.putString(KEY_NAME, name);
        bundle.putInt(KEY_COUNT, count);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_one, container, false);

        String fragmentData = getFragmentData();
        Toast.makeText(getActivity(), fragmentData, Toast.LENGTH_SHORT).show();

        btnAdd = root.findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);

        tvText = root.findViewById(R.id.tv_text);
        tvText.setText("Fragment " + count);

        return root;
    }

    private String getFragmentData() {
        Bundle bundle = getArguments();
        count = bundle.getInt(KEY_COUNT);
        return bundle.getString(KEY_NAME);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                count++;
                getFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, OneFragment.newInstance("Data " + count, count), null)
                        .commit();
                break;
        }
    }
}
