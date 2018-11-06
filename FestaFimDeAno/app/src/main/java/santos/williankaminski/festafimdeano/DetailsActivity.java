package santos.williankaminski.festafimdeano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import santos.williankaminski.festafimdeano.constants.FimDeAnoConstants;
import santos.williankaminski.festafimdeano.util.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = (CheckBox) findViewById(R.id.participate);

        this.mViewHolder.checkParticipate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.participate){
            if(this.mViewHolder.checkParticipate.isChecked()){
                this.mSecurityPreferences.storageString(FimDeAnoConstants.preferences, FimDeAnoConstants.CONFIRMAED_WILL_GO);
            }else{
                this.mSecurityPreferences.storageString(FimDeAnoConstants.preferences, FimDeAnoConstants.CONFIRMAED_WONT_GO);
            }
        }
    }

    private static class ViewHolder{
        CheckBox checkParticipate;
    }
}
