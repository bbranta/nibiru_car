package com.motorola.carroagora;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by rbresil on 12/17/15.
 */
public class CarServiceFactory {

    private static CarService service;

    public static synchronized CarService getCarService() {

        if (service == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://nibiru-car.appspot.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = retrofit.create(CarService.class);
        }

        return service;
    }

}
