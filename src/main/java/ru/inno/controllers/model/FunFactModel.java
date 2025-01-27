package ru.inno.controllers.model;

import java.util.Map;

public record FunFactModel(long id, String fact) {

    public FunFactModel(Map.Entry<Long, String> mapEntry) {
        this(mapEntry.getKey(), mapEntry.getValue());
    }
}
