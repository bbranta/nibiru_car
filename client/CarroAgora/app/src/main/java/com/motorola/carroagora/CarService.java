package com.motorola.carroagora;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by rbresil on 12/17/15.
 */
public interface CarService {

    @POST("/api/v1/cars")
    @FormUrlEncoded
    Call<MessageResponse> saveCar (
            @Field("owner_cpf") String ownerCpf,
            @Field("owner_name") String ownerName,
            @Field("owner_phone") String ownerPhone,
            @Field("owner_driver_license") String ownerDriverLicense,
            @Field("license_plate") String licensePlate,
            @Field("brand") String brand,
            @Field("model") String model,
            @Field("year") int year,
            @Field("optionals") int optionals,
            @Field("price") float price,
            @Field("fuel") String fuel,
            @Field("available_date") String availableDate,
            @Field("available_start_time") int availableStartTime,
            @Field("available_end_time") int availableEndTime);

    @GET("/api/v1/cars")
    Call<ListReponse<Car>> listCars();
}
