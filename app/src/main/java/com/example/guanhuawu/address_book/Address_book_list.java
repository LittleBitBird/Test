package com.example.guanhuawu.address_book;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.SQLException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Address_book_list extends AppCompatActivity {
    AccountDao accountDao;

    @BindView(R.id.create_table)
    Button create_table;

    @BindView(R.id.Query)
    Button Query;

    @BindView(R.id.textView)
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_book_list);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.d("1", "onClick: success 测试");
        try {
            accountDao = new AccountDao(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.Query)
    public void Query() {
        textView.setText("成功1");
        Account account = new Account();
        try {
            account = accountDao.getAccountDao().queryForAll().get(0);
            Log.d("query", "onClick: " + account.getTitle());
        } catch (SQLException e) {
            e.printStackTrace();
            Log.d("query", "onClick: 查询失败");
        }
    }

    @OnClick(R.id.create_table)
    public void Create_table() {
        textView.setText("成功2");
        Account account = new Account();
        account.setTitle("SQ");
        try {
            accountDao.getAccountDao().create(account);
            Log.d("create", "onClick: 成功");
            textView.setText("成功");
        } catch (SQLException e) {
            e.printStackTrace();
            Log.d("create", "onClick: 失败");
            textView.setText("失败");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_address_book_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
