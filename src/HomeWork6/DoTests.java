package HomeWork6;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class DoTests {

    public static ArrayList<Method> methods = new ArrayList<>();
    public static Method beforeSuite = null;
    public static Method afterSuite = null;

    public static void start(Class classForTests) {
        for (Method declaredMethod : classForTests.getDeclaredMethods()) {
            if (declaredMethod.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuite == null) {
                    beforeSuite = declaredMethod;
                } else {
                    throw new RuntimeException("Method contains more than one 'BeforeSuite' annotation");
                }
            } else if (declaredMethod.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuite == null) {
                    afterSuite = declaredMethod;
                } else {
                    throw new RuntimeException("Method contains more than one 'AfterSuite' annotation");
                }
            } else if (declaredMethod.isAnnotationPresent(Test.class)) {
                methods.add(declaredMethod);
            }
        }

        methods.sort((m1, m2) -> {
            Test annotation1 = m1.getAnnotation(Test.class);
            Test annotation2 = m2.getAnnotation(Test.class);
            int priority1 = annotation1.priority();
            int priority2 = annotation2.priority();
            return priority1 - priority2;

        });

        try {
            Constructor constructor = classForTests.getConstructor();
            Object testClass = constructor.newInstance();
            if (beforeSuite != null) {
                beforeSuite.setAccessible(true);
                beforeSuite.invoke(testClass);
            }
            for (Method method : methods) {
                method.setAccessible(true);
                method.invoke(testClass);
            }
            if (afterSuite != null) {
                afterSuite.setAccessible(true);
                afterSuite.invoke(testClass);
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
