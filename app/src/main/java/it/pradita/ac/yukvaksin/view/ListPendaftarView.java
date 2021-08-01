package it.pradita.ac.yukvaksin.view;

import java.util.List;

import it.pradita.ac.yukvaksin.model.Data;

public interface ListPendaftarView {

    void showProgress();
    void hideProgress();
    void getDataPendaftar(List<Data> data);
    void onErrorResponse(String message);

}
