package com.csci448.cyberform.dndbattlecompanion;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class CampaignScrollActivity extends AppCompatActivity {

    private RecyclerView mSimpleScrollRecyclerView;

    public static Context getContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_scroll);
        mSimpleScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
            return new CampaignScrollHolder(LayoutInflater.from(LayoutInflater.from(CampaignScrollActivity.getContext())))
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
