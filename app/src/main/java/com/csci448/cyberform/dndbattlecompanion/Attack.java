package com.csci448.cyberform.dndbattlecompanion;

/**
 * Created by dwdco on 2/27/2018.
 */

public class Attack {
    private int mIconId;
    private String mString;
    private String name;

    //Getters and Setters

    public int getIconId() {
        return mIconId;
    }

    public void setIconId(int iconId) {
        mIconId = iconId;
    }

    public String getString() {
        return mString;
    }

    public void setString(String string) {
        mString = string;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
