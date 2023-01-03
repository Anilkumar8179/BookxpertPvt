package com.anilkumar.bookxpertpvt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
//    MaterialTextView textView;
    RecyclerView recyclerView;
    DataAdapter dataAdapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textView = findViewById(R.id.text_view);
        recyclerView=findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        dataAdapter = new DataAdapter();
        recyclerView.setAdapter(dataAdapter);
        recyclerView.setLayoutManager(llm);




        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://fssservices.bookxpert.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonApi jsonApi = retrofit.create(JsonApi.class);

        Call<String> call = jsonApi.sendData();
        jsonApi.sendData().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {



                if (response.isSuccessful()) {
                    DataAdapter dataAdapter=new DataAdapter(response.body());
                    recyclerView.setAdapter(dataAdapter);


                    try {
                        Type collectionType = new TypeToken<List<Pojo>>() {
                        }.getType();
                        List<Pojo> lcs = new Gson()
                                .fromJson(response.body(), collectionType);



                        dataAdapter.updateList(lcs);
                        dataAdapter.notifyDataSetChanged();

                    } catch (Exception e) {
//                        textView.setText(e.getMessage());

                        Toast.makeText(MainActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
//                textView.setText(t.getMessage());
            }
        });
//         call.enqueue(new Callback<List<Pojo>>() {
//             @Override
//             public void onResponse(Call<List<Pojo>> call, Response<List<Pojo>> response) {
//
////                 if(response.isSuccessful()){
////                     textView.setText("code:"+response.code());
////                     return;
////                 }
//
//                 List<Pojo>pojos=response.body();
//
////                 for (Pojo pojo:pojos){
////                     String content="";
////                     content+="actID:"+pojo.getActID()+"\n";
////                     content+="actName"+pojo.getActName()+"\n";
////                     content+="amount"+pojo.getAmount();
////
////                     textView.append(content);
////                 }
//
//
//             }
//
//             @Override
//             public void onFailure(Call<List<Pojo>> call, Throwable t) {
//                 textView.setText(t.getMessage());
//
//             }
//         });
    }

//    private void RetrieveData() {
//
////        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
////        recyclerView.setLayoutManager(linearLayoutManager);
//        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
////        recyclerView.setAdapter(adapter);
////        DataModel dataModel1=new DataModel(1,"",0.0);
//        Pojo pojo=new Pojo(1,"",0.0);
//
//
//
//    }
}
