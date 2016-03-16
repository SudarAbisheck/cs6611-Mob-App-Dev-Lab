package me.sudar.appportfolio;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class InsertActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nameEditText;
    private EditText phnoEditText;
    private RadioGroup genderRadioGroup;
    private Spinner deptSpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById(R.id.submit_button).setOnClickListener(this);

        nameEditText = (EditText) findViewById(R.id.name_editText);
        phnoEditText = (EditText) findViewById(R.id.phno_editText);
        genderRadioGroup = (RadioGroup) findViewById(R.id.gender_radioGroup);
        deptSpinner = (Spinner) findViewById(R.id.dept_spinner);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){




            case R.id.submit_button:
                int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedGender = (RadioButton) findViewById(selectedGenderId);

               
                break;
        }
    }
}
