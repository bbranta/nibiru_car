package com.motorola.carroagora;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by rbresil on 12/17/15.
 */
public interface CarInterface {

    @POST("/api/v1/cars")
    public void newCar (@Body Car car, Callback<MessageResponse> responseCallback);



}
