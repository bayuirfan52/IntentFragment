package com.bayuirfan.intentfragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.bayuirfan.intentfragment.fragment.Home;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 0x00001;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMove = findViewById(R.id.intent_result);
        tvResult = findViewById(R.id.value_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Home home = new Home();

        Fragment fragment = fm.findFragmentByTag(Home.class.getSimpleName());

        if (!(fragment instanceof Home)){
            ft.add(R.id.frame, home, Home.class.getSimpleName());
            Log.d("Flexible Fragment", "Fragment Name : " + home.getClass().getSimpleName());

            ft.commit();
        }

        btnMove.setOnClickListener(view -> {
            Intent intent = new Intent(this, IntentResult.class);

            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == IntentResult.RESULT_CODE){
                assert data != null;
                int selected = data.getIntExtra(IntentResult.EXTRA_VALUE, 0);

                tvResult.setText("Hasil : " + selected);
            }
        }
    }
}
