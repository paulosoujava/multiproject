package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Paulo on 07/03/2018.
 */

@SuppressWarnings("ALL")
public class MyCustomAsyncTask extends AsyncTask<Object,Object,Object> {


    private ProgressBar progressBar;
    private MyApi myApiService = null;
    private String s = "";
    private OnTaskCompleted taskCompleted;



    public MyCustomAsyncTask(ProgressBar progressBar,  MyApi myApiService,OnTaskCompleted activityContext) {
        this.progressBar = progressBar;
        this.myApiService = myApiService;
        this.taskCompleted = activityContext;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }



        try {
            taskCompleted.onTaskCompleted(myApiService.tellJoke().execute().getData());

            return taskCompleted;

        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(Object o) {
        progressBar.setVisibility(View.INVISIBLE);

    }
}
