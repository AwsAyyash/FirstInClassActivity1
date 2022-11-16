package edu.cs.mobile438.firstinclassactivity1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputWeight;

    private EditText inputHeight;
    private Button calculateButton;
    private Switch isMaleSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewsObjects();
    }

    private void setViewsObjects() {

        calculateButton = findViewById(R.id.calculateButton);
        inputHeight = findViewById(R.id.inputHeight);
        inputWeight = findViewById(R.id.inputWeight);
        isMaleSwitch = findViewById(R.id.isMaleSwitch);


        calculateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                double height = Double.parseDouble(inputHeight.getText().toString());
                double weight = Double.parseDouble(inputWeight.getText().toString());

                boolean male = isMaleSwitch.isChecked();
                String textResult;
                if (height != 0) {
                    double bodyMassIndex = weight / Math.pow(height, 2);

                    if (male)
                        bodyMassIndex += bodyMassIndex * 0.05;

                    textResult = "Your Body mass Index= " + bodyMassIndex;
                } else {
                    textResult = "Enter valid height!!!";
                }
                Toast.makeText(MainActivity.this, textResult, Toast.LENGTH_SHORT).show();

            }
        });
    }


}