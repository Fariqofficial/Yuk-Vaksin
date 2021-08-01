package it.pradita.ac.yukvaksin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import it.pradita.ac.yukvaksin.presenter.DaftarVaksinPresenter;
import it.pradita.ac.yukvaksin.view.DaftarVaksinView;

public class DaftarActivityVaksin extends AppCompatActivity implements DaftarVaksinView {

    TextInputEditText et_nama, et_alamat, et_hp, et_umur;
    ProgressDialog dialog;
    DaftarVaksinPresenter presenter;
    String id, str_nama, str_alamat, str_hp, str_umur;
    Menu actMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_vaksin);

        et_nama = findViewById(R.id.namaPeserta);
        et_alamat = findViewById(R.id.alamatPeserta);
        et_hp = findViewById(R.id.hpPeserta);
        et_umur = findViewById(R.id.umurPeserta);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Please Wait..");

        presenter = new DaftarVaksinPresenter(this);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        str_nama = intent.getStringExtra("nama");
        str_alamat = intent.getStringExtra("alamat");
        str_hp = intent.getStringExtra("handphone");
        str_umur = intent.getStringExtra("umur");

        saveDataFromIntent();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String nama = et_nama.getText().toString().trim();
        String alamat = et_alamat.getText().toString().trim();
        String hp = et_hp.getText().toString().trim();
        String umur = et_umur.getText().toString().trim();

        if (item.getItemId() == R.id.save) {
            boolean isValid = true;

            if (nama.isEmpty()) {
                et_nama.setError("Mohon Masukan Nama Anda");
                isValid = false;
            }
            if (alamat.isEmpty()) {
                et_alamat.setError("Mohon Maskuan Alamat Anda");
                isValid = false;
            }
            if (hp.isEmpty()) {
                et_hp.setError("Mohon Masukan Nomor HP Anda");
                isValid = false;
            }
            if (umur.isEmpty()) {
                et_umur.setError("Mohon Masukan Umur Anda");
                isValid = false;
            }
                if (isValid){
                presenter.saveData(nama, alamat, hp, umur);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editor, menu);
        actMenu = menu;
        if (id != null){
            actMenu.findItem(R.id.save).setVisible(false);
        } else {
            actMenu.findItem(R.id.save).setVisible(true);
        }
        return true;
    }

    private void saveDataFromIntent() {
        et_nama.setText(str_nama);
        et_alamat.setText(str_alamat);
        et_hp.setText(str_hp);
        et_umur.setText(str_umur);
    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.hide();
    }

    @Override
    public void onSuccessResponse(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void onFailureResponse(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}