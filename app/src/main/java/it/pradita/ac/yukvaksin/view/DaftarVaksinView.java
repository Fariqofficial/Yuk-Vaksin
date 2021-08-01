package it.pradita.ac.yukvaksin.view;

public interface DaftarVaksinView {

    void showProgress();
    void hideProgress();
    void onSuccessResponse(String message);
    void onFailureResponse(String message);

}
