package com.csci448.cyberform.dndbattlecompanion;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;

public class FullCameraFragment extends Fragment {

    int mID = 1;

    File mPhotoFile;
    ImageView mFullPhotoView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.full_camera, container, false);

        mPhotoFile = mPhotoFile = getPhotoFile();

         mFullPhotoView = (ImageView) v.findViewById(R.id.full_photo_view);

        updatePhotoView();

        return v;
    }

    private void updatePhotoView() {
        if(mPhotoFile == null || !mPhotoFile.exists()) {
            mFullPhotoView.setImageDrawable(null);
        }
        else
        {
            Bitmap bitmap = PictureUtils.getScailedBitmap(mPhotoFile.getPath(), getActivity());
            mFullPhotoView.setImageBitmap(bitmap);
        }
    }

    public String getPhotoFilename()
    {
        return "IMG_" + getID() + ".jpg";
    }

    public File getPhotoFile() {
        File filesDir = getActivity().getFilesDir();
        return new File(filesDir, getPhotoFilename());
    }

    public int getID()
    {
        return mID;
    }
}
