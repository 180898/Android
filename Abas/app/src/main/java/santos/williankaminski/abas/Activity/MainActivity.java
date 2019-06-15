package santos.williankaminski.abas.Activity;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import santos.williankaminski.abas.Activity.Fragment.EmAltaFragment;
import santos.williankaminski.abas.Activity.Fragment.HomeFragment;
import santos.williankaminski.abas.Activity.Fragment.InscricoesFragment;
import santos.williankaminski.abas.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Aplica configurações na Action Bar
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("YOUTUBE");

        viewPager = findViewById(R.id.viewpager);
        smartTabLayout = findViewById(R.id.viewPagerTab);

        //Configurar Abas
        FragmentPagerAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Home", HomeFragment.class)
                        .add("Inscricoes", InscricoesFragment.class)
                        .add("Em Alta", EmAltaFragment.class)
                        .create()
        );

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
    }
}
