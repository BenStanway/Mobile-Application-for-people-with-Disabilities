package com.example.myapplication.DU;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.myapplication.Carer.ShoppingList;
import com.example.myapplication.R;

public class NhsInfo extends shake {


    ImageButton GP, Dentist, Optician, Hospital, Pharmacy, Urgentcareservices, Sexualhealthservices, mentalhealthservices, pregnantWoman;
    Button shop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhs_info);

        GP=findViewById(R.id.taxiBtn);
        GP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.nhs.uk/service-search/find-a-gp");
            }
        });

        Dentist=findViewById(R.id.trainBtn);
        Dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.nhs.uk/service-search/find-a-dentist");
            }
        });

        Optician=findViewById(R.id.opticianBtn);
        Optician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.nhs.uk/service-search/find-an-optician");
            }
        });

        Hospital=findViewById(R.id.hospitalBtn);
        Hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.nhs.uk/service-search/other-services/Hospital/LocationSearch/7");
            }
        });

        Pharmacy=findViewById(R.id.pharmacyBtn);
        Pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.nhs.uk/service-search/pharmacy/find-a-pharmacy");
            }
        });

        Urgentcareservices=findViewById(R.id.ambulanceBtn);
        Urgentcareservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.nhs.uk/service-search/other-services/Urgent-Care/LocationSearch/1824");
            }
        });

        Sexualhealthservices=findViewById(R.id.sexualHealthBtn);
        Sexualhealthservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.nhs.uk/service-search/sexual-health");
            }
        });

        mentalhealthservices=findViewById(R.id.mentalHealthBtn);
        mentalhealthservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.nhs.uk/service-search/mental-health");
            }
        });

        pregnantWoman=findViewById(R.id.pregnantImage);
       pregnantWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.nhs.uk/service-search/pregnancy");
            }
        });


    }

    private void URL(String url){
        Uri uriUrl= Uri.parse(url);
        Intent launch = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launch);
    }
}