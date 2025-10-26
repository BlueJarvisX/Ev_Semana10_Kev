package com.example.gpsgooglemapskev;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int LOCATION_REQUEST_CODE = 101;

    private MapView mapView;
    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;
    private LatLng currentLatLng;

    private Button btnAddMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // VERIFICACIÓN SEGURA DE API KEY - MEJORA DE SEGURIDAD
        String mapsApiKey = getString(R.string.google_maps_key);
        if (mapsApiKey.isEmpty() || mapsApiKey.equals("") || mapsApiKey.contains("TU_API_KEY")) {
            Toast.makeText(this, "Error: Configuración de API Key no válida", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        btnAddMarker = findViewById(R.id.btnAddMarker);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        btnAddMarker.setOnClickListener(v -> {
            if (currentLatLng != null && mMap != null) {
                mMap.addMarker(new MarkerOptions().position(currentLatLng).title("Marcador personalizado"));
                Toast.makeText(this, "Marcador agregado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No se puede agregar marcador - ubicación no disponible", Toast.LENGTH_SHORT).show();
            }
        });

        checkLocationPermission();
    }

    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE);
        } else {
            getCurrentLocation();
        }
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(location -> {
                    if (location != null) {
                        currentLatLng = new LatLng(location.getLatitude(), location.getLongitude());
                        if (mMap != null) {
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 16));
                            mMap.addMarker(new MarkerOptions().position(currentLatLng).title("Tu ubicación actual"));
                        }
                    } else {
                        Toast.makeText(this, "No se pudo obtener la ubicación", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error al obtener ubicación: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // VALIDACIÓN DE PERMISOS MEJORADA
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            try {
                mMap.setMyLocationEnabled(true);
                getCurrentLocation();
            } catch (SecurityException e) {
                Toast.makeText(this, "Error de seguridad en permisos de ubicación", Toast.LENGTH_SHORT).show();
            }
        } else {
            checkLocationPermission();
        }

        // MEJORA: Validación de clics largos en mapa
        mMap.setOnMapLongClickListener(latLng -> {
            if (mMap != null) {
                mMap.addMarker(new MarkerOptions().position(latLng).title("Marcador manual"));
                Toast.makeText(this, "Marcador manual agregado", Toast.LENGTH_SHORT).show();
            }
        });

        // MEJORA: Configuración de UI segura
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            } else {
                Toast.makeText(this, "Permiso de ubicación denegado - Funcionalidad limitada", Toast.LENGTH_LONG).show();
            }
        }
    }

    // MÉTODOS DE CICLO DE VIDA MAPVIEW - MANTENIDOS
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}