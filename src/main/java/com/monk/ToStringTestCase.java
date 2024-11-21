package com.monk;

import java.lang.reflect.Method;

public class ToStringTestCase {

    public static final Method cloneMethod1;
    public static final Method cloneMethod2;
    public static final Method cloneMethod3;

    static {
        try {
            cloneMethod1 = Object.class.getDeclaredMethod("toString");
            cloneMethod1.setAccessible(true);
            cloneMethod2 = Object.class.getDeclaredMethod("toString");
            cloneMethod2.setAccessible(true);
            cloneMethod3 = DataWithOverride.class.getDeclaredMethod("toString");
            cloneMethod3.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        case1(new Data());
        case2(new DataWithOverride());
        case3(new DataWithOverride());
    }

    public static void case1(Data data) {
        try {
            Object clone = cloneMethod1.invoke(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void case2(DataWithOverride data) {
        try {
            Object clone = cloneMethod2.invoke(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void case3(DataWithOverride data) {
        try {
            Object clone = cloneMethod3.invoke(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
