package com.example.projectlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustormAdaptor extends RecyclerView.Adapter<CustormAdaptor.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList<String> book_id, book_title, book_author, book_pages;

    CustormAdaptor(Activity activity, Context context, ArrayList<String> book_id, ArrayList<String> book_title, ArrayList<String> book_author, ArrayList<String> book_pages) {
        this.activity = activity;
        this.context = context;
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_pages = book_pages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_raw, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.book_id_txt.setText(book_id.get(position));
        holder.book_title_txt.setText(book_title.get(position));
        holder.book_author_txt.setText(book_author.get(position));
        holder.book_pages_txt.setText(book_pages.get(position));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = holder.getAdapterPosition();
                if (clickedPosition != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(context, UpdateActivity.class);
                    intent.putExtra("id", book_id.get(clickedPosition));
                    intent.putExtra("title", book_title.get(clickedPosition));
                    intent.putExtra("author", book_author.get(clickedPosition));
                    intent.putExtra("pages", book_pages.get(clickedPosition));
                    activity.startActivityForResult(intent, 1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView book_id_txt, book_title_txt, book_author_txt, book_pages_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_txt = itemView.findViewById(R.id.book_id_text);
            book_title_txt = itemView.findViewById(R.id.book_title_text);
            book_author_txt = itemView.findViewById(R.id.book_author_text);
            book_pages_txt = itemView.findViewById(R.id.book_pages_text);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
