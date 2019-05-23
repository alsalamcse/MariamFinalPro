import android.arch.lifecycle.ViewModelProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.renderscript.Sampler;

import java.util.ArrayList;

public class MyPhoneTable extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PHONE_DB";
    private static final String TABLE_PHONE = "PHONE_TBL";

    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_Price = "Price";
    private static final String KEY_company = "company";
    private static final String KEY_Production = "Production";
    private static final String KEY_year = "year";

    public MyPhoneTable(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate = "CREATE TABLE " + TABLE_PHONE + "("
                + KEY_ID + "INTEGER PRIMARY KEY,"
                + KEY_NAME + "TEXT,"
                + KEY_Price + "TEXT,"
                + KEY_company + "TEXT,"
                + KEY_Production + "TEXT,"
                + KEY_year + "TEXT" + ")";
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDrop = "DROP TABLE IF EXISTS " + TABLE_PHONE;
        db.execSQL(sqlDrop);
        onCreate(db);

    }

    public long addPhone(MyPhone phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, phone.getName());
        values.put(KEY_Price, phone.getprice());
        values.put(KEY_company, phone.getCompany());
        values.put(KEY_Production, phone.getProduction());
        values.put(KEY_year, phone.getYear());
        long row = db.insert(TABLE_PHONE, null, values);
        db.close();
        return row;
    }

    public int updatePhone(MyPhone phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, phone.getName());
        values.put(KEY_Price, phone.getprice());
        values.put(KEY_company, phone.getCompany());
        values.put(KEY_Production, phone.getProduction());
        values.put(KEY_year, phone.getYear());
        int num = db.update(TABLE_PHONE, values, KEY_ID + "=" + phone.get_id(), null);
        db.close();
        return num;
    }

    public int deleteContactByld(MyPhone phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        int num = db.delete(TABLE_PHONE, KEY_ID + "=" + phone.get_id(), null);
        db.close();
        return num;
    }

    public ArrayList<MyPhone> getAllPhones() {
        ArrayList<MyPhone> phoneList = new ArrayList<MyPhone>();
        String selectQuery = "SELECT*FROM " + TABLE_PHONE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        boolean flag = cursor.moveToFirst();
        while (flag == true) {
            MyPhone phone = new MyPhone();
            phone.set_id(cursor.getLong(0));
            phone.setYear(cursor.getInt(1));
            phone.setName(cursor.getString(2));
            phone.setPrice(cursor.getDouble(3));
            phone.setCompany(cursor.getString(4));
            phone.setProduction(cursor.getString(5));
            phoneList.add(phone);
            flag = cursor.moveToNext();
        }
        return phoneList;
    }