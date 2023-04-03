package com.example.perpustakaan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.perpustakaan.FormEditBuku;
import com.example.perpustakaan.R;
import com.example.perpustakaan.crud.BookCrud;
import com.example.perpustakaan.model.Book;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    public BookAdapter(Context context, List<Book> objects) {
        super(context,0,objects);
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        Book book = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_listviewbook,parent,false);
        }

        TextView txvId = (TextView) convertView.findViewById(R.id.id);
        TextView txvTitle = (TextView) convertView.findViewById(R.id.title);
        TextView txvAuthor = (TextView) convertView.findViewById(R.id.author);
        TextView txvPublisher = (TextView) convertView.findViewById(R.id.publisher);
        TextView txvYear = (TextView) convertView.findViewById(R.id.year);
        txvId.setText(book.getId());
        txvTitle.setText(book.getTitle());
        txvAuthor.setText(book.getAuthor());
        txvPublisher.setText(book.getPublisher());
        txvYear.setText(book.getYear());

        ImageButton btnEdit = (ImageButton) convertView.findViewById(R.id.edit);
        ImageButton btnDelete = (ImageButton) convertView.findViewById(R.id.delete);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FormEditBuku.class);
                intent.putExtra("id",book.getId());
                intent.putExtra("title",book.getTitle());
                intent.putExtra("author",book.getAuthor());
                intent.putExtra("publisher",book.getPublisher());
                intent.putExtra("year",book.getYear());
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookCrud bookCrud = new BookCrud();
                bookCrud.deleteDataBuku(book.getId());
                notifyDataSetChanged();
            }
        });


        return convertView;
    }
}
