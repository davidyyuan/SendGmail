package com.infotech.myconstraint;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.infotech.service.EmailService;
import com.infotech.service.EmailServiceGmailImpl;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    private TextView email;
    private EditText subject;
    private EditText message;
    private EmailService mailService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mailService = new EmailServiceGmailImpl();
        email = (TextView)findViewById(R.id.emailField);
        subject = (EditText)findViewById(R.id.subjectField);
        message = (EditText)findViewById(R.id.messageField);
        Button send = (Button)findViewById(R.id.sendButton);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sub = subject.getText().toString();
                String mes = message.getText().toString();
                String emailAddress = email.getText().toString();
                subject.setText("");
                message.setText("");
                email.setText("");
                Log.i(TAG, "button.click(): to=" + emailAddress + ", subject=" + sub + ", msg=" + mes);
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                emailIntent.setType("vnd.android.cursor.item/email");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {emailAddress});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, sub);
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, mes);
                startActivity(Intent.createChooser(emailIntent, "Send mail using..."));
            }
        });
    }
}
