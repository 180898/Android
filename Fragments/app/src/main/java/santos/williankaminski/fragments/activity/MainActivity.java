package santos.williankaminski.fragments.activity;

/**
 * Created by Willian Kaminski on 19/05/19.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import santos.williankaminski.fragments.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Remover a sombra da ActionBar
        getSupportActionBar().setElevation(0);
    }
}
