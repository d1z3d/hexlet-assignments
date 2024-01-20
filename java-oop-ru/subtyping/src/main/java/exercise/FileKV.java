package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private final String path;

    public FileKV(String path, Map<String, String> map) {
        this.path = path;
        map.forEach(this::set);
    }

    @Override
    public void set(String key, String value) {
        String data = Utils.readFile(path);
        Map<String, String> db = Utils.unserialize(data);
        db.put(key, value);
        Utils.writeFile(path, Utils.serialize(db));
    }

    @Override
    public void unset(String key) {
        String data = Utils.readFile(path);
        Map<String, String> db = Utils.unserialize(data);
        db.remove(key);
        Utils.writeFile(path, Utils.serialize(db));
    }

    @Override
    public String get(String key, String defaultValue) {
        String data = Utils.readFile(path);
        Map<String, String> db = Utils.unserialize(data);
        return db.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String data = Utils.readFile(path);
        return Utils.unserialize(data);
    }
}
// END
