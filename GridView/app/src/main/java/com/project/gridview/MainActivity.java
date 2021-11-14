package com.project.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] dogIds = {R.drawable.dog1,R.drawable.dog2,R.drawable.dog3,R.drawable.dog4,R.drawable.dog5,
            R.drawable.dog6,R.drawable.dog7,R.drawable.dog8,R.drawable.dog9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("GridView");

        final ImageView imageView = (ImageView)findViewById(R.id.imageView);
        GridView gridView = (GridView)findViewById(R.id.gridView);

        MyAdapter adapter = new MyAdapter(this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                imageView.setImageResource(dogIds[position]);
            }
        });
    }

    class MyAdapter extends BaseAdapter {
        Context mcontext;

        public MyAdapter(Context c){
            mcontext = c;
        }

        @Override
        public int getCount() {
            return dogIds.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView iv = new ImageView(mcontext); //顯示圖片
            iv.setImageResource(dogIds[position]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setLayoutParams(new GridView.LayoutParams(240,180));
            return iv;

            //顯示文字
            /*TextView t = new TextView(mcontext);
            t.setText("dog" + String.valueOf(position));
            t.setTextColor(Color.rgb(255,0,0));
            t.setLayoutParams(new GridView.LayoutParams(240,120));
            return  t;*/
        }
    }
}
