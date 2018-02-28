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

    //Default Constructor
    public void Campaign() {

    }

    //Getters and Setters
    public String getName() {
        return mName;
    }
    public void setName(String name) {
        this.mName = name;
    }

    public ArrayList<Battle> getBattles() {
        return mBattles;
    }
    public void setBattles(ArrayList<Battle> battles) {
        mBattles = battles;
    }

    public ArrayList<Combatant> getCharacters() {
        return mCharacters;
    }
    public void setCharacters(ArrayList<Combatant> characters) {
        mCharacters = characters;
    }

    public ArrayList<Combatant> getEnemies() {
        return mEnemies;
    }
    public void setEnemies(ArrayList<Combatant> enemies) {
        mEnemies = enemies;
    }
}
