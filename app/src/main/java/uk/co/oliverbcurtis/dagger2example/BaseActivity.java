package uk.co.oliverbcurtis.dagger2example;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

public class BaseActivity extends AppCompatActivity {

    @Inject public
    SharedPreferences prefs;
    @Inject public
    Context context;
    @Inject public
    Resources res;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        Here we are saying cast the getApplication() from the DaggerApplication, get the app component from it,
        because in this case we already have the appComponent defined in the DaggerApplication class as
        we are first injecting from the DaggerApplication class
         */


        ((DaggerApplication) getApplication()).getAppComponent().inject(this);
    }
}
