package com.andridlearning.amit_gupta.listexample.ListActivityExample;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.andridlearning.amit_gupta.listexample.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivityExample extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_list);
        TextView textView = (TextView)findViewById(R.id.textView4);
        textView.setText("Example fo ListActivity adapter extending BaseAdapter. The onView() method is used to inflate the layout of each list item.");
        setListAdapter(new MyListAdapter());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_activity_example, menu);
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

    class MyListModel{
        String text1;
        String text2;
    }

    class MyListAdapter extends BaseAdapter{

        List<MyListModel> list = getListData();

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(view == null){
                LayoutInflater inflater = (LayoutInflater)ListActivityExample.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.listitem,viewGroup,false);
            }
          TextView text1 = (TextView)view.findViewById(R.id.textView1);
            TextView text2 = (TextView)view.findViewById(R.id.textView2);
            MyListModel data = (MyListModel)list.get(i);
            text1.setText(data.text1);
            text2.setText(data.text2);

            return view;
        }
    }

    public List<MyListModel> getListData(){
        List<MyListModel> list = new ArrayList<MyListModel>();

        for(int i =0; i<25; i++){
            MyListModel model = new MyListModel();
            model.text1 = "Header:"+i;
            model.text2 = "Subheader:"+i;
            list.add(model);
        }

        return list;
    }
}
