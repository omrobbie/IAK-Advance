package com.omrobbie.myfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.omrobbie.myfragment.listener.HostToFragmentListener;

/**
 * Created by omrobbie on 12/11/2017.
 */

public class TwoFragment extends Fragment implements HostToFragmentListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_two, container, false);

        ((MainActivity) getActivity()).setHostToFragmentListener(this);

        return root;
    }

    @Override
    public void onDataReceiveInFragment(String data) {
        Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
    }
}
