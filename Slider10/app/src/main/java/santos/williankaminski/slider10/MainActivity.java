package santos.williankaminski.slider10;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;

import santos.williankaminski.slider10.helper.SampleSlide;

public class MainActivity extends AppIntro {

    @Override
    protected void onStart() {
        super.onStart();
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/

        addSlide(SampleSlide.newInstance(R.layout.intro_1));
        addSlide(SampleSlide.newInstance(R.layout.intro_2));

        // Altera a cor da barra inferior
        //setBarColor(Color.parseColor("#3F51B5"));

        // Altera a cor da linha de separação da barra inferior
        setSeparatorColor(Color.TRANSPARENT);

        setSkipText("teste");
    }
}
