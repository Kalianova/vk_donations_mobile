package com.astaryu.vk_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class RegSbor extends AppCompatActivity {

    String[] data = {"Счёт VK Pay 1234", "Счёт VK Pay 2345", "Счёт VK Pay 3456"};
    String[] data2 = {"Матвей Правосудов", "Иван Петров", "Михаил Сидоров"};
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_sbor);

        EditText editText = findViewById(R.id.editTextTextPersonName02);

        setTitle("Регулярный сбор");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        button = findViewById(R.id.button22);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TextView textView = findViewById(R.id.editTextTextPersonName02);
                TextView textView1 = findViewById(R.id.editTextNumberSigned02);
                TextView textView2 = findViewById(R.id.editTextTextPersonName22);
                TextView textView3 = findViewById(R.id.editTextTextPersonName32);
                Spinner spinner = findViewById(R.id.spinner22);
                Spinner spinner1 = findViewById(R.id.spinner02);
                ContentValues row1 = new ContentValues();
                row1.put("name", textView.getText().toString());
                row1.put("type", 1);
                row1.put("sum",Integer.parseInt(textView1.getText().toString()));
                row1.put("goal",textView2.getText().toString());
                row1.put("disk",textView3.getText().toString());
                row1.put("money",spinner.getSelectedItem().toString());
                row1.put("author",spinner1.getSelectedItem().toString());
                SQLiteDatabase myDB = openOrCreateDatabase("my.db", MODE_PRIVATE, null);

                myDB.insert("user", null, row1);*/
                startActivity(new Intent(RegSbor.this, PostSbor.class));
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner22);
        spinner.setAdapter(adapter);
        // заголовок
        spinner.setPrompt("Title");
        // выделяем элемент
        spinner.setSelection(0);
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner02);
        spinner2.setAdapter(adapter2);
        // заголовок
        spinner2.setPrompt("Title");
        // выделяем элемент
        spinner2.setSelection(0);
        // устанавливаем обработчик нажатия
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}