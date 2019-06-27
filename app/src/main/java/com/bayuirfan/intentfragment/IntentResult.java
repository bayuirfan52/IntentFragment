package com.bayuirfan.intentfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

public class IntentResult extends AppCompatActivity {
    private RadioGroup group;
    public static String EXTRA_VALUE = "extra_value";
    public static int RESULT_CODE = 0x0012;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_result);

        group = findViewById(R.id.radio_group);
        Button select = findViewById(R.id.select);

        select.setOnClickListener(view -> {
            if (group.getCheckedRadioButtonId() != 0) {
                int value;
                switch (group.getCheckedRadioButtonId()){
                    case R.id.radio_1:
                        value = 10;
                        break;
                    case R.id.radio_2:
                        value = 20;
                        break;
                    case R.id.radio_3:
                        value = 30;
                        break;
                    case R.id.radio_4:
                        value = 40;
                        break;
                    default:
                        value = 0;
                        break;
                }
                Intent result = new Intent();
                result.putExtra(EXTRA_VALUE, value);
                setResult(RESULT_CODE, result);
                finish();
            }
        });
    }
}
