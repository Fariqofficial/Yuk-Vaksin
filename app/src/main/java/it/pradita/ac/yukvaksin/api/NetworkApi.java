package it.pradita.ac.yukvaksin.api;

import io.reactivex.Observable;
import it.pradita.ac.yukvaksin.response.DataResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetworkApi {

    @GET("read.php")
    Observable<DataResponse> getData();

    @FormUrlEncoded
    @POST("create.php")
    Observable<DataResponse> saveData(@Field("nama") String nama,
                                      @Field("alamat") String alamat,
                                      @Field("handphone") String handphone,
                                      @Field("umur") String umur);

}
