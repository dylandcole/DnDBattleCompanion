package com.csci448.cyberform.dndbattlecompanion;

import java.util.ArrayList;

/**
 * Created by dwdco on 2/26/2018.
 */

public class Campaign {
    private String mName;
    private ArrayList<Battle> mBattles = new ArrayList<Battle>();
    private ArrayList<Combatant> mCharacters = new ArrayList<Combatant>();
    private ArrayList<Combatant> mEnemies = new ArrayList<Combatant>();

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public void Campaign() {

    }
}
