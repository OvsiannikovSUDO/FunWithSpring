package ru.inno.repo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.inno.exceptions.EntryNotExistsException;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

@Repository
@Profile({"!local"})
public class FunRepo {

    protected final Map<Long, String> funRepoMap = new ConcurrentHashMap<>();

    public FunRepo() {
        funRepoMap.put(1L, "Fun fact 555");
    }

    public Map<Long, String> getList() {
        return Collections.unmodifiableMap(funRepoMap);
    }

    public int getRecordsCount() {
        return ThreadLocalRandom.current().nextInt();
    }

    public Map.Entry<Long, String> createRecord(String text) {
        long id = ThreadLocalRandom.current().nextLong();
        funRepoMap.putIfAbsent(id, text);
        return Map.entry(id, text);
    }

    public Map.Entry<Long, String> updateRecord(long id, String text) {
        if (funRepoMap.replace(id, text) == null) {
            throw new EntryNotExistsException(id);
        }
        return Map.entry(id, text);
    }

    public void delete(long id) {
        if (funRepoMap.get(id) == null) {
            throw new EntryNotExistsException(id);
        }
        funRepoMap.remove(id);
    }
}
