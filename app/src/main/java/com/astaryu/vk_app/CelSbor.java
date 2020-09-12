package com.astaryu.vk_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.BitSet;
import java.util.HashMap;

public class CelSbor extends AppCompatActivity {

    String[] data = {"Счёт VK Pay 1234", "Счёт VK Pay 2345", "Счёт VK Pay 3456"};
    private static final int IMAGE_REQUEST = 1;
    Bitmap bitmap = null;
    Button button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cel_sbor);
        setTitle("Целевой сбор");



        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TextView textView = findViewById(R.id.editTextTextPersonName);
                TextView textView1 = findViewById(R.id.editTextNumberSigned);
                TextView textView2 = findViewById(R.id.editTextTextPersonName2);
                TextView textView3 = findViewById(R.id.editTextTextPersonName3);
                Spinner spinner = findViewById(R.id.spinner2);
                ContentValues row1 = new ContentValues();
                row1.put("name", textView.getText().toString());
                row1.put("type", 0);
                row1.put("sum",Integer.parseInt(textView1.getText().toString()));
                row1.put("goal",textView2.getText().toString());
                row1.put("disk",textView3.getText().toString());
                row1.put("money",spinner.getSelectedItem().toString());
                row1.put("author","");

                SQLiteDatabase myDB =
                        openOrCreateDatabase("my.db", MODE_PRIVATE, null);

                myDB.insert("user", null, row1);*/
                startActivity(new Intent(CelSbor.this, dop.class));
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
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
        ImageButton imButton = findViewById(R.id.imageButton);
        imButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImage();
            }
        });
    }

    private void SelectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_REQUEST);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //Detects request codes
        if(requestCode==IMAGE_REQUEST && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                ImageButton imButton = findViewById(R.id.imageButton);
                imButton.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}