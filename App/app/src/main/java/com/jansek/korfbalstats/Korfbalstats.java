package com.jansek.korfbalstats;

import android.app.Application;
import android.content.Context;

public class Korfbalstats extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        Korfbalstats.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return Korfbalstats.context;
    }
}
