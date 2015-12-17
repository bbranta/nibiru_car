package com.motorola.carroagora;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by rbresil on 12/17/15.
 */
public class Test {

    public void main(String[] args) {


        Car car = new Car();

        car.setBrand("Ford");
        car.setFuel(Car.Fuel.ALCOHOL);

        CarInterface carInterface = CarServiceFactory.getCarService();

        carInterface.newCar(car, new Callback<MessageResponse>() {
            @Override
            public void onResponse(Response<MessageResponse> response, Retrofit retrofit) {
                Log.d(TAG, "onResponse PASSOU");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, "onFailure FALHOU");
            }
        });

    }
}
