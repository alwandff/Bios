package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditBiodataActivity extends AppCompatActivity {

    private EditText editTextNIP, editTextJenisKelamin, editTextTempatTanggalLahir, editTextAlamat;
    private Button buttonSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_biodata);

        editTextNIP = findViewById(R.id.editTextNIP);
        editTextJenisKelamin = findViewById(R.id.editTextJenisKelamin);
        editTextTempatTanggalLahir = findViewById(R.id.editTextTempatTanggalLahir);
        editTextAlamat = findViewById(R.id.editTextAlamat);
        buttonSimpan = findViewById(R.id.buttonSimpan);

        Intent intent = getIntent();
        if (intent != null) {
            editTextNIP.setText(intent.getStringExtra("NIP"));
            editTextJenisKelamin.setText(intent.getStringExtra("JenisKelamin"));
            editTextTempatTanggalLahir.setText(intent.getStringExtra("TempatTanggalLahir"));
            editTextAlamat.setText(intent.getStringExtra("Alamat"));
        }

        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("NIP", editTextNIP.getText().toString());
                resultIntent.putExtra("JenisKelamin", editTextJenisKelamin.getText().toString());
                resultIntent.putExtra("TempatTanggalLahir", editTextTempatTanggalLahir.getText().toString());
                resultIntent.putExtra("Alamat", editTextAlamat.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}

