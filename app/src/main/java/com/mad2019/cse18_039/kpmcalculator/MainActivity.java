package com.mad2019.cse18_039.kpmcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button simp;
    private Button sci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simp = findViewById(R.id.simp);
        simp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSimpleCal();
            }
        });
        sci = findViewById(R.id.sci);
        sci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScientific();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mF = getMenuInflater();
        mF.inflate(R.menu.calc_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
                openSet();
                return true;

            case R.id.item2:
                Toast.makeText(this, "Preference Selected: Currently not available!!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                Toast.makeText(this, "Help Selected", Toast.LENGTH_SHORT).show();
                openHelp();
                return true;

            case R.id.item4:
                Toast.makeText(this, "App closed, Goodbye!!", Toast.LENGTH_LONG).show();
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void openScientific() {
        Intent intent = new Intent(this, ScientificCalculator.class);
        startActivity(intent);
    }

    public void openSimpleCal() {
        Intent intent = new Intent(this, SimpleCalculator.class);
        startActivity(intent);
    }
    public void openSet(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
    public void openHelp(){
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }
}
