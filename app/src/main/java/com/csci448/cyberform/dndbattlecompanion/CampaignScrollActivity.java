package com.csci448.cyberform.dndbattlecompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class CampaignScrollActivity extends AppCompatActivity {

    private RecyclerView mSimpleScrollRecyclerView;
    private CampaignScrollAdapter mAdapter;
    private ArrayList<Campaign> campaigns = new ArrayList<Campaign>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_scroll);

        mSimpleScrollRecyclerView = (RecyclerView) findViewById(R.id.simple_scroll_view);
        mSimpleScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < 10; i++) {
            Campaign campaign = new Campaign();
            campaign.setName("Campaign " + Integer.toString(i));
            campaigns.add(campaign);
        }

        updateUI();
    }

    //Runs to ensure the lists are up to date with the user's actions
    private void updateUI() {
        mAdapter = new CampaignScrollAdapter(campaigns);
        mSimpleScrollRecyclerView.setAdapter(mAdapter);
    }

    //Inflates the defined fragment and determines fragment behavior
    private class CampaignScrollHolder extends RecyclerView.ViewHolder {

        private Button mCampaignSelectButton;
        private Campaign mCampaign;

        public CampaignScrollHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_simple_scroll, parent, false));

            mCampaignSelectButton = (Button) itemView.findViewById(R.id.campaign_select_button);
            mCampaignSelectButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CampaignScrollActivity.this, CampaignOptionActivity.class);
                    startActivity(intent);
                }
            });
        }

        public void bind(Campaign campaign) {
            mCampaign = campaign;
            mCampaignSelectButton.setText(mCampaign.getName());
        }
    }

    //Needed class for Activity to interact with the fragment Holder
    private class CampaignScrollAdapter extends RecyclerView.Adapter<CampaignScrollHolder> {
        private List<Campaign> mCampaigns;

        public CampaignScrollAdapter(List<Campaign> campaigns) {
            mCampaigns = campaigns;
        }

        @Override
        public CampaignScrollHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new CampaignScrollHolder(getLayoutInflater(), parent);
        }

        @Override
        public void onBindViewHolder(CampaignScrollHolder holder, int position) {
            Campaign campaign = mCampaigns.get(position);
            holder.bind(campaign);
        }

        @Override
        public int getItemCount() {
            return mCampaigns.size();
        }
    }
}
