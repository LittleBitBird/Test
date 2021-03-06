package com.example.guanhuawu.address_book;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guanhua.wu on 2017/7/5.
 */

public class DateBaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String TABLE_NAME = "sqlite-test.db";
    private Context context;

    public DateBaseHelper(Context context) {
        super(context, TABLE_NAME, null, 41);
        this.context = context;
    }

    private Map<String, Dao> daos = new HashMap<String, Dao>();

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Account.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            Log.e("update","old"+i+"new"+i1);

            getAccountDao().executeRaw("ALTER TABLE `AccountList` RENAME TO 'AccountOld3';");
            TableUtils.createTable(connectionSource, Account.class);
            getAccountDao().executeRaw("insert into AccountList (id,title,book,bookName) select id,title,Book,BookName from AccountOld");
            Log.e("update","Success");
//            TableUtils.dropTable(connectionSource, Account.class, true);
//            onCreate(sqLiteDatabase, connectionSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static DateBaseHelper instance;

    public static synchronized DateBaseHelper getHelper(Context context) {
//        context = context.getApplicationContext();
        if (instance == null) {
            synchronized (DateBaseHelper.class) {
                if (instance == null)
                    instance = new DateBaseHelper(context);
            }
        }
        return instance;
    }

    public synchronized Dao getDao(Class clazz) throws SQLException {
        Dao dao = null;
        String className = clazz.getSimpleName();
        if (daos.containsKey(className)) {
            dao = daos.get(className);
        }
        if (dao == null) {
            dao = super.getDao(clazz);
            daos.put(className, dao);
        }
        return dao;
    }


    @Override
    public void close() {
        super.close();

        for (String key : daos.keySet()) {
            Dao dao = daos.get(key);
            dao = null;
        }
    }

    public Dao getAccountDao() throws SQLException {
        return getDao(Account.class);
    }


}
