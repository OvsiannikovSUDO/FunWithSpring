package ru.inno.exceptions;

public class EntryNotExistsException extends RuntimeException {

    private final long code;

    public EntryNotExistsException(long id) {
        this.code = id;
    }

    public long getCode() {
        return code;
    }
}
