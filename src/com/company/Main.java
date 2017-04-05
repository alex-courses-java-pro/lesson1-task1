package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        fTheParamsReflectionInvoke();
    }

    @FTheParams(num1 = 6, num2 = 9)
    public static void someMethod(int n1, int n2){
        System.out.println("some method start!");
        System.out.println(n1);
        System.out.println(n2);
        System.out.println("some method end!");
    }

    private static void fTheParamsReflectionInvoke(){
        final Class<?> cls = Main.class;
        Method[] methods = cls.getMethods();
        for (Method m: methods){
            if(m.isAnnotationPresent(FTheParams.class)){
                FTheParams a = m.getAnnotation(FTheParams.class);
                try {
                    m.invoke(null,a.num1(),a.num2());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
