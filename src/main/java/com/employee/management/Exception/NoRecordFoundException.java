package com.employee.management.Exception;

public class NoRecordFoundException extends  Exception{
    public NoRecordFoundException(Object message) {
        super("NoRecordFoundWith "+(String) message);
    }
}
