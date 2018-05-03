package com.csci448.cyberform.dndbattlecompanion;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class FullCameraActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new FullCameraFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        FragmentManager fragmentManager = getSupportFragmentManager();
    }


}
