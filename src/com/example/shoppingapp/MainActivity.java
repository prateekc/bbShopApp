package com.example.shoppingapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Currency;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.shoppingapp.JSONobjParser.Catagory;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView txtv;
	String stri="";
	ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtv=(TextView) findViewById(R.id.textView1);
        list=(ListView) findViewById(R.id.list);
        final JsonParser jsop=new JsonParser();
        
//        Thread thr=new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				stri=jsop.JsonParse();
//				//txtv.setText(jsop.JsonParse());
//				Thread t=Thread.currentThread();
//				//t.stop();
//				
//			}
//		});
     //   thr.start();
       // while(stri.equals(""));
        do1();
        new ConnectionTask().execute("a");	
       // txtv.setText("a");
    }
    public void do1(){
    	//if you wannna do  connection test
    }
    private class ConnectionTask extends AsyncTask<String, Void, String> {
    	String stri;
    	final JsonParser jsop=new JsonParser();
		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			//stri=jsop.JsonParse();
			JSONObject job=jsop.JsonParse();
			try {
				//JSONArray categories=job.getJSONArray("categories");
				//JSONObject categ= categories.getJSONObject(0);
				ArrayList<Catagory> re=new JSONobjParser().JSONobjParseCat(job);
				//stri=categ.getString("id");
				stri=re.get(1).toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return stri;
		}
		@Override
		protected void onPostExecute(String result) {
			txtv.setText(result+"I am here");
		}
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
}

