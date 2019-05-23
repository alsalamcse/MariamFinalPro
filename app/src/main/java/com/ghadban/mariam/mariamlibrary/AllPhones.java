package com.ghadban.mariam.mariamlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class AllPhones extends AppCompatActivity {
    private Button btnAdd;
    private ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        lst = (ListView) findViewById(R.id.lst);
    }

    public void onClick(View v) {
        if (v == btnAdd) {
            Intent Intent = new Intent(AllPhones.this, phonesData.class);
            startActivity(Intent);
        }
    }
}