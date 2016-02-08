package me.sudar.labform;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getBundleExtra("form-data");

        ((TextView)findViewById(R.id.name_value)).setText(bundle.getString("name"));
        ((TextView)findViewById(R.id.dob_value)).setText(bundle.getString("dob"));
        ((TextView)findViewById(R.id.college_value)).setText(bundle.getString("college"));
        ((TextView)findViewById(R.id.gender_value)).setText(bundle.getString("gender"));
        ((TextView)findViewById(R.id.dept_value)).setText(bundle.getString("dept"));
    }

}
