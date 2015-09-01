package com.andridlearning.amit_gupta.listexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.andridlearning.amit_gupta.listexample.ListActivityExample.ListActivityExample;
import com.andridlearning.amit_gupta.listexample.RecyclerViewExample.FeedListActivity;
import com.andridlearning.amit_gupta.listexample.baseAdapterExample.BaseAdapterListActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button arrayAdapterButton = (Button)findViewById(R.id.button);
        arrayAdapterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ArrayAdapterListTestActivity.class);
                startActivity(i);
            }
        });

        Button baseAdapterButton  = (Button)findViewById(R.id.button2);
        baseAdapterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(MainActivity.this, BaseAdapterListActivity.class);
                startActivity(i);
            }
        });

        Button listActivityExampleButton = (Button)findViewById(R.id.button3);
        listActivityExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListActivityExample.class);
                startActivity(i);
            }
        });
        Button recyclerViewButton = (Button)findViewById(R.id.button4);
        recyclerViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FeedListActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
