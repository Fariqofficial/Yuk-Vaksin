package it.pradita.ac.yukvaksin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import it.pradita.ac.yukvaksin.adapter.ListPendaftarAdapter;
import it.pradita.ac.yukvaksin.model.Data;
import it.pradita.ac.yukvaksin.presenter.ListPendaftarPresenter;
import it.pradita.ac.yukvaksin.view.ListPendaftarView;

public class ListPendaftarActivity extends AppCompatActivity implements ListPendaftarView {

    SwipeRefreshLayout refreshLayout;
    RecyclerView rvData;
    ListPendaftarPresenter presenter;
    ListPendaftarAdapter adapter;

    List<Data> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pendaftar);

        rvData = findViewById(R.id.rvListPendaftar);
        refreshLayout = findViewById(R.id.swipeLayout);

        rvData.setLayoutManager(new LinearLayoutManager(this));

        presenter = new ListPendaftarPresenter(this);
        presenter.getData();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getData();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11 && resultCode == RESULT_OK){
            presenter.getData();
        } else if (requestCode == 12 && resultCode == RESULT_OK) {
            presenter.getData();
        }
    }

    @Override
    public void showProgress() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void getDataPendaftar(List<Data> data) {
        adapter = new ListPendaftarAdapter(this, data);
        adapter.notifyDataSetChanged();
        rvData.setAdapter(adapter);
        dataList = data;
        Log.d("data", data.toString());
    }

    @Override
    public void onErrorResponse(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}