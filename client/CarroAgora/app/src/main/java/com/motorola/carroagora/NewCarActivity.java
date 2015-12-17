package com.motorola.carroagora;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class NewCarActivity extends AppCompatActivity {
    public static final String TAG = NewCarActivity.class.getSimpleName();

    private EditText editModel;
    private EditText editBrand;
    private EditText editYear;
    private EditText editPrice;
    private EditText editPlate;
    private RadioGroup radioGroupFuel;
    private CheckBox checkOptionalAirConditioner;
    private CheckBox checkOptionalDirecaoHidraulica;
    private CheckBox checkOptionalTrioEletrico;
    private EditText editOwnerName;
    private EditText editOwnerPhone;
    private EditText editOwnerCPF;
    private EditText editOwnerCNH;
    private EditText editAvailableDate;
    private EditText editStartTime;
    private EditText editEndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_car);
        editModel = (EditText) findViewById(R.id.editModel);
        editBrand = (EditText) findViewById(R.id.editBrand);
        editYear = (EditText) findViewById(R.id.editYear);
        editPrice = (EditText) findViewById(R.id.editPrice);
        editPlate = (EditText) findViewById(R.id.editPlate);
        radioGroupFuel = (RadioGroup) findViewById(R.id.radioGroupFuel);
        checkOptionalAirConditioner = (CheckBox) findViewById(R.id.checkBoxAirConditioner);
        checkOptionalDirecaoHidraulica = (CheckBox) findViewById(R.id.checkBoxDirecaoHidraulica);
        checkOptionalTrioEletrico = (CheckBox) findViewById(R.id.checkBoxTrioEletrico);
        editOwnerName = (EditText) findViewById(R.id.editOwnerName);
        editOwnerPhone = (EditText) findViewById(R.id.editOwnerPhone);
        editOwnerCPF = (EditText) findViewById(R.id.editOwnerCPF);
        editOwnerCNH = (EditText) findViewById(R.id.editOwnerCNH);
        editAvailableDate = (EditText) findViewById(R.id.editAvailableDate);
        editStartTime = (EditText) findViewById(R.id.editStartTime);
        editEndTime = (EditText) findViewById(R.id.editEndTime);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Car car = new Car();

                car.setModel(editModel.getText().toString());
                car.setBrand(editBrand.getText().toString());
                car.setYear(Integer.parseInt(editYear.getText().toString()));
                car.setPrice(Float.parseFloat(editPrice.getText().toString()));
                car.setPlate(editPlate.getText().toString());
                switch (radioGroupFuel.getCheckedRadioButtonId()) {
                    case R.id.radioGasoline:
                        car.setFuel(Car.Fuel.GASOLINE);
                        break;
                    case R.id.radioAlcohol:
                        car.setFuel(Car.Fuel.ALCOHOL);
                        break;
                    case R.id.radioFlex:
                        car.setFuel(Car.Fuel.FLEX);
                        break;
                    default:
                        // WTF???
                }
                int optionals = 0;
                if (checkOptionalAirConditioner.isChecked()) {
                    optionals &= Car.OPTIONAL_AIR_CONDITIONER;
                }
                if (checkOptionalDirecaoHidraulica.isChecked()) {
                    optionals &= Car.OPTIONAL_DIRECAO_HIDRAULICA;
                }
                if (checkOptionalTrioEletrico.isChecked()) {
                    optionals &= Car.OPTIONAL_TRIO_ELETRICO;
                }
                car.setOptionals(optionals);

                Person owner = new Person();
                owner.setName(editOwnerName.getText().toString());
                owner.setPhone(editOwnerPhone.getText().toString());
                owner.setCpf(editOwnerCPF.getText().toString());
                owner.setCnh(editOwnerCNH.getText().toString());

                car.setOwner(owner);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                try {
                    car.setAvailableDate(dateFormat.parse(editAvailableDate.getText().toString()));
                } catch (ParseException ex) {
                    Log.w(TAG, "invalid date: " + ex.getMessage());
                }
                car.setStartTime(Integer.parseInt(editStartTime.getText().toString()));
                car.setEndTime(Integer.parseInt(editEndTime.getText().toString()));

                Call<Void> call = CarServiceFactory.getCarService().newCar(car);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Response<Void> response, Retrofit retrofit) {
                        Log.d(TAG, "aew");
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.e(TAG, "could not create new car", t);
                    }
                });
            }
        });
    }
}
