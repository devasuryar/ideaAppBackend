package com.devasurya.ideaApp.exception;

import org.springframework.mail.MailException;

public class SpringIdeaAppException extends RuntimeException {
    public SpringIdeaAppException(String s, Exception e) {
        super(s);
    }
}
