package com.motorola.carroagora;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ListCarsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cars);


        CarService carService = CarServiceFactory.getCarService();
        Call<ListReponse<Car>> call = carService.listCars();

        call.enqueue(new Callback<ListReponse<Car>>() {
            @Override
            public void onResponse(Response<ListReponse<Car>> response, Retrofit retrofit) {
                ListReponse<Car> carListReponse = response.body();

                final CarAdapter adapter = new CarAdapter(carListReponse.getItems());

                ListView listView = (ListView) findViewById(R.id.listCars);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String phoneNumber = adapter.getItem(position).getOwner().getPhone();
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + phoneNumber));
                        startActivity(intent);
                    }
                });



            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(
                        getApplicationContext(),
                        "Deu ruim: " + t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });


/*
        List<Car> cars = new ArrayList<Car>();
        Car c = new Car();
        c.setModel("Fiesta");
        c.setPrice(42);
        Person owner = new Person();
        owner.setName("Joao Andante");
        owner.setPhone("9999-8888");
        c.setOwner(owner);
        cars.add(c);

        c = new Car();
        c.setModel("K");
        c.setPrice(21);
        owner = new Person();
        owner.setName("Velho Barreiro");
        owner.setPhone("1111-2222");
        c.setOwner(owner);
        cars.add(c);
        cars.add(c);cars.add(c);cars.add(c);cars.add(c);cars.add(c);cars.add(c);cars.add(c);cars.add(c);cars.add(c);cars.add(c);cars.add(c);cars.add(c);cars.add(c);
*/
    }

    class CarAdapter extends BaseAdapter {
        private List<Car> cars;

        public CarAdapter(List<Car> cars) {
            this.cars = cars;
        }
        @Override
        public int getCount() {
            return cars.size();
        }

        @Override
        public Car getItem(int position) {
            return cars.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(ListCarsActivity.this).inflate(R.layout.list_cars_item, parent, false);
            }

            Car c = getItem(position);

            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

            TextView textPrice = (TextView) convertView.findViewById(R.id.textListPrice);
            textPrice.setText(nf.format(c.getPrice()));

            TextView textModel = (TextView) convertView.findViewById(R.id.textListModel);
            textModel.setText(c.getModel());

            TextView textOwnerName = (TextView) convertView.findViewById(R.id.textListOwner);
            textOwnerName.setText(String.format("%s, %s", c.getOwner().getName(), c.getOwner().getPhone()));

            return convertView;
        }
    }
}
