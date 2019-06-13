package com.ghadban.mariam.mariamlibrary;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

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

    public void onClick(View v)
    {
        if (v == btnAdd)
        {
            Intent Intent = new Intent(AllPhones.this, phonesData.class);
            startActivity(Intent);
        }
    }
    private void initListView(){
        lst = (ListView) findViewById(R.id.lst);
       // String[] a = {"one", "two", "three"};
        MyPhoneTable myPhoneTable=new MyPhoneTable(this);

        ArrayAdapter<MyPhone>adapter = new ArrayAdapter<MyPhone>(this,android.R.layout.simple_expandable_list_item_1,myPhoneTable.getAllPhones());
        lst.setAdapter(adapter);
        lst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(AllPhones.this, "position:"+position, Toast.LENGTH_SHORT).show();
                MyPhone m = (MyPhone) parent.getItemAtPosition(position);
                Toast.makeText(AllPhones.this, "phone :"+m.getName(),Toast.LENGTH_SHORT).show();
                Intent i = new
                        Intent(Intent.ACTION_DIAL, Uri.parse("tel :"+m.getName()));
                startActivity(i);
                finish();
                return true;
            }
        });
    }

    }
