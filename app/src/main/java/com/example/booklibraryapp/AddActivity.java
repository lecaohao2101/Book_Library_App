package com.example.booklibraryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    Button button_back_at_add_book, button_add_at_add_book;
    EditText title_input, author_input, page_input;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_add);
        myDb = new DatabaseHelper(this);

        title_input = findViewById(R.id.title_input);
        author_input = findViewById(R.id.author_input);
        page_input = findViewById(R.id.pages_input);

        //button_back
        button_back_at_add_book = findViewById(R.id.button_back_at_add_book);
        button_back_at_add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        //button_add
        button_add_at_add_book = findViewById(R.id.button_add_at_add_book);
        button_add_at_add_book.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean isInserted = myDb.insertData(title_input.getText().toString(),
//                        author_input.getText().toString(),
//                        page_input.getText().toString());
//                if(isInserted == true)
//                    Toast.makeText(AddActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
//                else
//                    Toast.makeText(AddActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
//            }
            @Override
            public void onClick(View view) {
                DatabaseHelper myDB = new DatabaseHelper(AddActivity.this);
                myDB.addBook(title_input.getText().toString().trim(),
                        author_input.getText().toString().trim(),
                        Integer.valueOf(page_input.getText().toString().trim()));
            }
        });
    }


}
