import javax.lang.model.element.Name;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;

public class Main {

    public static void changePersonName(Person person) {
        person.name = "123";
    }

    public static void changeString(String string) {
        string = "1234";
    }

    public static void changePersonId(Person person) {
        person.id = 123;
    }

    public static void changeInt(int id) {
        id = 1234;
    }

    public static void main(String[] args) {
        Person person = new Person();
        Person person1=new Person();
        System.out.println(person.equals(person1));
        Collection collection =new HashSet();

        person.name = "2333";
        person1.name="2333";
        System.out.println(person.hashCode()==person1.hashCode());
        person.id = 2333;
        System.out.println("原名" + person.name + "," + person.id);
        changePersonName(person);
        changePersonId(person);
        System.out.println("对象传递改变属性值后" + person.name + "," + person.id);
        changeString(person.name);
        changeInt(person.id);
        System.out.println("字符串传递改变值后" + person.name + "," + person.id);
        //System.out.println(person.name);
    }
}

class Person {

    String name;
    int id;
}