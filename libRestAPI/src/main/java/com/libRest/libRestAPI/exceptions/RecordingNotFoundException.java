package com.libRest.libRestAPI.exceptions;

public class RecordingNotFoundException extends RuntimeException{
    public RecordingNotFoundException(String message) {
        super(message);
    }
}
