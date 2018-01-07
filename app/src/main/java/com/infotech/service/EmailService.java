package com.infotech.service;

/**
 * Created by davidyuan on 1/6/18.
 */

public interface EmailService {
    void send(String to, String from, String subject, String message);
}
