package com.csci448.cyberform.dndbattlecompanion;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;

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
            campaign.setName("TEST");
            campaigns.add(campaign);
        }

        updateUI();
    }

    private void updateUI() {
        mAdapter = new CampaignScrollAdapter(campaigns);
        mSimpleScrollRecyclerView.setAdapter(mAdapter);
    }

    private class CampaignScrollHolder extends RecyclerView.ViewHolder {
        public CampaignScrollHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_simple_scroll_select, parent, false));
        }
    }

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

        }

        @Override
        public int getItemCount() {
            return mCampaigns.size();
        }
    }
}
