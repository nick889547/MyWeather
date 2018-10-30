package com.example.user_pc.myweather;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.ListView;

import com.example.user_pc.app.MyApplication;
import com.example.user_pc.bean.City;

import java.util.ArrayList;
import java.util.List;


public class SelectCity extends Activity implements View.OnClickListener{
    private ImageView mBackBtn;
    private ListView mCityView;
    private List<String> citycodes = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_city);

        mBackBtn = (ImageView) findViewById(R.id.title_back);
        mBackBtn.setOnClickListener(this);
        initView();
    }

    void initView(){
        mCityView = (ListView) findViewById(R.id.title_list);
        List<String> cityName = new ArrayList<String>();
        List<City> cities = MyApplication.getInstance().getCityList();
        for (int i=0; i<cities.size(); i++){
            cityName.add(cities.get(i).getCity());
            citycodes.add(cities.get(i).getNumber());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cityName);
        mCityView.setAdapter(adapter);
        mCityView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent ite = new Intent();
                ite.putExtra("cityCode", citycodes.get(i));
                setResult(RESULT_OK,ite);
                finish();
            }
            });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                Intent i = new Intent();
                i.putExtra("cityCode", "101160101");
                setResult(RESULT_OK, i);
                finish();
                break;
            default:
                break;
        }
    }
}
