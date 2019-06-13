package com.ghadban.mariam.mariamlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class phonesData extends AppCompatActivity {
    private Button btnSave;
    private TextView tvData;
    private EditText etName;
    private EditText etPrice;
    private EditText etCompany;
    private EditText etYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phones_data);
        btnSave = (Button) findViewById(R.id.btnSave);
        tvData = (TextView) findViewById(R.id.tvData);
        etName = (EditText) findViewById(R.id.etName);
        etPrice = (EditText) findViewById(R.id.etPrice);
        etCompany = (EditText) findViewById(R.id.etCompany);
        etYear = (EditText) findViewById(R.id.etYear);

    }
    public void onClick(View v){
        if (v == btnSave)
        {
            String n = etName.getText().toString();
            String p = etPrice.getText().toString();
            String c = etCompany.getText().toString();
            String y = etYear.getText().toString();

            Double d=Double.parseDouble(p);
           Integer i=Integer.parseInt(y);

            MyPhone myPhone = new MyPhone ();
            myPhone.setName(n);
            myPhone.setPrice(d);
            myPhone.setCompany(c);
            myPhone.setYear(i);

            MyPhoneTable myPhoneTable=new MyPhoneTable(this);
            myPhoneTable.addPhone(myPhone);
            Intent Intent = new Intent(phonesData.this,AllPhones.class);
            startActivity(Intent);
        }
    }
}
