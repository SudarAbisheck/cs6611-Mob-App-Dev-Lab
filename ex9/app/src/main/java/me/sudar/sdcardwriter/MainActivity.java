package me.sudar.sdcardwriter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.write_button).setOnClickListener(this);
        findViewById(R.id.read_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.write_button:
                String fileName = ((EditText)findViewById(R.id.filename_tv)).getText().toString();
                String fileContents = ((EditText)findViewById(R.id.file_contents_tv)).getText().toString();

                if (fileName.isEmpty())
                    Toast.makeText(this, "Please enter a filename", Toast.LENGTH_SHORT).show();
                else {
                    File newDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/SD Card Writer");
                    newDir.mkdir();
                    File newFile = new File(newDir, fileName);
                    try {
                        FileOutputStream os = new FileOutputStream(newFile);
                        os.write(fileContents.getBytes());
                        os.close();
                        Toast.makeText(this,"Written to file", Toast.LENGTH_SHORT).show();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case R.id.read_button:
                startActivity(new Intent(this, ReadActivity.class));
                break;
        }
    }
}
