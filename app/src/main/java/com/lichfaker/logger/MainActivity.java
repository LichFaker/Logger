package com.lichfaker.logger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lichfaker.log.Logger;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.i("onCreate");

        Logger.i("Hello %s", "LichFaker");

    }

    @Override
    protected void onStart() {
        super.onStart();

        Logger.d("onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Logger.d("onResume %tF", System.currentTimeMillis());

    }

    @Override
    protected void onStop() {
        super.onStop();

        Logger.e("onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Logger.e("onDestroy", new Exception("Bye bye"));

    }
}
