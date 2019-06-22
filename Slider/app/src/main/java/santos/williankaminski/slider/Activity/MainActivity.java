package santos.williankaminski.slider.Activity;

import android.Manifest;
import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

import santos.williankaminski.slider.R;

public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setFullscreen ( true );
        super.onCreate(savedInstanceState);

        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new SimpleSlide.Builder()
                .title("Titulo 1")
                .description("Descrição")
                .image(R.drawable.um)
                .background(android.R.color.holo_orange_light)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Titulo 2")
                .description("Descrição")
                .image(R.drawable.dois)
                .background(android.R.color.holo_orange_light)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Titulo 3")
                .description("Descrição")
                .image(R.drawable.tres)
                .background(android.R.color.holo_orange_light)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Titulo 4")
                .description("Descrição")
                .image(R.drawable.quatro)
                .background(android.R.color.holo_orange_light)
                .build());
    }
}
