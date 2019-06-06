package santos.williankaminski.midiaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
    }

    public void executarSom(View v){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    public void pausarMusica(View v){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }else{
            Toast.makeText(this,"Não há nenhuma música em execução!", Toast.LENGTH_SHORT).show();
        }
    }

    public void pararMusica(View v){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
        }else{
            Toast.makeText(this,"Não há nenhuma música em execução!", Toast.LENGTH_SHORT).show();
        }
    }
}
