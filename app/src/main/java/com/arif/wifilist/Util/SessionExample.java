package com.arif.wifilist.Util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.arif.wifilist.MainList;

import java.util.HashMap;

public class SessionExample {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    public static final String NAME = "arif";
    public static final String IS_LOGIN = "false";

    public SessionExample(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createSession(String name) {

        editor.putString(NAME, name);
        editor.commit();
    }

    public HashMap<String, String> getSession() {

        HashMap<String, String> user = new HashMap<String, String>();
        user.put(NAME, pref.getString(NAME, null));

        return user;
    }

    public void logoutUser() {

        editor.clear();
        editor.commit();

        Intent i = new Intent(_context, MainList.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        _context.startActivity(i);
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

}
