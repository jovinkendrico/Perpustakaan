package com.example.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.perpustakaan.crud.BookCrud;
import com.example.perpustakaan.model.Book;

public class FormEditBuku extends AppCompatActivity {
    TextView edtIdUpd, edtTitleUpd, edtAuthorUpd, edtPublisherUpd, edtYearUpd;
    Button btnUpdate;
    String id, title, author, publisher, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_edit_buku);
        edtIdUpd = (EditText) findViewById(R.id.edtIdUpd);
        edtTitleUpd = (EditText) findViewById(R.id.edtAuthorUpd);
        edtAuthorUpd = (EditText) findViewById(R.id.edtAuthorUpd);
        edtPublisherUpd = (EditText) findViewById(R.id.edtPublisherUpd);
        edtYearUpd = (EditText) findViewById(R.id.edtYearUpd);

        edtIdUpd.setText(getIntent().getStringExtra("id"));
        edtTitleUpd.setText(getIntent().getStringExtra("title"));
        edtAuthorUpd.setText(getIntent().getStringExtra("author"));
        edtPublisherUpd.setText(getIntent().getStringExtra("publisher"));
        edtYearUpd.setText(getIntent().getStringExtra("year"));

        btnUpdate = (Button) findViewById(R.id.edtUpdateBuku);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = edtIdUpd.getText().toString();
                title = edtTitleUpd.getText().toString();
                author = edtAuthorUpd.getText().toString();
                publisher = edtPublisherUpd.getText().toString();
                year = edtYearUpd.getText().toString();
                BookCrud bookCrud = new BookCrud();
                bookCrud.editDataBuku(id,title,author,publisher,year);
                finish();
            }
        });
    }
}