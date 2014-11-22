package ru.aorlov.social.service;

/**
 * Created by anton on 10.11.14.
 */
public class DuplicateEmailException extends Exception {

    public DuplicateEmailException(String message) {
        super(message);
    }
}

