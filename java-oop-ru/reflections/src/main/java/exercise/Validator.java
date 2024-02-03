package exercise;

import java.lang.reflect.Field;
import java.util.*;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) {
        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        List<String> result = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    Object value = field.get(obj);
                    if (value == null) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }

        public static Map<String, List<String>> advancedValidate(Object obj) {
            Class<?> aClass = obj.getClass();
            Field[] fields = aClass.getDeclaredFields();
            Map<String, List<String>> result = new LinkedHashMap<>();
            for (Field field : fields) {
                field.setAccessible(true);
                String value;
                if (field.isAnnotationPresent(NotNull.class)) {
                    try {
                        if (field.get(obj) != null) {
                            value = field.get(obj).toString();
                            if (value == null) {
                                result.put(field.getName(), List.of("can not be null"));
                            }
                        } else {
                            result.put(field.getName(), List.of("can not be null"));
                        }

                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (field.isAnnotationPresent(MinLength.class)) {
                    MinLength minLength = field.getAnnotation(MinLength.class);
                    try {
                        if (field.get(obj) != null) {
                            value = field.get(obj).toString();
                            if (value.length() < minLength.minLength()) {
                                result.put(field.getName(), List.of("length less than " + minLength.minLength()));
                            }
                        } else {
                            result.put(field.getName(), List.of("length less than " + minLength.minLength()));
                        }

                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return result;
        }
    }
// END
