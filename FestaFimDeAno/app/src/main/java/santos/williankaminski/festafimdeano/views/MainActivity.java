package santos.williankaminski.festafimdeano.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import santos.williankaminski.festafimdeano.R;
import santos.williankaminski.festafimdeano.constants.FimDeAnoConstants;
import santos.williankaminski.festafimdeano.util.SecurityPreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textToday = (TextView) findViewById(R.id.text_today);
        this.mViewHolder.daysLeft = (TextView) findViewById(R.id.text_days_left);
        this.mViewHolder.confirm = (Button) findViewById(R.id.button_confirm);

        this.mViewHolder.confirm.setOnClickListener(this);

        this.mSharedPreferences = new SecurityPreferences(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
        this.verifyPreferences();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_confirm) {
            String preference = this.mSharedPreferences.getStorageString(FimDeAnoConstants.preferences);
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(FimDeAnoConstants.preferences, preference);
            startActivity(intent);
        }
    }

    private void verifyPreferences() {
        String preference = this.mSharedPreferences.getStorageString(FimDeAnoConstants.preferences);
        if (preference.isEmpty()) {
            this.mViewHolder.confirm.setText(R.string.nao_confirmado);
        } else if (preference.equals(FimDeAnoConstants.CONFIRMAED_WILL_GO)) {
            this.mViewHolder.confirm.setText(R.string.sim);
        } else {
            this.mViewHolder.confirm.setText(R.string.nao);
        }
    }

    private static class ViewHolder {
        TextView textToday;
        TextView daysLeft;
        Button confirm;
    }
}
