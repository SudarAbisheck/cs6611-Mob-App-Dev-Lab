package me.sudar.labform;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nameEditText;
    private EditText collegeEditText;
    private RadioGroup genderRadioGroup;
    private Spinner deptSpinner;

    private Integer day = null;
    private Integer month = null;
    private Integer year = null;

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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.date_picker_button:
                DatePickerDialog.OnDateSetListener onDateSetListener =  new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int yearOfMil, int monthOfYear, int dayOfMonth) {
                        day = dayOfMonth;
                        month = monthOfYear + 1;
                        year = yearOfMil;
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, onDateSetListener, 2016, 1, 8);
                datePickerDialog.setTitle("Select DOB");
                datePickerDialog.show();
            break;

            case R.id.reset_button:
                nameEditText.setText("");
                collegeEditText.setText("");
                genderRadioGroup.clearCheck();
                deptSpinner.setSelection(0);
                day = null;
                month = null;
                year = null;
            break;

            case R.id.submit_button:
                int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedGender = (RadioButton) findViewById(selectedGenderId);

                Bundle data = new Bundle();
                data.putString("dob", day + "-" + month + "-" + year);
                data.putString("name", nameEditText.getText().toString());
                data.putString("college", collegeEditText.getText().toString());
                data.putString("gender", selectedGender.getText().toString());
                data.putString("dept", deptSpinner.getSelectedItem().toString());

                Intent intent = new Intent(this, DetailsActivity.class);
                intent.putExtra("form-data",data);

                startActivity(intent);
            break;
        }
    }
}
