package me.sudar.dubakoorcalc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import sudar.me.dubakoorcalc.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView exprTextView;
    private TextView ansTextView;
    private TextView dualTextView;

    private StringBuilder expr = new StringBuilder();
    private StringBuilder ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exprTextView = (TextView) findViewById(R.id.expr_tv);
        ansTextView = (TextView) findViewById(R.id.ans_tv);
        dualTextView = (TextView) findViewById(R.id.dual);

        findViewById(R.id.one).setOnClickListener(this);
        findViewById(R.id.two).setOnClickListener(this);
        findViewById(R.id.three).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
        findViewById(R.id.five).setOnClickListener(this);
        findViewById(R.id.six).setOnClickListener(this);
        findViewById(R.id.seven).setOnClickListener(this);
        findViewById(R.id.eight).setOnClickListener(this);
        findViewById(R.id.nine).setOnClickListener(this);
        findViewById(R.id.zero).setOnClickListener(this);
        findViewById(R.id.dot).setOnClickListener(this);
        findViewById(R.id.equal).setOnClickListener(this);
        findViewById(R.id.div).setOnClickListener(this);
        findViewById(R.id.mul).setOnClickListener(this);
        findViewById(R.id.minus).setOnClickListener(this);
        findViewById(R.id.plus).setOnClickListener(this);
        findViewById(R.id.dual).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == R.id.equal){
            Toast.makeText(this, "apram dhaan", Toast.LENGTH_SHORT).show();
            ((TextView) findViewById(R.id.dual)).setText(getString(R.string.clr));
        }else if(id == R.id.dual){
            String temp = ((TextView) findViewById(R.id.dual)).getText().toString();
            if(temp.equals(getString(R.string.del))){
                expr.deleteCharAt(expr.length()-1);
            }else {
                expr.delete(0,expr.length());
                ((TextView) findViewById(R.id.dual)).setText(getString(R.string.del));
            }
            ((TextView) findViewById(R.id.expr_tv)).setText(expr.toString());
        }else{
            expr.append(((TextView) findViewById(id)).getText());
            ((TextView) findViewById(R.id.expr_tv)).setText(expr.toString());
        }
    }
}
