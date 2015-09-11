import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/*
Reflection has the ability to access and mutate all fields, regardless of their visibility.

The final modifier instructs the JVM that no modifications are allowed on that field at all.
 */
public class MutatingPrivateFieldsUsingReflection {

    @Test
    public void mutateGender() throws NoSuchFieldException, IllegalAccessException {
        final Person person = new Person("MP", "M");

        final Field name = person.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "IWFRH");
        Assert.assertEquals("IWFRH", person.getName());

        person.doNothing();
    }

}

final class Person implements Jumma {
     private String name;
     private String gender;

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }


}

interface Jumma {
    default void doNothing() {
        System.out.println("true = " + true);
    }
}
