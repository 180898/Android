package santos.williankaminski.calendario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

public class MainActivity extends AppCompatActivity {

    private MaterialCalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);

        /**
         * Trabalhando com o limite de datas
         */
        /*
        calendarView.state().edit()
                .setMaximumDate(CalendarDay.from(2015,1,1))
                .setMaximumDate(CalendarDay.from(2020,1,1))
                .commit();
        */

        /***
         * Configurando os meses
         */
        final String[] meses = {"Ja","Fevereiro","Março","Abril", "Maio",
                "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        calendarView.setTitleMonths(meses);

        /***
         * Configurando os nomes dos
         * dias da semana
         */
        CharSequence dias[] = {"Dom","Seg","Ter","Qua", "Qui", "Sex", "Sab"};

        calendarView.setWeekDayLabels(dias);

        calendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {

                Toast.makeText(
                        getApplicationContext(),
                        meses[date.getMonth()],
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
