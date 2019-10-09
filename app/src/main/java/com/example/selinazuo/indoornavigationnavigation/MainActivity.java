package com.example.selinazuo.indoornavigationnavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText startPoint;
    EditText destination;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] points = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z1","Z2","AA","AB","AC","AD","AE","AF"};
        startPoint = findViewById(R.id.start_point);
        destination = findViewById(R.id.destination_point);
        submitBtn = findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String start = startPoint.getText().toString();
                String end = destination.getText().toString();
                if(start!=null&& Arrays.asList(points).contains(start)&&end!=null&&Arrays.asList(points).contains(end)){
                    Intent intent = new Intent(v.getContext(),Indoor_Navigation.class);
                    intent.putExtra("START_POINT",start);
                    intent.putExtra("END_POINT",end);
                    startActivity(intent);
                }else{

                }
            }
        });
    }
}
