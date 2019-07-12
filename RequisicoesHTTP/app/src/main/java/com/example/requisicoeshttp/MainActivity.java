package com.example.requisicoeshttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    protected static String URL_API = "https://api.exchangeratesapi.io/latest";
    protected static String URL_API_CEP = "https://viacep.com.br/ws/01001000/json/";

    private Button buttonRecuperar;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRecuperar = findViewById(R.id.buttonRecuperar);
        textViewResultado = findViewById(R.id.textResultado);

        buttonRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTask myTask = new MyTask();
                myTask.execute(URL_API_CEP);
            }
        });
    }

    /**
     * Classe responsavel por realizar
     * a requisição em background
     */

    class MyTask extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            String stringURL = strings[0];
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;
            StringBuffer buffer = null;

            try {

                URL url = new URL(stringURL);
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

                // Recupera os dados em Bytes
                inputStream = connection.getInputStream();

                // Decodifica os dados em Bytes para caracteres
                inputStreamReader = new InputStreamReader(inputStream);

                // Realiza a leitura dos caracteres
                BufferedReader reader = new BufferedReader(inputStreamReader);
                buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null){
                    buffer.append(line);
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            String logradouro = null;

            try {
                JSONObject jsonObject = new JSONObject(s);
                logradouro = jsonObject.getString("logradouro");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            textViewResultado.setText("" + logradouro);
            System.out.println(s);
        }
    }
}
