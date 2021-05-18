package sg.edu.rp.c346.id20022735.democheckboxex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbEn;
    Button btnc;
    TextView tvshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbEn = findViewById(R.id.checkBoxDC);
        btnc = findViewById(R.id.buttonCheck);
        tvshow = findViewById(R.id.textView);

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyActivity", "Inside onClick()");
                if (cbEn.isChecked() == true){
                    tvshow.setText("The discount is given.");
                }
                else{
                    tvshow.setText("Discount is not given.");
                }
                Toast.makeText(MainActivity.this, "Button Click", Toast.LENGTH_LONG).show();
                if(cbEn.isChecked()) {
                    double pay = calcPay(100, 20);
                    tvshow.setText("The discount is given. You need to pay " + pay);
                }
                else {
                    double pay = calcPay(100, 0);
                    tvshow.setText("The discount is not given. You need to pay " + pay);
                }

            }
        });

    }
    private double calcPay(double price, double dc){
        double pay = price * (1-dc/100);
        return pay;
    }
}