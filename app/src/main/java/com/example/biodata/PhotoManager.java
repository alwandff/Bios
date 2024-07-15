package com.example.biodata;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.ImageView;

public class PhotoManager {

    private static final int PICK_IMAGE = 1;
    private Activity activity;
    private ImageView imageViewFoto;

    public PhotoManager(Activity activity, ImageView imageViewFoto) {
        this.activity = activity;
        this.imageViewFoto = imageViewFoto;
    }

    public void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(galleryIntent, PICK_IMAGE);
    }

    public void handleActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            imageViewFoto.setImageURI(selectedImage);
        }
    }
}
