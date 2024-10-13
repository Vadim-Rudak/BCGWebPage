package com.bears.webPage.service;

import com.bears.webPage.domain.Message;

public interface EmailService {
    void sendMessage(Message message);
}
