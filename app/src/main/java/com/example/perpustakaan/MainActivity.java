package com.example.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.perpustakaan.adapter.BookAdapter;
import com.example.perpustakaan.model.Book;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Book> book = realm.where(Book.class).findAll();

        ArrayList<Book> arrayBook = new ArrayList<Book>();
        arrayBook.addAll(realm.copyFromRealm(book));
        realm.close();
        BookAdapter bookAdapter = new BookAdapter(this,arrayBook);
        ListView listViewBook = (ListView) findViewById(R.id.listviewbook);
        listViewBook.setAdapter(bookAdapter);

        Button btnTambah = (Button) findViewById(R.id.btnTambahData);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),FormTambahBuku.class);
                startActivity(intent);
            }
        });

    }
}