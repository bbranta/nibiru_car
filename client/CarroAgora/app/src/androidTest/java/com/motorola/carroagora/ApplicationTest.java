package com.motorola.carroagora;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public String TAG = "TEST";

    public ApplicationTest() {
        super(Application.class);
    }

    public void testRegister() {

        Car car = new Car();

        car.setBrand("Ford");
        car.setFuel(Car.Fuel.ALCOHOL);

        CarService carService = CarServiceFactory.getCarService();
/*
        Call<MessageResponse> call = carService.saveCar(
                car.getOwner().getCpf(),
                car.getOwner().getName(),
                car.getOwner().getPhone(),
                car.getOwner().getCnh(),
                car.getPlate(),
                car.getBrand(),
                car.getModel(),
                car.getYear(),
                car.getOptionals(),
                Math.round(100 * car.getPrice()),
                car.getFuel().toString(),
                car.getAvailableDate().toString() + "-" + car.getStartTime() + "-" + car.getEndTime()
        );
        try {
            call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }

}