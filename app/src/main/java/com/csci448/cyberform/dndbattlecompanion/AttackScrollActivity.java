package com.csci448.cyberform.dndbattlecompanion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dylan on 2/28/2018.
 */

public class AttackScrollActivity extends AppCompatActivity {

    private int mCombatantId;
    private RecyclerView mSimpleScrollRecyclerView;
    private AttackScrollActivity.AttackScrollAdapter mAdapter;
    private ArrayList<Attack> mAttacks = new ArrayList<Attack>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_scroll);

        mSimpleScrollRecyclerView = (RecyclerView) findViewById(R.id.simple_scroll_view);
        mSimpleScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < 10; i++) {
            Attack attack = new Attack();
            attack.setName("Attack " + Integer.toString(i));
            attack.setString("4d6 + 3");
            mAttacks.add(attack);
        }

        updateUI();
    }

    //Runs to ensure the lists are up to date with the user's actions
    private void updateUI() {
        mAdapter = new AttackScrollActivity.AttackScrollAdapter(mAttacks);
        mSimpleScrollRecyclerView.setAdapter(mAdapter);
    }

    //Inflates the defined fragment and determines fragment behavior
    private class AttackScrollHolder extends RecyclerView.ViewHolder {

        private Attack mAttack;
        private EditText mAttackName;
        private EditText mAttackInfo;

        public AttackScrollHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_attack_scroll, parent, false));
            mAttackName = (EditText) itemView.findViewById(R.id.attack_name);
            mAttackInfo = (EditText) itemView.findViewById(R.id.attack_info);
        }

        public void bind(Attack attack) {
            mAttack = attack;
            mAttackName.setText(mAttack.getName());
            mAttackInfo.setText(mAttack.getString());
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent intent = new Intent(AttackScrollActivity.this, CombatantDetailActivity.class);
                    //startActivity(intent);
                }
            });
        }
    }

    //Needed class for Activity to interact with the fragment Holder
    private class AttackScrollAdapter extends RecyclerView.Adapter<AttackScrollActivity.AttackScrollHolder> {
        private List<Attack> mAttacks;

        public AttackScrollAdapter(List<Attack> attacks) {
            mAttacks = attacks;
        }

        @Override
        public AttackScrollActivity.AttackScrollHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new AttackScrollActivity.AttackScrollHolder(getLayoutInflater(), parent);
        }

        @Override
        public void onBindViewHolder(AttackScrollActivity.AttackScrollHolder holder, int position) {
            Attack attack = mAttacks.get(position);
            holder.bind(attack);
        }

        @Override
        public int getItemCount() {
            return mAttacks.size();
        }
    }

    //Menu Methods
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_reorder_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast toast;
        switch(item.getItemId()) {
            case R.id.new_item:
                toast = Toast.makeText(this, "Creates blank attack", Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.reorder:
                toast = Toast.makeText(this, "Allows user to drag items to reorder", Toast.LENGTH_LONG);
                toast.show();
            default:

        }
        return true;
    }
}
