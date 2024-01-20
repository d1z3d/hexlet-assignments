package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private final String path;
    private final Map<String, String> map;

    public FileKV(String path, Map<String, String> map) {
        this.path = path;
        this.map = new HashMap<>(map);
    }

    @Override
    public void set(String key, String value) {
        String data = Utils.readFile(path);
        Map<String, String> db = Utils.unserialize(data);
        db.put(key, value);
        String result = Utils.serialize(db);
        Utils.writeFile(path, result);
    }

    @Override
    public void unset(String key) {
        String data = Utils.readFile(path);
        Map<String, String> db = Utils.unserialize(data);
        db.remove(key);
        String result = Utils.serialize(db);
        Utils.writeFile(path, result);
    }

    @Override
    public String get(String key, String defaultValue) {
        String data = Utils.readFile(path);
        Map<String, String> db = Utils.unserialize(data);
        db.remove(key);
        return Utils.serialize(db);
    }

    @Override
    public Map<String, String> toMap() {
        String data = Utils.readFile(path);
        Map<String, String> db = Utils.unserialize(data);
        return new HashMap<>(db);
    }
}
// END
