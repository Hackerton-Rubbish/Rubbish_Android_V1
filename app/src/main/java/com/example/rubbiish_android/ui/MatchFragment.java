package com.example.rubbiish_android.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rubbiish_android.R;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.StackFrom;

import java.util.ArrayList;

public class MatchFragment extends Fragment implements View.OnClickListener{

    private Context context;
    private View view;
    private CardStackView cardStackView;
    private CardStackLayoutManager layoutManager;
    private MatchAdapter matchAdapter;
    private ArrayList<MatchData> matchList;
    private ImageView reloadMatch;
    private TextView write_match;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context=getContext();
        view = inflater.inflate(R.layout.fragment_match, container, false);

        cardStackView = (CardStackView) view.findViewById(R.id.card_stack_view);
        layoutManager = new CardStackLayoutManager(context);
        cardStackView.setLayoutManager(layoutManager);
        layoutManager.setStackFrom(StackFrom.Top);

        reloadMatch = view.findViewById(R.id.match_reload_btn);
        reloadMatch.setOnClickListener(this::onClick);
        write_match = view.findViewById(R.id.write_match);
        write_match.setOnClickListener(this::onClick);

        matchList = new ArrayList<>();
        matchList.add(new MatchData("플라스틱 병", 20, R.drawable.ic_trash));
        matchList.add(new MatchData("Test2", 30, R.drawable.ic_trash));
        matchList.add(new MatchData("Test3", 40, R.drawable.ic_trash));
        matchList.add(new MatchData("Test4", 40, R.drawable.ic_trash));

        loadCardStackView();
        return view;
    }

    private void loadCardStackView(){
        matchAdapter = new MatchAdapter(matchList);
        cardStackView.removeAllViewsInLayout();
        cardStackView.setAdapter(matchAdapter);
        matchAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.match_reload_btn:
                matchList = new ArrayList<>();
                matchList.add(new MatchData("플라스틱 병", 20, R.drawable.ic_trash));
                matchList.add(new MatchData("Test2", 30, R.drawable.ic_trash));
                matchList.add(new MatchData("Test3", 40, R.drawable.ic_trash));
                matchList.add(new MatchData("Test4", 40, R.drawable.ic_trash));
                loadCardStackView();
                break;
            case R.id.write_match:
                Intent intent = new Intent(context, WriteMatchActivity.class);
                context.startActivity(intent);
                break;
        }
    }
}