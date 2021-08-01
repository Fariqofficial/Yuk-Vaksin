package it.pradita.ac.yukvaksin.presenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import it.pradita.ac.yukvaksin.api.NetworkApi;
import it.pradita.ac.yukvaksin.api.NetworkClient;
import it.pradita.ac.yukvaksin.model.Data;
import it.pradita.ac.yukvaksin.response.DataResponse;
import it.pradita.ac.yukvaksin.view.ListPendaftarView;

public class ListPendaftarPresenter {

    private ListPendaftarView view;
    List<Data> list = new ArrayList<>();
    NetworkApi api;
    private CompositeDisposable disposable;

    public ListPendaftarPresenter(ListPendaftarView view) {
        this.view = view;
        disposable = new CompositeDisposable();
        api = NetworkClient.getClient().create(NetworkApi.class);
    }

    public void getData(){
        view.showProgress();
        disposable.add(api.getData().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<DataResponse>() {
                    @Override
                    public void onNext(@NonNull DataResponse dataResponse) {
                        view.hideProgress();
                        view.getDataPendaftar(dataResponse.getLisData());
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
