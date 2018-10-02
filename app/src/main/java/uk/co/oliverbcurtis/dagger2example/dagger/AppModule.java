package uk.co.oliverbcurtis.dagger2example.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.oliverbcurtis.dagger2example.DaggerApplication;


/*
Dagger uses this class to check context of the object is meant to be instantiating and resolve on your behalf

This class provides all the dependencies that we will use in our application
 */
@Module public class AppModule {

    private final DaggerApplication application;

    //This is where context is being defined
    public AppModule(DaggerApplication app){
        this.application = app;
    }

    /*
    First Dagger will look for the context object, which is below.
    Therefore we no longer need to say, "I want shared prefs and here is the context", dagger will handle this
    Provided that context is provided in the same file as the file you reference your shared preferences.

    Dagger can treat the object as a singleton, so you don't have to say anymore, that if there is an instance object
    return it, otherwise create it and then return it etc.
     */
    @Provides @Singleton
    Context providesApplicationContext(){

        return application;
    }

    @Provides @Singleton
    SharedPreferences providesSharedPreferences(Context app){
        return app.getSharedPreferences("MY_PREFS_TITLE", Context.MODE_PRIVATE);
    }

    @Provides
    Resources providesResources(){
        return application.getResources();
    }

    /*
    If we wanted Dagger to reference to an object we could do the following:

     this requires 2 classes, and Dagger gets here and thinks ok, i need to provide a special object of type MyObject
     But it also needs Object 2 and Object 3, which it then looks for (shown below)

    @Provides MyObject providesMySpecialObject(Object object2, Object object3){

        return whatever...
    }

    @Provides Object3 providesMyObject2(){

        return myObject3
    }

    @Provides Object2 providesMyObject3(){

        return myObject2
    }
     */
}
