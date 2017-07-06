package com.example.guanhuawu.address_book;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by guanhua.wu on 2017/7/5.
 */
@DatabaseTable(tableName = "Accounts")
public class Account {

    @DatabaseField(generatedId = true)
    private int id ;

    @DatabaseField
    private String title;

    public Account(){}

    public Account(int id, String title) {
        this.id = id;
        this.title = title;
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
