package santos.williankaminski.midiaplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.rtp.AudioStream;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SeekBar seekVolume;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
        inicializarSeekBar();
    }

    private void inicializarSeekBar(){
        seekVolume = findViewById(R.id.seekVolume);

        //configura o audio mananger
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //recupera os valores de volume máximo e o volume atual
        int volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAutal = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //configura o volume máximo para o SeekBar
        seekVolume.setMax(volumeMaximo);

        //configura o progresso atual do SeekBar
        seekVolume.setProgress(volumeAutal);

        //configura o controle de volume através da SeekBar
        seekVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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
