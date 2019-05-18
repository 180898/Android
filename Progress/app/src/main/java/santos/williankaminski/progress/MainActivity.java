package santos.williankaminski.progress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar1;
    private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar2.setVisibility(View.GONE);

    }

    public void carregar(View v){

        progressBar2.setVisibility(View.VISIBLE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 101; i++){
                    System.out.println(i);
                    final int progresso = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar1.setProgress(progresso);

                            if(progresso == 100){
                                progressBar2.setVisibility(View.GONE);
                            }
                        }
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
