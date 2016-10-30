package app.os.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button plus1,plus5,plus10,zero;
    TextView countDisplay;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus1 =(Button)findViewById(R.id.plus1);
        plus5 =(Button)findViewById(R.id.plus5);
        plus10 =(Button)findViewById(R.id.plus10);
        zero =(Button)findViewById(R.id.zero);
        countDisplay =(TextView)findViewById(R.id.textView);

        countDisplay.setText(String.valueOf(count));

        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                countDisplay.setText(String.valueOf(count));
            }
        });
        plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count+=5;
                countDisplay.setText(String.valueOf(count));
            }
        });
        plus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count+=10;
                countDisplay.setText(String.valueOf(count));
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                countDisplay.setText(String.valueOf(count));
            }
        });

    }
}
