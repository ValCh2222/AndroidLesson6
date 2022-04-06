package com.mirea.chubuka_v_a.rumireachubukinapractice6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text;
    private EditText text2;
    private TextView texT;
    private TextView texT2;
    private SharedPreferences preferences;
    final String SAVED_NAME = "saved_name";
    final String SAVED_INSTITUTION = "saved_institution";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texT = findViewById(R.id.editTextTextPersonName2);
        texT2 = findViewById(R.id.editTextTextPersonName);
        text = findViewById(R.id.editTextTextPersonName2);
        text2 = findViewById(R.id.editTextTextPersonName);
        findViewById(R.id.button).setOnClickListener(this::onSaveText);
        findViewById(R.id.button2).setOnClickListener(this::onLoadText);
        preferences = getPreferences(MODE_PRIVATE);
    }
    public void onSaveText(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SAVED_NAME, text.getText().toString());
        editor.putString(SAVED_INSTITUTION, text2.getText().toString());
        editor.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }
    public void onLoadText(View view) {
        String name = preferences.getString(SAVED_NAME, "Empty");
        String institution = preferences.getString(SAVED_INSTITUTION, "Empty");
        texT.setText(name);
        texT2.setText(institution);
    }
}