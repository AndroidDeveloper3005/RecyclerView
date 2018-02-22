package com.example.himel.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.example.himel.recyclerview.CustomAdapterClass.ItemAdapter;
import com.example.himel.recyclerview.CustomAdapterClass.ProductAdapter;
import com.example.himel.recyclerview.ModelClass.Item;
import com.example.himel.recyclerview.ModelClass.Product;
import com.kosalgeek.android.json.JsonConverter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String TAG ="MainActivity";

    RecyclerView rvitem;
    //CardView cvItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_main);

        rvitem = findViewById(R.id.recyclerView);

        rvitem.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,
                true);
       // CarouselLayoutManager manager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL);

        rvitem.setLayoutManager(manager);

       // ArrayList<Item>itemList = genaratedDummy();


       // AVD IP 10.0.2.2
        //http://192.168.0.103/customer/product.php
        String url = "http://192.168.0.103/customer/product.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG,response);

                        ArrayList<Product> productsList = new JsonConverter<Product>()
                                .toArrayList(response, Product.class);
                        ProductAdapter adapter = new ProductAdapter(getApplicationContext(), productsList);

                        rvitem.setAdapter(adapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error !=null){
                            Log.d(TAG,error.toString());
                            Toast.makeText(getApplicationContext(),"SomeThing went wrong",Toast.LENGTH_LONG).show();
                        }

                    }
                });

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

        /*ArrayList<Product>productList = getDataFromServer();

        ProductAdapter adapter = new ProductAdapter(getApplicationContext(), productList);

        rvitem.setAdapter(adapter);
*/
       // MySingleton.getInstance(this).addToRequestQueue();

    }






   /*private ArrayList<Item>genaratedDummy(){
        ArrayList<Item>list = new ArrayList<>();
        for (int i =0;i<20;i++){

            if (i%3 ==0){
                Item item = new Item();
                item.id = i;
                item.nameImage = "Sujana Zafar "+i;
                item.image = "https://i2.wp.com/dhakaonair.com/wp-content/uploads/2015/04/Suzana-Zafar-9.jpg";
                list.add(item);

            }
            else if(i%7==0){
                Item item = new Item();
                item.id = i;
                item.nameImage = "Sujana Zafar"+i;
                item.image = "https://pbs.twimg.com/profile_images/581404910836580353/dPqiYz1O.jpg";
                list.add(item);
            }

            else {
                Item item = new Item();
                item.id = i;
                item.nameImage = "Sujana Zafar"+i;
                item.image = "http://1.bp.blogspot.com/-plFn9KdajvE/U-JlnI3HjOI/AAAAAAAABfM/ZwosNCat25A/s1600/hridoy4.jpg";
                list.add(item);
            }

        }

        return list;
    }*/
}
