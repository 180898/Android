package santos.williankaminski.trabalhandocomthreads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonIniciar;
    private int contador;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonIniciar = findViewById(R.id.buttonIniciar);
    }

    public void iniciarThread(View v){

        // Primeira forma de executar uma Thread
        /*myThread thread = new myThread();
        thread.start();*/

        // Segunda forma de executar uma Thread
        myRunnable runnable = new myRunnable();
        new Thread(runnable).start();
    }

    class myRunnable implements Runnable{

        @Override
        public void run() {

            for(int i = 0; i <= 15; i++){
                contador = i;
                Log.d("Thread", "iniciarThread: " + i);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        buttonIniciar.setText(contador);
                    }
                });

                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Classe interna para a execução
     * de uma nova Thread
     */
    class myThread extends Thread{
        @Override
        public void run() {
            super.run();

            for(int i = 0; i <= 15; i++){
                Log.d("Thread", "iniciarThread: " + i);

                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}


