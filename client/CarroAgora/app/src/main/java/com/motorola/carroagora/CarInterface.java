package com.motorola.carroagora;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by rbresil on 12/17/15.
 */
public interface CarInterface {

    @POST("/api/v1/cars")
    public Call<Void> newCar (@Body Car car);
}
