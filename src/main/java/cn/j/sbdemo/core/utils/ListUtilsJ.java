package cn.j.sbdemo.core.utils;

import org.springframework.dao.DuplicateKeyException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author J
 * @Date 2018/10/8 16:39
 **/
public class ListUtilsJ {

    /**
     * @param list
     * @param keyName   作为map的key的字段名
     * @param valueName 作为map的value的字段名
     *                  @descrip
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @SuppressWarnings("unchecked")
    public static <K, V, T> Map<K, V> toMap(List<T> list, String keyName, String valueName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<K, V> result = new HashMap<>(list.size());
        for (T item : list) {
            if (item instanceof Map) {
                K key = (K) ((Map<String, Object>) item).get(keyName);
                if (result.containsKey(key)) {
                    throw new DuplicateKeyException("key 不唯一");
                }
                result.put(
                        key,
                        (V) ((Map<String, Object>) item).get(valueName)
                );
            } else {
                Method getKey = item.getClass().getMethod("get" + keyName.substring(0, 1).toUpperCase() + keyName);

                K key = (K) getKey.invoke(getKey);
                if (result.containsKey(key)) {
                    throw new DuplicateKeyException("key 不唯一");
                }

                Method getValue = item.getClass().getMethod("get" + valueName.substring(0, 1).toUpperCase() + valueName);
                result.put(
                        (K) getKey.invoke(getKey),
                        (V) getKey.invoke(getValue)
                );
            }
        }
        return result;
    }
}
