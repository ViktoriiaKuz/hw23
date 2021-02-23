import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


public class Task2 {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Hello hello = new Hello();
        modifiers(hello);
    }

    public static void modifiers(Object o) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        Class<?> aClass = o.getClass();

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "public");
        map.put(2, "private");
        map.put(4, "protected");


        Field[] fields = aClass.getDeclaredFields();
        Constructor declaredConstructor = aClass.getConstructor();


        for (Field field : fields) {
            int modifiers = field.getModifiers();
            String modif = map.get(modifiers);

            Object b = declaredConstructor.newInstance();
            Field fieldResult = aClass.getDeclaredField(field.getName());

            fieldResult.setAccessible(true);
            Object value = fieldResult.get(b);

            if (!fieldResult.isAnnotationPresent(Ignorre.class)) {
                System.out.println("Модификатор: " + modif + " Имя класса - " + fieldResult.getName() + "; Значение: " + value);
            }
        }
    }
}
