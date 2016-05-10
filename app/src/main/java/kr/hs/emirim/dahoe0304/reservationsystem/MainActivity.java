package kr.hs.emirim.dahoe0304.reservationsystem;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    Button butStart, butDone;
    RadioButton radioDate, radioTime;
    CalendarView calView;
    TimePicker timePick;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chrono=(Chronometer)findViewById(R.id.chrono);    //강제형변환을 해줘야됨. 이게 반환하는건 view이다.
        butStart=(Button)findViewById(R.id.but_start);
        butDone=(Button)findViewById(R.id.but_done);
        radioDate=(RadioButton)findViewById(R.id.radio_date);
        radioTime=(RadioButton)findViewById(R.id.radio_time);
        calView=(CalendarView)findViewById(R.id.calendar);
        timePick=(TimePicker)findViewById(R.id.time_pick);
        textResult=(TextView)findViewById(R.id.text_result);
        timePick.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);  //화면에 두가지 뷰가 안보임. 가려진다.


        radioDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.VISIBLE);    //보이게
                timePick.setVisibility(View.INVISIBLE);   //안보이게


            }
        });
        radioTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.INVISIBLE);    //안보이게
                timePick.setVisibility(View.VISIBLE);   //보이게

            }
        });

        butStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });
        butDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                Calendar cal=Calendar.getInstance();
                cal.setTimeInMillis(calView.getDate());
                int year=cal.get(Calendar.YEAR);    //연도를 반환받을 수있다.
                int month=cal.get(Calendar.MONTH)+1;    //왜 +1이면 month은 0월달부터 시작이여서
                int date=cal.get(Calendar.DATE);
                /*int hour=timePicker.getHour();
                int minute=timePick*/

                String dateAndTime=year+"년 "+month+"월 "+date+"일 ";
                textResult.setText(dateAndTime);
            }
        });
    }
}
