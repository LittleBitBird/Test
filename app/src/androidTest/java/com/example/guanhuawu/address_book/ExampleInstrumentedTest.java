package com.example.guanhuawu.address_book;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;

import static android.support.test.InstrumentationRegistry.getContext;

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
        Context appConßtext = InstrumentationRegistry.getTargetContext();


//        assertEquals("com.example.guanhuawu.address_book", appContext.getPackageName());
    }
    @Test
    public void testAddAccount() throws SQLException{
        Account account = new Account();
        account.setTitle("SQ");
        Context context = getContext();
        AccountDao accountDao = new AccountDao(context);
//        System.out.print(accountDao.getAll().get(0).getTitle());
    }

}
