package com.example.guanhuawu.address_book;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by guanhua.wu on 2017/7/5.
 */
@DatabaseTable(tableName = "AccountList")
public class Account {

    @DatabaseField(generatedId = true)
    private int id ;

    @DatabaseField(columnName = "title")
    private String title;

    @DatabaseField(columnName = "bookName")
    private String BookName;

    @DatabaseField(columnName = "book")
    private String Book;

    public Account(int id, String title, String bookName, String book) {
        this.id = id;
        this.title = title;
        BookName = bookName;
        Book = book;
    }

    public String getBook() {

        return Book;
    }

    public void setBook(String book) {
        Book = book;
    }

    public Account(int id, String title, String bookName) {

        this.id = id;
        this.title = title;
        BookName = bookName;
    }

    public Account(){}

    public Account(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
