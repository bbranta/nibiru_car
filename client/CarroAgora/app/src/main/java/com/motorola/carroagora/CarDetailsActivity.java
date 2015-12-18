package com.motorola.carroagora;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class CarDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        Intent intent = getIntent();

        TextView textTitle = (TextView) findViewById(R.id.textDetailsTitle);
        textTitle.setText(String.format("%s %s", intent.getStringExtra("brand"), intent.getStringExtra("model")));

        TextView textSubtitle = (TextView) findViewById(R.id.textDetailsSubtitle);
        textSubtitle.setText(String.format("%s %s", intent.getIntExtra("year", 2000), intent.getStringExtra("plate")));

        TextView textFuel = (TextView) findViewById(R.id.textDetailsFuel);
        int fuel = intent.getIntExtra("fuel", 0);
        if (fuel == Car.Fuel.ALCOHOL.ordinal()) {
            textFuel.setText("Álcool");
        } else if (fuel == Car.Fuel.GASOLINE.ordinal()) {
            textFuel.setText("Gasolina");
        } else if (fuel == Car.Fuel.FLEX.ordinal()) {
            textFuel.setText("Flex");
        }

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        TextView textPrice = (TextView) findViewById(R.id.textDetailsPrice);
        textPrice.setText(nf.format(intent.getFloatExtra("price", 0)));

        TextView textOwnerName = (TextView) findViewById(R.id.textDetailsOwnerName);
        textOwnerName.setText(intent.getStringExtra("ownerName"));

        TextView textOwnerPhone = (TextView) findViewById(R.id.textDetailsOwnerPhone);
        textOwnerPhone.setText(intent.getStringExtra("ownerPhone"));

        TextView textTime = (TextView) findViewById(R.id.textDetailsTime);
        textTime.setText(String.format("%s, %s:00 às %s:00", intent.getStringExtra("availableDate"), intent.getIntExtra("startTime", 0), intent.getIntExtra("endTime", 0)));
    }

    public void onClickTel(View view) {
        TextView text = (TextView) view;

        String phoneNumber = text.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }
}
