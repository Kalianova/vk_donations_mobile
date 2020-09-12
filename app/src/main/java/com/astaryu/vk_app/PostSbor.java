package com.astaryu.vk_app;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class PostSbor extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_sbor);

        SQLiteDatabase myDB =
                openOrCreateDatabase("my.db", MODE_PRIVATE, null);

        TextView textView = findViewById(R.id.textView10);

    }
}