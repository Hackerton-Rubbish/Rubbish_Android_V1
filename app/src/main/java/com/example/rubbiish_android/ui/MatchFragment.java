package com.example.rubbiish_android.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.rubbiish_android.R;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;

import java.util.ArrayList;

public class MatchFragment extends Fragment implements View.OnClickListener{

    private Context context;
    private View view;
    private CardStackView cardStackView;
    private CardStackLayoutManager layoutManager;
    private MatchAdapter matchAdapter;
    private ArrayList<MatchData> matchList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context=getContext();
        view = inflater.inflate(R.layout.fragment_match, container, false);
        cardStackView = (CardStackView) view.findViewById(R.id.cardStackView);

        matchList = new ArrayList<>();
        matchList.add(new MatchData("플라스틱 병", 20));
        matchList.add(new MatchData("Test2", 30));
        matchList.add(new MatchData("Test3", 40));
        matchList.add(new MatchData("Test4", 40));
        initCardStackView();
        return view;
    }

    private void initCardStackView(){
        layoutManager = new CardStackLayoutManager(context);
        cardStackView.setLayoutManager(layoutManager);
        matchAdapter = new MatchAdapter(matchList);
        cardStackView.setAdapter(matchAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.match_reload_btn:
                    matchList.add(new MatchData("Test1", 20));
                break;
        }
    }
}