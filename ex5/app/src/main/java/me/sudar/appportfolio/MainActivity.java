package me.sudar.appportfolio;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.create_button).setOnClickListener(this);
        findViewById(R.id.insert_button).setOnClickListener(this);
        findViewById(R.id.update_button).setOnClickListener(this);
        findViewById(R.id.delete_button).setOnClickListener(this);
        findViewById(R.id.retrieve_button).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_button : break;

            case R.id.insert_button : break;

            case R.id.update_button :break;

            case R.id.delete_button : break;

            case R.id.retrieve_button : break;


        }

    }

    public void toaster(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
