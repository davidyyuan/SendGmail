package com.infotech.service;

import android.util.Log;

/**
 * Created by davidyuan on 1/6/18.
 */

public class EmailServiceGmailImpl implements EmailService {
    private static final String TAG = "EmailServiceGmailImpl";
    @Override
    public void send(String to, String from, String subject, String message) {
        Log.i(TAG, "EmailServiceGmailImpl.send(): to=" + to + ", from=" + from + ", subject=" + message);
    }
}
