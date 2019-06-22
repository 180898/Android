package santos.williankaminski.firebaseapp;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.storage.StorageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    /*private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();*/

    private ImageView imageFoto;
    private Button buttonUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageFoto = findViewById(R.id.imageFoto);
        buttonUpload = findViewById(R.id.buttonUpload);

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Configura para a imagem ser salva em memória
                imageFoto.setDrawingCacheEnabled(true);
                imageFoto.buildDrawingCache();

                //Recuparar bitmap de imagem (imagem a ser carregada)
                Bitmap bitmap = imageFoto.getDrawingCache();

                //Comprimir o bitmap para um formato png/jpeg
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);

                //Converte o byteArrayOutputStream para pixel brutos em uma matriz de bytes
                // (dados da imagem)
                byte[] dadosImagem = byteArrayOutputStream.toByteArray();

                //Define nós para o storage
                StorageReference storageReference = FirebaseStorage.getInstance().getReference();

                //Nome da imagem
                String nomeArquivo = UUID.randomUUID().toString();
                StorageReference imagens = storageReference.child("imagens");
                StorageReference imagemRef = imagens.child(nomeArquivo + ".jpeg");

                //Retorna o objeto que irá controlar o upload
                UploadTask uploadTask = imagemRef.putBytes(dadosImagem);

                uploadTask.addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,
                                "Upload da imagem falhou: " + e.getMessage().toString(),
                                Toast.LENGTH_LONG).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> url = taskSnapshot.getMetadata().getReference().getDownloadUrl();

                        Toast.makeText(MainActivity.this,
                                "Sucesso ao realizar o upload: " + url.toString(),
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

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

        /*
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
        */

        /**
         * Cadastrando usuário
         */

        /*
        usuario.createUserWithEmailAndPassword(
                "","").
                addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("CreateUser","Sucesso ao cadastrar usuário!");
                        }else{
                            Log.i("CreateUser","Erro ao cadastrar usuário!");
                        }
                    }
                });
         */

        /**
         * Verificar usuário logado
         */

        /*
        if(usuario.getCurrentUser() != null){
            Log.i("CreateUser","Usuário Logado!");
        }else{
            Log.i("CreateUser","Usuário não logado!");
        }
        */

        /**
         * Deslogar usuário
         */

        /*
        usuario.signOut();
        */

        /**
         * Logar usuário
         */

        /*
        usuario.signInWithEmailAndPassword("developer.williansantos@gmail.com","Inter@@201500").
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("CreateUser","Sucesso ao autenticar usuário!");
                        }else{
                            Log.i("CreateUser","Erro ao autenticar usuário!");
                        }
                    }
                });
        */

        /**
         * Gerando um identificador unico para o registro na base de
         * dados, utilizando o método "push()".
         */

        /*
        DatabaseReference usuarios = referencia.child("usuarios");

        Usuario usuario = new Usuario();
        usuario.setNome("Willian");
        usuario.setSobrenome("Kaminski");
        usuario.setIdades(18);

        usuarios.push().setValue(usuario);
        */

        /**
         * Recuperando dados através do identificador
         */

        /*
        DatabaseReference usuarios = referencia.child("usuarios");
        final DatabaseReference usuarioPesquisa = usuarios.child("-Li-32-1uowBc6sqBPy7");

        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Usuario dadosUsuario = dataSnapshot.getValue(Usuario.class);
                Log.i("DADOS DO USUARIO: ", "nome: " + dadosUsuario.getNome());
                Log.i("DADOS DO USUARIO: ", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        */

        /**
         * Aplicando filtros de pesquisa
         */
        //DatabaseReference usuarios = referencia.child("usuarios");

        // Nome
        // Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Willian");

        // Primeiros 2
        //Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(2);

        // Maior igual
        //Query usuarioPesquisa = usuarios.orderByChild("idades").startAt(20);// >=

        // Menor igual
        //Query usuarioPesquisa = usuarios.orderByChild("idades").endAt(20);// <=

        // Between
        /*Query usuarioPesquisa = usuarios.orderByChild("idades")
                .startAt(18)
                .endAt(24);*/

        // Filtrar palavras

        /*
        Query usuarioPesquisa = usuarios.orderByChild("nome").startAt("W").endAt("W" + "\uf8ff");

        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("DADOS DO USUARIO: ", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        */
    }
}
