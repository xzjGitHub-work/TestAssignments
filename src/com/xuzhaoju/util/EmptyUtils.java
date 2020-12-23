package com.xuzhaoju.util;

import java.util.Collection;
import java.util.Map;

/**
 * @ClassName EmptyUtils
 * @Description 校验空对象工具类
 * @Author mzb
 * @Date 2019/8/29 9:46
 * @Version V1.0.0
 */
public class EmptyUtils {

    public EmptyUtils() {
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() < 1;
    }

    public static boolean isAllEmpty(String[] args) {
        if (args == null) {
            return true;
        } else {
            for(int i = 0; i < args.length; ++i) {
                if (!isEmpty(args[i])) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean hasOneEmpty(String[] args) {
        if (args == null) {
            return false;
        } else {
            for(int i = 0; i < args.length; ++i) {
                if (isEmpty(args[i])) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean isTrimEmpty(String str) {
        return isEmpty(str) ? true : str.trim().length() < 1;
    }

    public static boolean isNotEmpty(Object[] arrs) {
        return !isEmpty(arrs);
    }

    public static boolean isEmpty(Object[] arrs) {
        return arrs == null || arrs.length < 1;
    }

    public static boolean isNotEmpty(Collection<?> colls) {
        return !isEmpty(colls);
    }

    public static boolean isEmpty(Collection<?> colls) {
        return colls == null || colls.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isEqual(Object obj1, Object obj2) {
        if (obj1 == null && obj2 == null) {
            return true;
        } else if (obj1 == null && obj2 != null) {
            return false;
        } else {
            return obj2 == null && obj1 != null ? false : obj1.equals(obj2);
        }
    }

    public static boolean isAnyoneEmpty(Object obj) {
        if (obj == null) {
            return obj == null;
        } else if (obj instanceof Collection) {
            return ((Collection)obj).isEmpty();
        } else if (obj instanceof String) {
            return obj.toString().length() == 0;
        } else if (obj.getClass().isArray()) {
            return ((Object[])obj).length == 0;
        } else {
            return obj instanceof Map ? ((Map)obj).isEmpty() : false;
        }
    }
}
