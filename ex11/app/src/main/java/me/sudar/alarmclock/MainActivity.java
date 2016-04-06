package me.sudar.alarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaActionSound;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Switch toggle;
    TextView timeTextView;
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    int hourOfDay = 10;
    int minute = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggle = (Switch) findViewById(R.id.toggleButton);
        timeTextView  = (TextView) findViewById(R.id.timeTextView);
        alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, MeraBroadcastReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 0x505050, intent, 0);

        final TimePickerDialog.OnTimeSetListener onTimeSetListener =  new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                MainActivity.this.hourOfDay = hourOfDay;
                MainActivity.this.minute = minute;
                if(toggle.isChecked()) setAlarmMgr();
                else toggle.setChecked(true);
                timeTextView.setText(hourOfDay + " : " + minute);
                Toast.makeText(MainActivity.this, "Time Picker Clicked", Toast.LENGTH_SHORT).show();
            }
        };

        timeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, onTimeSetListener,hourOfDay,minute,true);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    setAlarmMgr();
                }else{
                    alarmMgr.cancel(null);
                }
            }
        });


    }

    void setAlarmMgr(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);

        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, alarmIntent);
    }
}
