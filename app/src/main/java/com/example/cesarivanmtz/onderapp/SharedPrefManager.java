package com.example.cesarivanmtz.onderapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "fcmsharedprefdemo";
    private static final String KEY_ACESS_TOKEN ="token";

    private static Context mCtx;
    private static SharedPrefManager mIstance;

    private SharedPrefManager(Context context){
        this.mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context){

        if(mIstance==null){
            mIstance= new SharedPrefManager(context);
        }
        return mIstance;
    }

    public boolean storeToken(String token){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(
                SHARED_PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ACESS_TOKEN, token);
        editor.apply();
        return true;
    }
    public String getToken(){
        SharedPreferences sharedPreferences = this.mCtx.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ACESS_TOKEN, null);
    }
}
