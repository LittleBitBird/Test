package com.example.guanhuawu.address_book;

import android.content.Context;
import android.database.Cursor;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        AccountDao accountDao = new AccountDao(appContext);
        Account account = new Account();
        account.setTitle("qwe4qewq");
//        DateBaseHelper dateBaseHelper = new DateBaseHelper(appContext);
//        Log.e("version","version:"+dateBaseHelper.getWritableDatabase().getVersion());
//        accountDao.getAccountDao().executeRaw("ALTER TABLE `AAA` RENAME TO 'AccountList';");

        List<Account> datas = new ArrayList<Account>();
        DateBaseHelper dateBaseHelper = new DateBaseHelper(appContext);
        Cursor cursor = dateBaseHelper.getWritableDatabase().query("AccountOld", null, null, null, null, null, null, null);
        while(cursor.moveToNext()){
            Account userBean = new Account();
            String BookName = cursor.getString(cursor.getColumnIndex("BookName"));
            Integer id = cursor.getInt(cursor.getColumnIndex("id"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String book =cursor.getString(cursor.getColumnIndex("Book"));
            userBean.setId(id);
            userBean.setBook(book);
            userBean.setTitle(title);
            userBean.setBookName(BookName);
            datas.add(userBean);
        }
        dateBaseHelper.getWritableDatabase().close();
        cursor.close();

        Log.e("version","length"+datas.size());
        for (Account account1:datas
             ) {
            accountDao.getAccountDao().create(account1);
        }
//        assertEquals("com.example.guanhuawu.address_book", appContext.getPackageName());
    }

    @Test
    public void testAddAccount() throws SQLException {
        Context appContext = InstrumentationRegistry.getTargetContext();
        AccountDao accountDao = new AccountDao(appContext);
        accountDao.getAccountDao().queryForAll();
//        accountDao.getAccountDao().executeRaw("insert into AccountList (TiTle) select title from AccountOld");
    }

}
