package com.example.capitalizationapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.capitalizationapplication.pack.ChangeCapitalization;

public class MainActivity extends AppCompatActivity {



    public Button upperCase, lowerCase, normal, title, original, undo;
    public static ChangeCapitalization editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        upperCase = (Button) findViewById(R.id.upperCaseButton);
        lowerCase = (Button) findViewById(R.id.lowerCaseButton);
        normal = (Button) findViewById(R.id.normalCaseButton);
        title = (Button) findViewById(R.id.titleCaseButton);

//        https://stackoverflow.com/questions/42036278/how-to-pass-context-from-mainactivity-to-another-class-in-android
        editor = new ChangeCapitalization(this);

        upperCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.upperCapitalize();
            }
        });

        lowerCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.lowerCapitalize();
            }
        });

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.normalCapitalize();
            }
        });

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.titleCase();
            }
        });



    }
}