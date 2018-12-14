package com.example.emergencyphone;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.emergencyphone.db.DatabaseHelper;

import static com.example.emergencyphone.db.DatabaseHelper.COL_ID;
import static com.example.emergencyphone.db.DatabaseHelper.COL_NUMBER;
import static com.example.emergencyphone.db.DatabaseHelper.COL_TITLE;
import static com.example.emergencyphone.db.DatabaseHelper.COL_LOCATION;
import static com.example.emergencyphone.db.DatabaseHelper.TABLE_NAME;

public class EditTeaItemActivity extends AppCompatActivity {

    private EditText mTitleEditText;
    private EditText mNumberEditText;
    private EditText mLocationEditText;
    private Button mSaveButton;

    private long mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_item);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String number = intent.getStringExtra("number");
        final String location = intent.getStringExtra("location");
        mId = intent.getLongExtra("id", 0);

        mTitleEditText = findViewById(R.id.title_edit_text);
        mNumberEditText = findViewById(R.id.number_edit_text);
        mLocationEditText = findViewById(R.id.location_edit_text);
        mSaveButton = findViewById(R.id.save_button);

        mTitleEditText.setText(title);
        mNumberEditText.setText(number);
        mLocationEditText.setText(location);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseHelper helper = new DatabaseHelper(EditTeaItemActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();

                String newTitle = mTitleEditText.getText().toString().trim();
                String newNumber = mNumberEditText.getText().toString().trim();
                String newlocation = mLocationEditText.getText().toString().trim();

                ContentValues cv = new ContentValues();
                cv.put(COL_TITLE, newTitle);
                cv.put(COL_NUMBER, newNumber);
                cv.put(COL_LOCATION, newlocation);

                db.update(
                        TABLE_NAME,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(mId)}
                );
                finish();
            }
        });
    }
}
