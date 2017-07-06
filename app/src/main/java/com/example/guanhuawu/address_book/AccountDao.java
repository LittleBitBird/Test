package com.example.guanhuawu.address_book;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by guanhua.wu on 2017/7/5.
 */

public class AccountDao {


    private Context context;
    private Dao<Account,Integer> accountDaoOpen;
    private DateBaseHelper helper;

    public AccountDao(Context context){
        this.context = context;
    }

    public Dao<Account,Integer> getAccountDao(Context context) throws SQLException {
        helper = new DateBaseHelper(context);
        return helper.getDao(Account.class);
    }

    @SuppressWarnings("unchecked")
    public void add(Account account) throws SQLException {
        getAccountDao(this.context).create(account);
    }
    @SuppressWarnings("unchecked")
    public List<Account> getAll() throws SQLException {
        return getAccountDao(this.context).queryForAll();
    }
}
