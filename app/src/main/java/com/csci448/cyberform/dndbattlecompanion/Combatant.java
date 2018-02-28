package com.csci448.cyberform.dndbattlecompanion;

import java.util.ArrayList;

/**
 * Created by dwdco on 2/27/2018.
 */

public class Combatant {
    //Overall Attributes
    private String mName;
    private int mHp;
    private int mHpMax;
    private int mAc;
    private int mSpeed;
    private int mInitiative;
    private String abilities;
    private ArrayList<Attack> mAttacks = new ArrayList<Attack>();

    //TODO Statuses (Enum List?)

    //Skills
    private int mProficiency;

    private int mStrMod;
    private int mDexMod;
    private int mConMod;
    private int mIntMod;
    private int mWisMod;
    private int mChaMod;

    private int mStrSave;
    private int mDexSave;
    private int mConSave;
    private int mIntSave;
    private int mWisSave;
    private int mChaSave;

    //TODO Skill Proficiencies (Enum List?)
}
