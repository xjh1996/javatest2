import javax.lang.model.element.Name;
import java.math.BigDecimal;
import java.util.*;

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
        Person person1 = new Person();
        Persons persons = new Persons();
        //结果不为true，因为object的equal方法的比较为return this==obj;比较的是引用的地址
        //若要使其为true可重写equal方法，hashcode也同理
        System.out.println("相同内容对象通过equal()比较相等是否为true" + person.equals(person1));
        System.out.println("相同内容对象通过hashCode()比较相等是否为true" + (person.hashCode() == person1.hashCode()));
        //Collection collection =new HashSet();

        //List<String> list=new ArrayList<>();
        //list.add(233);
        String str = "2333";
        person.name = str;
        str = "1234";
        //不能改变person.name中的值，name中存储的是"2333"字符串在堆中的地址，
        //String类型非基本数据类型，但是它与其他类不同的是，它每次赋值时都会
        // 查找常量池中的是否存在，没有则创建该字符串
        System.out.println("引用赋值改变能否成功" + person.name + "," + person.id);
        person.name = "2333";
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

class Persons {
    Person person1;
}