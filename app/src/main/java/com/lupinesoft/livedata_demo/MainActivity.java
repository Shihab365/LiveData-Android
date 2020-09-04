package com.lupinesoft.livedata_demo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.buttonFetch_ID);
        textView = findViewById(R.id.textRandom_ID);

        final MainActivityViewModel maModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        LiveData<String> randomNumber = maModel.getNumber();

        randomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                Log.d("TAG","Data Updated In UI");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maModel.createNumber();
            }
        });

        Log.d("TAG","Random Number Set");
    }
}
