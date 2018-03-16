package com.csci448.cyberform.dndbattlecompanion;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dylan on 2/28/2018.
 */

public class CombatantQuickActivity extends AppCompatActivity {

    private RecyclerView mSimpleScrollRecyclerView;
    private CharacterQuickAdapter mAdapter;
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
        mAdapter = new CharacterQuickAdapter(mCombatants);
        mSimpleScrollRecyclerView.setAdapter(mAdapter);
    }

    //Inflates the defined fragment and determines fragment behavior
    private class CharacterQuickHolder extends RecyclerView.ViewHolder {

        private Combatant mCombatant;
        private TextView mCombatantName;
        private ImageView mCombatantDetail;

        public CharacterQuickHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_combatant_quick_small, parent, false));
            mCombatantName = (TextView) itemView.findViewById(R.id.combatant_name);

            mCombatantDetail = (ImageView) itemView.findViewById(R.id.combatant_detail_button);
            mCombatantDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CombatantQuickActivity.this, CombatantDetailActivity.class);
                    startActivity(intent);
                }
            });
        }

        public void bind(Combatant combatant) {
            mCombatant = combatant;
            mCombatantName.setText(mCombatant.getName());
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toast = Toast.makeText(CombatantQuickActivity.this, "Expands view to show second attack, saving throws, speed, and buttons to quickly edit statuses or health", Toast.LENGTH_LONG);
                    toast.show();
                }
            });
            this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Toast toast = Toast.makeText(CombatantQuickActivity.this, "Opens delete dialog", Toast.LENGTH_LONG);
                    toast.show();
                    return true;
                }
            });
        }
    }

    //Needed class for Activity to interact with the fragment Holder
    private class CharacterQuickAdapter extends RecyclerView.Adapter<CharacterQuickHolder> {
        private List<Combatant> mCombatants;

        public CharacterQuickAdapter(List<Combatant> combatants) {
            mCombatants = combatants;
        }

        @Override
        public CharacterQuickHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new CharacterQuickHolder(getLayoutInflater(), parent);
        }

        @Override
        public void onBindViewHolder(CharacterQuickHolder holder, int position) {
            Combatant combatant = mCombatants.get(position);
            holder.bind(combatant);
        }

        @Override
        public int getItemCount() {
            return mCombatants.size();
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
                AlertDialog newCombatant = new AlertDialog.Builder(this)
                        .setTitle("New Combatant")
                        .setMessage("Add a premade combatant or add new?")
                        .setPositiveButton("Premade",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        AlertDialog premadeChoice = new AlertDialog.Builder(CombatantQuickActivity.this)
                                                .setTitle("New Combatant")
                                                .setMessage("Add from characters or general enemies?")
                                                .setPositiveButton("Characters", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        Intent intent = new Intent(CombatantQuickActivity.this, CombatantScrollActivity.class);
                                                        startActivity(intent);
                                                    }
                                                })
                                                .setNegativeButton("G. Enemies", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        Intent intent = new Intent(CombatantQuickActivity.this, CombatantScrollActivity.class);
                                                        startActivity(intent);
                                                    }
                                                })
                                                .create();
                                        premadeChoice.show();
                                    }
                                })
                        .setNegativeButton("New",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(CombatantQuickActivity.this, CombatantDetailActivity.class);
                                        startActivity(intent);
                                    }
                                })
                        .create();
                newCombatant.show();
                break;
            case R.id.reorder:
                toast = Toast.makeText(this, "Allows user to drag items to reorder", Toast.LENGTH_LONG);
                toast.show();
            default:

        }
        return true;
    }
}
