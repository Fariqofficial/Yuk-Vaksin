package it.pradita.ac.yukvaksin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView CvPesertaVaksin, CvDaftarVaksin, CvInfoVaksin, CvPuskesmas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CvPesertaVaksin = findViewById(R.id.cv_list);
        CvDaftarVaksin = findViewById(R.id.cv_daftar);
        CvInfoVaksin = findViewById(R.id.cv_info);
        CvPuskesmas = findViewById(R.id.cv_puskesmas);

        CvPesertaVaksin.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ListPendaftarActivity.class)));
        CvDaftarVaksin.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DaftarActivityVaksin.class)));
        CvInfoVaksin.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, InfoVaksinActivity.class)));
        CvPuskesmas.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PuskesmasActivity.class)));

    }
}