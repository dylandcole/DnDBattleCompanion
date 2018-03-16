package com.csci448.cyberform.dndbattlecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dylan on 2/28/2018.
 */

public class CombatantScrollActivity extends AppCompatActivity {

    private RecyclerView mSimpleScrollRecyclerView;
    private CombatantScrollActivity.CharacterScrollAdapter mAdapter;
    private ArrayList<Combatant> mCombatants = new ArrayList<Combatant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_scroll);

        mSimpleScrollRecyclerView = (RecyclerView) findViewById(R.id.simple_scroll_view);
        mSimpleScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < 10; i++) {
            Combatant combatant = new Combatant();
            combatant.setName("Combatant " + Integer.toString(i));
            mCombatants.add(combatant);
        }

        updateUI();
    }

    //Runs to ensure the lists are up to date with the user's actions
    private void updateUI() {
        mAdapter = new CombatantScrollActivity.CharacterScrollAdapter(mCombatants);
        mSimpleScrollRecyclerView.setAdapter(mAdapter);
    }

    //Inflates the defined fragment and determines fragment behavior
    private class CharacterScrollHolder extends RecyclerView.ViewHolder {

        private Combatant mCombatant;
        private TextView mCombatantName;

        public CharacterScrollHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_combatant_select, parent, false));
            mCombatantName = (TextView) itemView.findViewById(R.id.combatant_name);

        }

        public void bind(Combatant combatant) {
            mCombatant = combatant;
            mCombatantName.setText(mCombatant.getName());
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CombatantScrollActivity.this, CombatantDetailActivity.class);
                    startActivity(intent);
                }
            });
            this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Toast toast = Toast.makeText(CombatantScrollActivity.this, "Opens delete dialog", Toast.LENGTH_LONG);
                    toast.show();
                    return true;
                }
            });
        }
    }

    //Needed class for Activity to interact with the fragment Holder
    private class CharacterScrollAdapter extends RecyclerView.Adapter<CombatantScrollActivity.CharacterScrollHolder> {
        private List<Combatant> mCombatants;

        public CharacterScrollAdapter(List<Combatant> combatants) {
            mCombatants = combatants;
        }

        @Override
        public CombatantScrollActivity.CharacterScrollHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new CombatantScrollActivity.CharacterScrollHolder(getLayoutInflater(), parent);
        }

        @Override
        public void onBindViewHolder(CombatantScrollActivity.CharacterScrollHolder holder, int position) {
            Combatant combatant = mCombatants.get(position);
            holder.bind(combatant);
        }

        @Override
        public int getItemCount() {
            return mCombatants.size();
        }
    }
}
