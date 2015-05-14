package com.zoomcreativo.turbo_menufragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    Button acerca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acerca = (Button) findViewById(R.id.acercab);
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

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mhot) {
            Hoteles fragment = new Hoteles();
            fragmentTransaction.replace(android.R.id.content,fragment).commit();
        }
        if (id == R.id.mbar) {
            Bares fragment = new Bares();
            fragmentTransaction.replace(android.R.id.content,fragment).commit();
        }
        if (id == R.id.minfo) {
            Informacion fragment = new Informacion();
            fragmentTransaction.replace(android.R.id.content,fragment).commit();
        }
        if (id == R.id.mdemo) {
            Demografia fragment = new Demografia();
            fragmentTransaction.replace(android.R.id.content,fragment).commit();
        }
        if (id == R.id.macerca) {
            Acercade fragment = new Acercade();
            fragment.show(fragmentManager,"MyDialog");
        }

        return super.onOptionsItemSelected(item);
    }

    public void acercadeb(View view){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Acercade fragment = new Acercade();
        fragment.show(fragmentManager,"MyDialog");
    }
}
