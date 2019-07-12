package santos.williankaminski.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import santos.williankaminski.retrofit.api.CEPService;
import santos.williankaminski.retrofit.model.CEP;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCEP;
    private Button buttonSolicitar;
    private TextView textViewResultado;
    private Retrofit retrofit;

    protected final String API_URL = "https://viacep.com.br/ws/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCEP = findViewById(R.id.editTextCEP);
        buttonSolicitar = findViewById(R.id.buttonSolicitar);
        textViewResultado = findViewById(R.id.textViewResultado);

        iniciarRetrofit();

        buttonSolicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String CEP = editTextCEP.getText().toString();
                System.out.println(CEP);
                retornarDadosRetrofit(CEP);
            }
        });
    }

    public void iniciarRetrofit(){

        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void retornarDadosRetrofit(String cep){

        CEPService cepService = retrofit.create(CEPService.class);
        Call<CEP> call = cepService.recuperarCEP(cep);

        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if(response.isSuccessful()){
                    CEP cep = response.body();
                    textViewResultado.setText(cep.toString());
                    System.out.println(cep.toString());
                }
            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {
                System.out.println("Deu merda!1");
            }
        });

    }
}
