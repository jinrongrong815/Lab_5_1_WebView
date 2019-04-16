package com.example.jr.lab_5_1_webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    private Button button;
    private EditText edit_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.bu_load_web);
        edit_url = (EditText) findViewById(R.id.edit_url);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                passData();
            }
        });
    }

    public void passData(){
       // Intent intent = new Intent(this, WebViewLoadWeb.class);
        Intent intent = new Intent();
        intent.setAction("com.example.jr.lab_5_1_webview.START_ACTIVITY");
        intent.putExtra("url",edit_url.getText().toString());
        startActivity(intent);
    }

}
