package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import receita.com.br.mylibrary.MainLibraryActivity;



public class MainActivity extends AppCompatActivity implements OnTaskCompleted {

    private ProgressBar progressBar;
    private MyCustomAsyncTask myCustomAsyncTask;
    private MyApi myApiService = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress);
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

    public void tellJoke(View view) {
       MyCustomAsyncTask task =  myCustomAsyncTask = new MyCustomAsyncTask(progressBar,myApiService, MainActivity.this);
       task.execute();
    }



    public IdlingResource getIdlingResource() {
        return new IdlingResource() {
            @Override
            public String getName() {
                return "idling";
            }

            @Override
            public boolean isIdleNow() {
                return false;
            }

            @Override
            public void registerIdleTransitionCallback(ResourceCallback callback) {

            }
        };
    }


    @Override
    public void onTaskCompleted(String response) {
        Log.d("LOG", response + "-- ");
        Intent it = new Intent(this, MainLibraryActivity.class);
        it.putExtra( MainLibraryActivity.KEY_FOR_JOKE, response );
        startActivity(it);
    }
}
