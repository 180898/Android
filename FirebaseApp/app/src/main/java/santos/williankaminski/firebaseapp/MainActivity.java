package santos.williankaminski.firebaseapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Criando um filho e adicionando um valor para
         * o mesmo no momento da execução do app.
        */

        //referencia.child("pontos").setValue("200");


        /**
         * Criando novos registros na base de usuários
        */

        /*
        referencia.child("usuarios").child("001").child("nome").setValue("Willian");
        referencia.child("usuarios").child("001").child("sobrenome").setValue("Kaminski");

        referencia.child("usuarios").child("002").child("nome").setValue("Amanda");
        referencia.child("usuarios").child("002").child("sobrenome").setValue("Decarli");

        referencia.child("usuarios").child("003").child("nome").setValue("Bruna");
        referencia.child("usuarios").child("003").child("sobrenome").setValue("Forsh");
        */

        /**
         * Guardando um objeto na base de dados
         */

        /*
        DatabaseReference usuarios = referencia.child("usuarios");

        Usuario usuario = new Usuario();
        usuario.setNome("Willian");
        usuario.setSobrenome("Kaminski");
        usuario.setIdades(18);

        usuarios.child("001").setValue(usuario);
        */

        /**
         * Recuperando os dados do Firebase
         */
        DatabaseReference usuarios = referencia.child("usuarios");

        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
