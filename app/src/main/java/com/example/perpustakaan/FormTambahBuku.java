package com.example.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.perpustakaan.crud.BookCrud;

public class FormTambahBuku extends AppCompatActivity {
    TextView edtId, edtTitle, edtAuthor, edtPublisher, edtYear;
    Button btnTambah;
    String id, title, author, publisher, year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_tambah_buku);

        edtId = (EditText) findViewById(R.id.edtId);
        edtTitle = (EditText) findViewById(R.id.edtTitle);
        edtAuthor = (EditText) findViewById(R.id.edtAuthor);
        edtPublisher = (EditText) findViewById(R.id.edtPublisher);
        edtYear = (EditText) findViewById(R.id.edtYear);

        btnTambah = (Button) findViewById(R.id.updtBuku);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = edtId.getText().toString();
                title = edtTitle.getText().toString();
                author = edtAuthor.getText().toString();
                publisher = edtPublisher.getText().toString();
                year = edtYear.getText().toString();

                BookCrud bookCrud = new BookCrud();
                bookCrud.tambahDataBuku(id,title,author,publisher,year);
                finish();
            }
        });


    }
}