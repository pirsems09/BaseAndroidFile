package com.arif.wifilist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.arif.wifilist.Models.ModelExample;
import com.arif.wifilist.Util.Retrofit.RetroInterface;
import com.arif.wifilist.Util.Retrofit.RetroService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        query();

    }

    private void query() {

        RetroInterface restApi = RetroService.getRetroInterface();

        Call<ModelExample> call = restApi.getPoint(token);

        call.enqueue(new Callback<ModelExample>() {
            @Override
            public void onResponse(Call<ModelExample> call, Response<ModelExample> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getBaseContext(), "OKEy", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelExample> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Hata oluştu!", Toast.LENGTH_SHORT).show();
            }

        });


    }
}
