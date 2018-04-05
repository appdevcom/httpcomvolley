package com.appdev.httpcomvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        resultText = (TextView) findViewById(R.id.resultText);
        Button addButton =(Button) findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comunica();
            }
        });

    }

    protected void comunica(){

        RequestQueue queue= Volley.newRequestQueue(this);

        String number1 =editText1.getText().toString();
        String number2 =editText2.getText().toString();

        String url ="http://www.itcode.pt/ws/add.php?a=" + number1 + "&b=" + number2;

        Log.i("URL", url);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        resultText.setText("Response is: "+ response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                resultText.setText("That didn't work!");
            }
        });

        queue.add(stringRequest);
    }


}
