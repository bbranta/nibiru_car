package com.motorola.carroagora;

import android.util.Log;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by rbresil on 12/17/15.
 */
public class Test {
    public String TAG = "TEST";

    public void main(String[] args) {

        Car car = new Car();

        car.setBrand("Ford");
        car.setFuel(Car.Fuel.ALCOHOL);

        CarInterface carInterface = CarServiceFactory.getCarService();

        Call<Void> call = carInterface.newCar(car);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Response<Void> response, Retrofit retrofit) {
                Log.d(TAG, "onResponse PASSOU");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, "onFailure FALHOU");
            }
        });
    }
}
