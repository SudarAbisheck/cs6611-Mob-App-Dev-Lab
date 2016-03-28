package me.sudar.sdcardwriter;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        findViewById(R.id.read_button).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.read_button:
                String fileName = ((EditText)findViewById(R.id.filename_tv)).getText().toString();
                if(fileName.isEmpty())
                    Toast.makeText(this, "Please enter a filename", Toast.LENGTH_SHORT).show();
                else{
                    File fileToRead = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/SD Card Writer/" + fileName);
                    try {
                        FileInputStream fIn = new FileInputStream(fileToRead);
                        BufferedReader myReader = new BufferedReader(
                                new InputStreamReader(fIn));
                        String aDataRow = "";
                        String aBuffer = "";
                        while ((aDataRow = myReader.readLine()) != null) {
                            aBuffer += aDataRow + "\n";
                        }
                        ((TextView)findViewById(R.id.file_contents_tv)).setText(aBuffer);
                        myReader.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}