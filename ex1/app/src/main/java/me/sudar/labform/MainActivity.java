package me.sudar.labform;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById(R.id.date_picker_button).setOnClickListener(this);
        findViewById(R.id.time_picker_button).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.date_picker_button:
                DatePickerDialog.OnDateSetListener onDateSetListener =  new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Toast.makeText(MainActivity.this,"Date Picker Clicked", Toast.LENGTH_SHORT).show();
                    }
                };
                    DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, onDateSetListener, 2016, 2, 8);
                    datePickerDialog.setTitle("Select Time");
                    datePickerDialog.show();
                break;


            case R.id.time_picker_button:
                TimePickerDialog.OnTimeSetListener onTimeSetListener =  new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(MainActivity.this,"Time Picker Clicked", Toast.LENGTH_SHORT).show();
                    }
                };
                    TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, onTimeSetListener,10,10,true);
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                break;
        }
    }
}
