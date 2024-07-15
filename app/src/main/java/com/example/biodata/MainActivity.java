package com.example.biodata;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewFoto;
    private TextView textViewNIP, textViewJenisKelamin, textViewTempatTanggalLahir, textViewAlamat;
    private Button buttonGantiFoto, buttonEditBiodata;

    private PhotoManager photoManager;

    private static final int EDIT_BIODATA_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewFoto = findViewById(R.id.imageViewFoto);
        textViewNIP = findViewById(R.id.textViewNIP);
        textViewJenisKelamin = findViewById(R.id.textViewJenisKelamin);
        textViewTempatTanggalLahir = findViewById(R.id.textViewTempatTanggalLahir);
        textViewAlamat = findViewById(R.id.textViewAlamat);
        buttonGantiFoto = findViewById(R.id.buttonGantiFoto);
        buttonEditBiodata = findViewById(R.id.buttonEditBiodata);

        photoManager = new PhotoManager(this, imageViewFoto);

        buttonGantiFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoManager.openGallery();
            }
        });

        buttonEditBiodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(MainActivity.this, EditBiodataActivity.class);
                editIntent.putExtra("NIP", textViewNIP.getText().toString());
                editIntent.putExtra("JenisKelamin", textViewJenisKelamin.getText().toString());
                editIntent.putExtra("TempatTanggalLahir", textViewTempatTanggalLahir.getText().toString());
                editIntent.putExtra("Alamat", textViewAlamat.getText().toString());
                startActivityForResult(editIntent, EDIT_BIODATA_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDIT_BIODATA_REQUEST && resultCode == RESULT_OK && data != null) {
            String nip = data.getStringExtra("NIP");
            String jenisKelamin = data.getStringExtra("JenisKelamin");
            String tempatTanggalLahir = data.getStringExtra("TempatTanggalLahir");
            String alamat = data.getStringExtra("Alamat");

            textViewNIP.setText(nip);
            textViewJenisKelamin.setText(jenisKelamin);
            textViewTempatTanggalLahir.setText(tempatTanggalLahir);
            textViewAlamat.setText(alamat);
        } else {
            photoManager.handleActivityResult(requestCode, resultCode, data);
        }
    }
}


