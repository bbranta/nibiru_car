package com.motorola.carroagora;

/**
 * Created by rbresil on 12/17/15.
 */
public class Test {

    public void main(String[] args) {


        Car car = new Car();

        car.setBrand("Ford");
        car.setFuel(Car.Fuel.ALCOHOL);

        CarInterface carInterface = CarServiceFactory.getCarService();

        carInterface.newCar(car);

    }
}
