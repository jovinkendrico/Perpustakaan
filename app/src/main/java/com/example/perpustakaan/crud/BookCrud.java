package com.example.perpustakaan.crud;

import android.util.Log;

import com.example.perpustakaan.model.Book;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class BookCrud {
    public void tambahDataBuku(String id, String title, String author, String publisher, String year){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    Book book = realm.createObject(Book.class,id);
                    book.setTitle(title);
                    book.setAuthor(author);
                    book.setPublisher(publisher);
                    book.setYear(year);
                }catch (RealmPrimaryKeyConstraintException e){
                    Log.d("Tag","Primary key sudah ada + " + e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
    public void editDataBuku(String id, String title, String author, String publisher, String year){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    Book book = realm.where(Book.class).equalTo("id",id).findFirst();
                    book.setTitle(title);
                    book.setAuthor(author);
                    book.setPublisher(publisher);
                    book.setYear(year);
                }catch (RealmPrimaryKeyConstraintException e){
                    Log.d("Tag","Primary key sudah ada + " + e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
    public void deleteDataBuku(String id){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    Book book = realm.where(Book.class).equalTo("id",id).findFirst();
                    book.deleteFromRealm();
                }catch (RealmPrimaryKeyConstraintException e){
                    Log.d("Tag","Primary key sudah ada + " + e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
}
