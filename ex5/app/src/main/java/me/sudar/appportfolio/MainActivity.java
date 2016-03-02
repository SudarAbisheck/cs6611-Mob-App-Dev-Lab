package me.sudar.appportfolio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private StudentDatabase db  = null;

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
            case R.id.create_button :
                db = new StudentDatabase(this);
                Toast.makeText(this, "Database Created", Toast.LENGTH_SHORT).show();
                break;

            case R.id.insert_button :
                startActivity(new Intent(this, InsertActivity.class));
                break;

            case R.id.update_button :
                startActivity(new Intent(this, UpdateActivity.class));
                break;

            case R.id.delete_button :
                startActivity(new Intent(this, DeleteActivity.class));
                break;

            case R.id.retrieve_button :
                startActivity(new Intent(this, RetrieveActivity.class));
                break;


        }

    }

    public void toaster(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
