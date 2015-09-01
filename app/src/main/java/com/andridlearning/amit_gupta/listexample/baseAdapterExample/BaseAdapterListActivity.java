package com.andridlearning.amit_gupta.listexample.baseAdapterExample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.andridlearning.amit_gupta.listexample.R;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapterListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseadapter_activity_example);

        MyBaseAdapter adapter = new MyBaseAdapter();
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base_adapter_list, menu);
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

    class MyModelText{
        String text1;
        String text2;
    }

    class MyBaseAdapter extends BaseAdapter {

        List<MyModelText> listData = getMyListData();



        @Override
        public int getCount() {
           return listData.size();
        }

        @Override
        public Object getItem(int i) {
            return listData.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(i %2 == 0){
                if(view == null) {
                    LayoutInflater inflater = (LayoutInflater) BaseAdapterListActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(R.layout.list_item_single_row, viewGroup, false);
                }
                TextView textView = (TextView)view.findViewById(R.id.textView3);
                textView.setText("Hello");

            }else {


                if (view == null) {
                    LayoutInflater inflater = (LayoutInflater) BaseAdapterListActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(R.layout.list_row_with_thumnail_arrow, viewGroup, false);
                }
                TextView textView1 = (TextView) view.findViewById(R.id.textView1);
                TextView textView2 = (TextView) view.findViewById(R.id.textView2);
                MyModelText modelText = listData.get(i);
                textView1.setText(modelText.text1);
                textView2.setText(modelText.text2);
            }

            return view;
        }
    }

    public List<MyModelText> getMyListData(){
        List<MyModelText> list = new ArrayList<MyModelText>();

        for(int i=0; i < 35; i++){
            MyModelText modelText = new MyModelText();
            modelText.text1 = "This is First Line Text: "+i;
            modelText.text2 = "This is Second Line Text:"+i;
            list.add(modelText);
        }
        return list;

    }
}
