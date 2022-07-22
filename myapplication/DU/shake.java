package com.example.myapplication.DU;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class shake extends AppCompatActivity implements SensorEventListener  {

    private TextView xSensor, ySensor, zSensor;
    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private boolean isAccelerometerSensorAvailable, itIsNotFirstTime = false;
    private float currentX, currentY, currentZ, lastX, lastY, lastZ;
    private float xDifference, yDifference, zDifference;
    private float shakeThreshold = 10f;
    private Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);


        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email(view);
                Snackbar.make(view, "Opening up you're email", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

            public void Email(View view) {
                startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto: EnterEmailAddress")));// string sends email to ben
            }
        });

        xSensor= findViewById(R.id.xTextView);
        ySensor = findViewById(R.id.yTextView);
        zSensor= findViewById(R.id.zTextView);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            isAccelerometerSensorAvailable = true;
        } else {
            xSensor.setText("Accelerometer sensor is not available.");
            isAccelerometerSensorAvailable = false;
        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        //can be switched to a image button
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer((GravityCompat.START));
            }
        });
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        TextView textTitle = findViewById(R.id.textTitle);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                textTitle.setText(destination.getLabel());
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        xSensor.setText(sensorEvent.values[0] + "");
        ySensor.setText(sensorEvent.values[1] + "");
        zSensor.setText(sensorEvent.values[2] + "");

        currentX=sensorEvent.values[0];
        currentY=sensorEvent.values[1];
        currentZ=sensorEvent.values[2];

        if(itIsNotFirstTime)
        {
            xDifference = Math.abs(lastX-currentX);
            yDifference=Math.abs(lastY-currentY);
            zDifference=Math.abs(lastZ-currentZ);

            if((xDifference>shakeThreshold && yDifference > shakeThreshold) ||
                    (xDifference> shakeThreshold && zDifference> shakeThreshold)||
                    (yDifference> shakeThreshold && zDifference>shakeThreshold))
            {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                    Intent intent= new Intent(getApplicationContext(), popup.class);
                    startActivity(intent);
                }else{
                    vibrator.vibrate(500);
                }
            }
        }

        lastX=currentX;
        lastY=currentY;
        lastZ=currentZ;
        itIsNotFirstTime=true;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isAccelerometerSensorAvailable)
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isAccelerometerSensorAvailable)
            sensorManager.unregisterListener(this);
    }



}
