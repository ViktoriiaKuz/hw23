
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;



public class Main {


    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {

        Class<Hello> clazz = Hello.class;

        Constructor<Hello> declaredConstructor = clazz.getConstructor();

        Hello hello = declaredConstructor.newInstance();

        Field field = clazz.getDeclaredField("s");

        field.setAccessible(true);


        field.set(hello, "ABCDE");

        System.out.println(field.get(hello));

    }


}

