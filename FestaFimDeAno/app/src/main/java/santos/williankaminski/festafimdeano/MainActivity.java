package santos.williankaminski.festafimdeano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textToday = (TextView) findViewById(R.id.text_today);
        this.mViewHolder.daysLeft  = (TextView) findViewById(R.id.text_days_left);
        this.mViewHolder.confirm = (Button) findViewById(R.id.button_confirm);

        this.mViewHolder.confirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.button_confirm){
            Intent intent = new Intent(this, DetailsActivity.class);
            startActivity(intent);
        }
    }

    private static class ViewHolder{
        TextView textToday;
        TextView daysLeft;
        Button confirm;
    }
}
