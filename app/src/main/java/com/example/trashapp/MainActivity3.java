package com.example.trashapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class MainActivity3 extends AppCompatActivity  {
    EditText TxtName, TxtDate, TxtPhone, TxtTime, TxtCity, TxtAddress;

    Button btSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TxtName = findViewById(R.id.TxtName);
        TxtDate = findViewById(R.id.TxtDate);
        TxtPhone = findViewById(R.id.TxtPhone);
        TxtTime = findViewById(R.id.TxtTime);
        TxtCity = findViewById(R.id.TxtCity);
        TxtAddress = findViewById(R.id.TxtAddress);


        //button logic

        // First Email sample

       Button button = findViewById(R.id.button2);
        button.setOnClickListener(v -> {
           // String a = "adamlalana31@gmail.com";
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/html");
            i.putExtra(Intent.EXTRA_EMAIL,new String[] {"trashmobileapp@gmail.com"});
           
            i.putExtra(Intent.EXTRA_SUBJECT,"Requesting For Trash Pickup");
            i.putExtra(Intent.EXTRA_TEXT,"Name : "+TxtName.getText()+"\n\nContact : "+TxtPhone.getText()+"\n\nLocation\nCity : "+TxtCity.getText()+"\nAddress : "+TxtAddress.getText()+"\n\nDate of pickup : "+TxtDate.getText()+"\n\nTime for Pickup : "+TxtTime.getText());

            try {
                startActivity(Intent.createChooser(i,"Please select Email"));
            }
            catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(MainActivity3.this,"there are no Email Clients", Toast.LENGTH_SHORT).show();
            }
        }
        );




    }

}