package ru.inno.model;

import java.util.Map;

public record FunFactModel(String id, String joke) {

    public FunFactModel(Map.Entry<Long, String> mapEntry) {
        this(mapEntry.getKey().toString(), mapEntry.getValue());
    }
}
