package com.omrobbie.myfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by omrobbie on 12/11/2017.
 */

public class OneFragment extends Fragment {

    private  static final String KEY_NAME = "KEY_NAME";

    public static OneFragment newInstance(String name) {
        OneFragment fragment = new OneFragment();

        Bundle bundle = new Bundle();
        bundle.putString(KEY_NAME, name);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        String fragmentData = getFragmentData();
        Toast.makeText(getActivity(), fragmentData, Toast.LENGTH_SHORT).show();

        return view;
    }

    private String getFragmentData() {
        Bundle bundle = getArguments();
        return bundle.getString(KEY_NAME);
    }
}
