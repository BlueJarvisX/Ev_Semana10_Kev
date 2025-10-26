package com.example.gpsgooglemapskev;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnGoogleMaps, btnHilos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoogleMaps = findViewById(R.id.btnGoogleMaps);
        btnHilos = findViewById(R.id.btnHilos);

        btnGoogleMaps.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intent);
        });

        btnHilos.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HilosSensoresActivity.class);
            startActivity(intent);
        });
    }
}
