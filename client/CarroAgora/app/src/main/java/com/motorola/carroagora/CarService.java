package com.motorola.carroagora;

import com.squareup.okhttp.RequestBody;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
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
            @Field("price") int price,
            @Field("fuel") String fuel,
            @Field("available_time_range") String availableTimeRange);
}
