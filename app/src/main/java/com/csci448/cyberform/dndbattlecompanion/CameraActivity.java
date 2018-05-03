package com.csci448.cyberform.dndbattlecompanion;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.util.List;

public class CameraActivity extends AppCompatActivity {

    int mID = 1;

    private File mPhotoFile;

    private ImageButton mPhotoButton;
    private ImageView mPhotoView;

    private static final int REQUEST_PHOTO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        mPhotoFile = getPhotoFile();

        mPhotoButton = (ImageButton) findViewById(R.id.take_photo);
        mPhotoView = (ImageView) findViewById(R.id.photo_view);
        updatePhotoView();

        final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        boolean canTakePhoto = mPhotoFile != null && captureImage.resolveActivity(getPackageManager()) != null;

        mPhotoButton.setEnabled(canTakePhoto);

        mPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = FileProvider.getUriForFile(CameraActivity.this, "com.csci448.cyberform.dndbattlecompanion.fileprovider", mPhotoFile);

                captureImage.putExtra(MediaStore.EXTRA_OUTPUT, uri);

                List<ResolveInfo> cameraActivities = getPackageManager().queryIntentActivities(captureImage, PackageManager.MATCH_DEFAULT_ONLY);

                for (ResolveInfo activity: cameraActivities) {
                    grantUriPermission(activity.activityInfo.packageName, uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                }

                startActivityForResult(captureImage, REQUEST_PHOTO);
            }
        });

        mPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CameraActivity.this, FullCameraActivity.class);
                startActivity(i);
            }
        });
    }

    public String getPhotoFilename()
    {
        return "IMG_" + getID() + ".jpg";
    }

    public File getPhotoFile() {
        File filesDir = getFilesDir();
        return new File(filesDir, getPhotoFilename());
    }

    public int getID()
    {
        return mID;
    }

    private void updatePhotoView() {
        if(mPhotoFile == null || !mPhotoFile.exists()) {
            mPhotoView.setImageDrawable(null);
        }
        else
        {
            Bitmap bitmap = PictureUtils.getScailedBitmap(mPhotoFile.getPath(), CameraActivity.this);
            mPhotoView.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data ){
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_PHOTO) {
            Uri uri = FileProvider.getUriForFile(CameraActivity.this, "com.csci448.cyberform.dndbattlecompanion.fileprovider", mPhotoFile);

            CameraActivity.this.revokeUriPermission(uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

            updatePhotoView();
        }
    }
}
