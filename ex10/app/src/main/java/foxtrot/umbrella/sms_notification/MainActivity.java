package foxtrot.umbrella.sms_notification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtphoneNo;
    TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtphoneNo = (TextView) findViewById(R.id.to_number);
        txtMessage = (TextView) findViewById(R.id.to_message);

        Bundle b = getIntent().getExtras();
        if(b!= null) {
            txtphoneNo.setText(b.getString("senderno"));
            txtMessage.setText(b.getString("message"));
        }


    }




}
