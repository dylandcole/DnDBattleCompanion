package com.csci448.cyberform.dndbattlecompanion;

import java.util.ArrayList;

/**
 * Created by dwdco on 2/27/2018.
 */

public class Combatant {
    //Overall Attributes
    private int mId;
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
        //Skill Modifiers
    private int mStrMod;
    private int mDexMod;
    private int mConMod;
    private int mIntMod;
    private int mWisMod;
    private int mChaMod;
        //Skill Saves
    private int mStrSave;
    private int mDexSave;
    private int mConSave;
    private int mIntSave;
    private int mWisSave;
    private int mChaSave;

    //TODO Skill Proficiencies (Enum List?)

    //Getters and Setters

    public String getName() {
        return mName;
    }
    public void setName(String name) {
        mName = name;
    }
    public int getHp() {
        return mHp;
    }
    public void setHp(int hp) {
        mHp = hp;
    }
    public int getHpMax() {
        return mHpMax;
    }
    public void setHpMax(int hpMax) {
        mHpMax = hpMax;
    }
    public int getAc() {
        return mAc;
    }
    public void setAc(int ac) {
        mAc = ac;
    }
    public int getSpeed() {
        return mSpeed;
    }
    public void setSpeed(int speed) {
        mSpeed = speed;
    }
    public int getInitiative() {
        return mInitiative;
    }
    public void setInitiative(int initiative) {
        mInitiative = initiative;
    }
    public String getAbilities() {
        return abilities;
    }
    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }
    public ArrayList<Attack> getAttacks() {
        return mAttacks;
    }
    public void setAttacks(ArrayList<Attack> attacks) {
        mAttacks = attacks;
    }
    public int getProficiency() {
        return mProficiency;
    }
    public void setProficiency(int proficiency) {
        mProficiency = proficiency;
    }
    public int getStrMod() {
        return mStrMod;
    }
    public void setStrMod(int strMod) {
        mStrMod = strMod;
    }
    public int getDexMod() {
        return mDexMod;
    }
    public void setDexMod(int dexMod) {
        mDexMod = dexMod;
    }
    public int getConMod() {
        return mConMod;
    }
    public void setConMod(int conMod) {
        mConMod = conMod;
    }
    public int getIntMod() {
        return mIntMod;
    }
    public void setIntMod(int intMod) {
        mIntMod = intMod;
    }
    public int getWisMod() {
        return mWisMod;
    }
    public void setWisMod(int wisMod) {
        mWisMod = wisMod;
    }
    public int getChaMod() {
        return mChaMod;
    }
    public void setChaMod(int chaMod) {
        mChaMod = chaMod;
    }
    public int getStrSave() {
        return mStrSave;
    }
    public void setStrSave(int strSave) {
        mStrSave = strSave;
    }
    public int getDexSave() {
        return mDexSave;
    }
    public void setDexSave(int dexSave) {
        mDexSave = dexSave;
    }

    public int getConSave() {
        return mConSave;
    }

    public void setConSave(int conSave) {
        mConSave = conSave;
    }

    public int getIntSave() {
        return mIntSave;
    }

    public void setIntSave(int intSave) {
        mIntSave = intSave;
    }

    public int getWisSave() {
        return mWisSave;
    }

    public void setWisSave(int wisSave) {
        mWisSave = wisSave;
    }

    public int getChaSave() {
        return mChaSave;
    }

    public void setChaSave(int chaSave) {
        mChaSave = chaSave;
    }
    //End Getters and Setters
}
