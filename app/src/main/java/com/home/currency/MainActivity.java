package com.home.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtNTD;
    private TextView txtJP, txtUS;
    private Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edtNTD = (EditText)findViewById(R.id.edtNTD);
        txtJP = (TextView)findViewById(R.id.txtJP);
        txtUS = (TextView)findViewById(R.id.txtUS);
        btnGo = (Button)findViewById(R.id.button);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNTD.getText().toString().equals("")){
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Problem")
                            .setMessage("Please enter your NTD amount!")
                            .setPositiveButton("OK", null)
                            .setCancelable(false)
                            .show();
                }else {
                    Float nNTD = Float.parseFloat(edtNTD.getText().toString());
                    String rUSD = String.valueOf(mNTD_to_US(nNTD));
                    String rJP = String.valueOf(mNTD_to_JP(nNTD));
                    txtUS.setText(rUSD);
                    txtJP.setText(rJP);
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Result")
                            .setMessage("USD is " + rUSD)
                            .setPositiveButton("OK", null)
                            .setCancelable(false)
                            .show();
                }
            }
        });
    }

    private Float mNTD_to_JP(Float nNTD) {
        Float nJP = nNTD * 3.5587f;
        return nJP;
    }

    private Float mNTD_to_US(Float nNTD) {
        Float nUSD = nNTD / 30.9f;
        return nUSD;
    }


}
