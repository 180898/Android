package santos.williankaminski.festafimdeano.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import santos.williankaminski.festafimdeano.R;
import santos.williankaminski.festafimdeano.constants.FimDeAnoConstants;
import santos.williankaminski.festafimdeano.util.SecurityPreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSharedPreferences;
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowCustomEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.mViewHolder.textToday = (TextView) findViewById(R.id.text_today);
        this.mViewHolder.daysLeft = (TextView) findViewById(R.id.text_days_left);
        this.mViewHolder.confirm = (Button) findViewById(R.id.button_confirm);

        this.mViewHolder.confirm.setOnClickListener(this);

        this.mSharedPreferences = new SecurityPreferences(this);

        this.mViewHolder.textToday.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));

        String daysLeft = String.format("%s %s", String.valueOf(this.getDaysLeftToDate()), getString(R.string.dias));
        this.mViewHolder.daysLeft.setText(daysLeft);
    }

    @Override
    protected void onResume(){
        super.onResume();
        this.verifyPreferences();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_confirm) {
            String presence = this.mSharedPreferences.getStorageString(FimDeAnoConstants.PRESENCE);
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(FimDeAnoConstants.PRESENCE, presence);
            startActivity(intent);
        }
    }

    private int getDaysLeftToDate(){
        Calendar calendarToday = Calendar.getInstance();
        int today = calendarToday.get(Calendar.DAY_OF_YEAR);

        Calendar calendarLastDay = Calendar.getInstance();
        int lastDay = calendarLastDay.getActualMaximum(Calendar.DAY_OF_YEAR);

        return lastDay - today;
    }

    private void verifyPreferences() {
        String presence = this.mSharedPreferences.getStorageString(FimDeAnoConstants.PRESENCE);
        if (presence.equals("")) {
            this.mViewHolder.confirm.setText(R.string.nao_confirmado);
        } else if (presence.equals(FimDeAnoConstants.CONFIRMED_WILL_GO)) {
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
