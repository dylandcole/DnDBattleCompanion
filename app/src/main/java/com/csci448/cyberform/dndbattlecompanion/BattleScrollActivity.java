package com.csci448.cyberform.dndbattlecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coleman on 3/2/18.
 */

public class BattleScrollActivity extends AppCompatActivity {

    private RecyclerView mSimpleScrollRecyclerView;
    private BattleScrollActivity.BattleScrollAdapter mAdapter;
    private ArrayList<Battle> battles = new ArrayList<Battle>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_scroll);

        mSimpleScrollRecyclerView = (RecyclerView) findViewById(R.id.simple_scroll_view);
        mSimpleScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < 10; i++) {
            Battle battle = new Battle();
            battle.setName("Battle " + Integer.toString(i));
            battles.add(battle);
        }

        updateUI();
    }

    //Runs to ensure the lists are up to date with the user's actions
    private void updateUI() {
        mAdapter = new BattleScrollActivity.BattleScrollAdapter(battles);
        mSimpleScrollRecyclerView.setAdapter(mAdapter);
    }

    //Inflates the defined fragment and determines fragment behavior
    private class BattleScrollHolder extends RecyclerView.ViewHolder {

        private Button mBattleSelectButton;
        private Battle mBattle;

        public BattleScrollHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_simple_scroll, parent, false));

            mBattleSelectButton = (Button) itemView.findViewById(R.id.battles_button);
            mBattleSelectButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(BattleScrollActivity.this, CampaignOptionActivity.class);
                    startActivity(intent);
                }
            });
        }

        public void bind(Battle battle) {
            mBattle = battle;
            mBattleSelectButton.setText(mBattle.getName());
        }
    }

    //Needed class for Activity to interact with the fragment Holder
    private class BattleScrollAdapter extends RecyclerView.Adapter<BattleScrollActivity.BattleScrollHolder> {
        private List<Battle> mBattles;

        public BattleScrollAdapter(List<Battle> battles) {
            mBattles = battles;
        }

        @Override
        public BattleScrollActivity.BattleScrollHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new BattleScrollActivity.BattleScrollHolder(getLayoutInflater(), parent);
        }

        @Override
        public void onBindViewHolder(BattleScrollActivity.BattleScrollHolder holder, int position) {
            Battle battle = mBattles.get(position);
            holder.bind(battle);
        }

        @Override
        public int getItemCount() {
            return mBattles.size();
        }
}}
