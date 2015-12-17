package com.motorola.carroagora;

import retrofit.Retrofit;

/**
 * Created by rbresil on 12/17/15.
 */
public class CarServiceFactory {

    private static CarInterface service;

    public static synchronized CarInterface getCarService() {

        if (service == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://nibiru-car.appspot.com")
                    .build();

            service = retrofit.create(CarInterface.class);
        }

        return service;
    }

}
