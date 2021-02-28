import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;



public class Task2 {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Hello hello = new Hello();
        modifiers(hello);
    }

    public static void modifiers(Object o) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        Class<?> aClass = o.getClass();



        Field[] fields = aClass.getDeclaredFields();
        Constructor declaredConstructor = aClass.getConstructor();


        for (Field field : fields) {
            int modifiers = field.getDeclaringClass().getModifiers();


            Object b = declaredConstructor.newInstance();
            Field fieldResult = aClass.getDeclaredField(field.getName());
            if (!fieldResult.isAnnotationPresent(Ignorre.class)) {

            fieldResult.setAccessible(true);
            Object value = fieldResult.get(b);


                System.out.println("Модификатор: " + (Modifier.toString(modifiers)) + " Имя класса - " + fieldResult.getName() + "; Значение: " + value);
            }
        }
    }
}
