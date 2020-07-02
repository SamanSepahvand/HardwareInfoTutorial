package com.faranesh.deviceinfo;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab_share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        Button btn_show = (Button) findViewById(R.id.btn_show_info);
        final TextView txt_display = (TextView) findViewById(R.id.diplay);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txt_display.setText(
                        "SERIAL: " + Build.SERIAL + "\n" +
                                "MODEL: " + Build.MODEL + "\n" +
                                "ID: " + Build.ID + "\n" +
                                "Manufacture: " + Build.MANUFACTURER + "\n" +
                                "Barnd: " + Build.BRAND + "\n" +
                                "Type: " + Build.TYPE + "\n" +
                                "User: " + Build.USER + "\n" +
                                "Base :" + Build.VERSION_CODES.BASE + "\n" +
                                "INCREMENTAL:" + Build.VERSION.INCREMENTAL + "\n" +
                                "SDK: " + Build.VERSION.SDK + "\n" +
                                "BORD: " + Build.BOARD + "\n" +
                                "HOST: " + Build.HOST + "\n" +
                                "Version Code: " + Build.VERSION.RELEASE
                );


            }
        });



        fab_share=(FloatingActionButton)findViewById(R.id.fab_share);
        fab_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String share=txt_display.getText().toString();
                Intent shareintent=new Intent();
                shareintent.setAction(Intent.ACTION_SEND);
                shareintent.putExtra(Intent.EXTRA_TEXT,share);
                shareintent.setType("text/plain");
                startActivity(Intent.createChooser(shareintent,"اشتراک گذاری با ...."));

            }
        });



    }
}
