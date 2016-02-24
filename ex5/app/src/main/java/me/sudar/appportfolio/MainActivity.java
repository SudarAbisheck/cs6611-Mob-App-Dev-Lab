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

        findViewById(R.id.spotify_button).setOnClickListener(this);
        findViewById(R.id.score_app_button).setOnClickListener(this);
        findViewById(R.id.library_app_button).setOnClickListener(this);
        findViewById(R.id.build_bigger_button).setOnClickListener(this);
        findViewById(R.id.xyz_button).setOnClickListener(this);
        findViewById(R.id.capstone_button).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.spotify_button :toaster(getString(R.string.spotify_msg)); break;

            case R.id.score_app_button :toaster(getString(R.string.scores_app_msg)); break;

            case R.id.library_app_button :toaster(getString(R.string.library_app_msg)); break;

            case R.id.build_bigger_button :toaster(getString(R.string.build_bigger_msg)); break;

            case R.id.xyz_button :toaster(getString(R.string.xyz_reader_msg)); break;

            case R.id.capstone_button :toaster(getString(R.string.capstone_msg)); break;
        }

    }

    public void toaster(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
