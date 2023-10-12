package com.example.labassignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText cEditText,inputView1,inputView2;
    private Button  convertBtn;
    private RadioButton c2f,f2c;
    private TextView showMessage;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        cEditText = (EditText) findViewById(R.id.conversionEditId);
        inputView1 = (EditText) findViewById(R.id.editTextId1);
        inputView2 = (EditText) findViewById(R.id.editTextId2);
        convertBtn = (Button) findViewById(R.id.buttonId);
        c2f =(RadioButton) findViewById(R.id.radioButtonId);
        f2c =(RadioButton) findViewById(R.id.radioButtonId1);
        radioGroup =(RadioGroup) findViewById(R.id.radioGroupId);
        showMessage = (TextView) findViewById(R.id.showMessageId);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioGroup.getCheckedRadioButtonId() == -1){
                    showMessage.setText("Please select atleast one conversion method");
                }else {
                    if(inputView1.getText().toString().equals("") || inputView1.getText().toString().equals(null)){
                        showMessage.setText("Please enter a value in the text box");
                    }else {

                        //fahrenheit to fahrenheit radio button is clicked
                        if   (f2c.isChecked()){
                            showMessage.setText(null);
                            String value = inputView2.getText().toString();
                            Double fahrenheitValue = Double .parseDouble(value);

                            Double convertedValue = (fahrenheitValue -32) * 5 / 9;

                            inputView1.setText(convertedValue.toString());
                        }
                        //Celcius to fahrenheit radio button is clicked
                        else if (c2f.isChecked()){
                            showMessage.setText(null);
                            String value = inputView2.getText().toString();
                            Double celsiusvalue = Double.parseDouble(value);

                            Double convertedValue = (celsiusvalue * 9 / 5) + 32;

                            inputView2.setText(convertedValue.toString());
                        }

                    }
                }
            }
        });


    }
}