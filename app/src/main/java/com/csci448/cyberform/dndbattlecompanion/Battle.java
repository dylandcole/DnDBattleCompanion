package com.csci448.cyberform.dndbattlecompanion;

import java.util.ArrayList;

/**
 * Created by dwdco on 2/27/2018.
 */

public class Battle {
    private String name;
    private ArrayList<Combatant> mCombatants = new ArrayList<Combatant>();

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Combatant> getCombatants() {
        return mCombatants;
    }

    public void setCombatants(ArrayList<Combatant> combatants) {
        mCombatants = combatants;
    }
}
