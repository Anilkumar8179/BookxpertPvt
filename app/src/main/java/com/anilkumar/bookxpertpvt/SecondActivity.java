package com.anilkumar.bookxpertpvt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    TextView textView1,textView2,textView3;

    Button button;

    String ActTD,ActName,Amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView1=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);
        button=findViewById(R.id.camera_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "Camera", Toast.LENGTH_SHORT).show();

                Intent intent= new Intent(SecondActivity.this,Camera.class);
                startActivity(intent);
            }
        });


        Intent intent=getIntent();
        ActTD=getIntent().getStringExtra("ActId");
        ActName=getIntent().getStringExtra("AcName");
        Amount=getIntent().getStringExtra("Amount");
        textView1.setText("ActId:"+ActTD);
        textView2.setText("AcName:"+ActName);
        textView3.setText("Amount:"+Amount);
    }
}