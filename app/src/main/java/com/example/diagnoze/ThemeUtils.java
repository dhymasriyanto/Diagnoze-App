package com.example.diagnoze;

import android.app.Activity;
import android.content.Intent;

public class ThemeUtils {
    private static int themee;

    public final static int White = 0;
    public final static int Black = 1;

    public static void ubahTema(Activity activity, int theme){
        themee = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity){
        switch (themee){
            default:
            case White:
                activity.setTheme(R.style.LightTheme);
                break;
            case Black:
                activity.setTheme(R.style.DarkTheme);
                break;
        }
    }
}
