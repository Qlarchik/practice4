package com.mirea.shakhnazaryan.loadermanger;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

import java.io.Console;
import java.lang.invoke.ConstantCallSite;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyLoader extends AsyncTaskLoader<String> {
    public static final String ARG_WORD = "word";

    private String text;
    private String result;

    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null)
            text = args.getString(ARG_WORD);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        result = "";
        List<String> listText = Arrays.asList(text.split(""));
        Collections.shuffle(listText);
        for (String t : listText) {
            result += t;
        }
        // emulate long-running operation
        SystemClock.sleep(5000);
        return result;
    }
}
