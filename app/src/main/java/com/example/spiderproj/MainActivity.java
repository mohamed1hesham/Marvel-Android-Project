package com.example.spiderproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView heroesRecycler,violesRecycler;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heroesRecycler = findViewById(R.id.heroes_recycler_view);
        violesRecycler=findViewById(R.id.violes_recycler_view);
        dialog = progressDialog();
        dialog.show();

        getData();

    }
    private void getData(){

        Call<List<heroesDetails>> call = RetrofitClient.getInstance().getApi().getHeroes();
        call.enqueue(new Callback<List<heroesDetails>>() {
            @Override
            public void onResponse(Call<List<heroesDetails>> call, Response<List<heroesDetails>> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code:"+String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                    return;
                }

                List<heroesDetails> users = response.body();
                heroes_recycler_adapter heroes_recycler_adapter = new heroes_recycler_adapter(MainActivity.this,users);

                heroesRecycler.setAdapter(heroes_recycler_adapter);
                heroesRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                violesRecycler.setAdapter(heroes_recycler_adapter);
                violesRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));

                Log.d("Code",String.valueOf(response.code()));
                dialog.cancel();

            }

            @Override
            public void onFailure(Call<List<heroesDetails>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

    }

    public ProgressDialog progressDialog(){
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("API Fetching");
        dialog.setMessage("Loading Data");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        return dialog;
    }
}