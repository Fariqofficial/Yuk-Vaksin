package it.pradita.ac.yukvaksin.presenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import it.pradita.ac.yukvaksin.api.NetworkApi;
import it.pradita.ac.yukvaksin.api.NetworkClient;
import it.pradita.ac.yukvaksin.response.DataResponse;
import it.pradita.ac.yukvaksin.view.DaftarVaksinView;

public class DaftarVaksinPresenter {

    private DaftarVaksinView view;
    private NetworkApi api;
    private CompositeDisposable disposable;

    public DaftarVaksinPresenter(DaftarVaksinView view) {
        this.view = view;
        api = NetworkClient.getClient().create(NetworkApi.class);
        disposable = new CompositeDisposable();
    }

    public void saveData(String nama, String alamat, String hp, String umur) {
        view.showProgress();
        disposable.add(api.saveData(nama, alamat, hp, umur)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<DataResponse>() {
                    @Override
                    public void onNext(@NonNull DataResponse dataResponse) {
                        view.hideProgress();
                        if (dataResponse.getMessage().equals("Tambah Data Berhasil!")) {
                            view.onSuccessResponse(dataResponse.getMessage());
                        } else {
                            view.onFailureResponse(dataResponse.getMessage());
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.hideProgress();
                    }

                    @Override
                    public void onComplete() {
                        view.hideProgress();
                    }
                })
        );
    }
}
