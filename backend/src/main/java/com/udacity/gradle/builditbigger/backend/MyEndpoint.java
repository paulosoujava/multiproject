package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Named;

import receita.com.br.javajokes.Joker;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    Random r = new Random();
    List<String> myFakeAds;

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke(@Named("name") boolean isMyAds) {
        Joker joker = new Joker();
        MyBean response = new MyBean();
        if( isMyAds )
            response.setData(myAds() +"\n\n"+  joker.getJoker() );
        else
            response.setData("Here your joke: \n"+ joker.getJoker() );

        return response;
    }


    private String myAds(){
        initMyAds();
        return  myFakeAds.get(r.nextInt( myFakeAds.size()));

    }

    private void initMyAds(){
        myFakeAds = new ArrayList<>();
        myFakeAds.add(" Here is a ADS FAKE  ONE ");
        myFakeAds.add(" Here is a ADS FAKE  TWO ");

    }

}
