package me.sudar.dubakoorcalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import sudar.me.dubakoorcalc.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView exprTextView;
    private TextView ansTextView;
    private TextView dualTextView;

    private StringBuilder expr = new StringBuilder();

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
        String ops = "/x-+";

        if(id == R.id.equal){
            if (expr.length() != 0) {
                char c = expr.charAt(expr.length() - 1);
                if (c == '/' || c == 'x' || c == '-' || c == '+')
                    expr.deleteCharAt(expr.length() - 1);
            }
            expr.append('=');
            exprTextView.setText(expr.toString());

            calcExpr(expr);

            dualTextView.setText(getString(R.string.clr));
        }else if(id == R.id.dual){
            String temp = dualTextView.getText().toString();
            if(temp.equals(getString(R.string.del))){
                if (expr.length() != 0)
                    expr.deleteCharAt(expr.length()-1);
            }else {
                expr.delete(0,expr.length());
                dualTextView.setText(getString(R.string.del));
            }
            exprTextView.setText(expr.toString());
        }else{
            String temp = dualTextView.getText().toString();
            if(temp.equals(getString(R.string.clr))){
                expr.delete(0,expr.length());
                dualTextView.setText(getString(R.string.del));
                ansTextView.setText("");
            }else {
                CharSequence nextInput = ((TextView) findViewById(id)).getText();
                if (expr.length() != 0) {
                    char c = expr.charAt(expr.length() - 1);
                    if ((c == '/' || c == 'x' || c == '-' || c == '+') && ops.contains(nextInput))
                        expr.deleteCharAt(expr.length() - 1);
                }

                if (!((expr.length() == 0) && ops.contains(nextInput)))
                    expr.append(nextInput);

            }
            exprTextView.setText(expr.toString());
        }
    }

    public void calcExpr(StringBuilder expr){
        expr.deleteCharAt(expr.length() - 1);
//        String[] values = expr.toString().split("\\+");
        Toast.makeText(this, "not now", Toast.LENGTH_SHORT).show();
    }
}
