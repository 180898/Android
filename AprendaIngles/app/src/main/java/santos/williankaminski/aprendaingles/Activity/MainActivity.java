package santos.williankaminski.aprendaingles.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import santos.williankaminski.aprendaingles.Fragment.AnimaisFragment;
import santos.williankaminski.aprendaingles.Fragment.NumerosFragment;
import santos.williankaminski.aprendaingles.Fragment.VogaisFragment;
import santos.williankaminski.aprendaingles.R;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartTabLayout = findViewById(R.id.smartTableTab);
        viewPager = findViewById(R.id.viewpager);

        //Configurando a Action Bar
        getSupportActionBar().setElevation(0);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Animais", AnimaisFragment.class)
                .add("Numeros", NumerosFragment.class)
                .add("Vogais", VogaisFragment.class)
                .create()
        );

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
    }
}
