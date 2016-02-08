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
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nameEditText;
    private EditText collegeEditText;
    private RadioGroup genderRadioGroup;
    private Spinner deptSpinner;

    private int day;
    private int month;
    private int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById(R.id.date_picker_button).setOnClickListener(this);
        findViewById(R.id.reset_button).setOnClickListener(this);
        findViewById(R.id.submit_button).setOnClickListener(this);

        nameEditText = (EditText) findViewById(R.id.name_editText);
        collegeEditText = (EditText) findViewById(R.id.college_editText);
        genderRadioGroup = (RadioGroup) findViewById(R.id.gender_radioGroup);
        deptSpinner = (Spinner) findViewById(R.id.dept_spinner);

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
                    public void onDateSet(DatePicker view, int yearOfMil, int monthOfYear, int dayOfMonth) {
                        day = dayOfMonth;
                        month = monthOfYear;
                        year = yearOfMil;
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, onDateSetListener, 2016, 2, 8);
                datePickerDialog.setTitle("Select Time");
                datePickerDialog.show();
            break;

            case R.id.reset_button:
                nameEditText.setText("");
                collegeEditText.setText("");
                genderRadioGroup.clearCheck();
                deptSpinner.setSelection(0);
            break;

            case R.id.submit_button:

            break;
        }
    }
}
