package com.example.rubbiish_android.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubbiish_android.R;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;

public class matchFragment extends Fragment {

    private Context context;
    private View view;
    private CardStackView cardStackView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context=getContext();
        view = inflater.inflate(R.layout.fragment_match, container, false);
        cardStackView = (CardStackView) view.findViewById(R.id.cardStackView);
        return view;
    }

    private void initCardStackView(){
        cardStackView.setLayoutManager(new CardStackLayoutManager(context, (CardStackListener) this));
    }
}