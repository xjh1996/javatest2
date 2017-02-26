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
        //这样无法改变person.name中的值，name中存储的是"2333"字符串在堆中的地址，
        //String类型非基本数据类型，但是它与其他类不同的是，它每次赋值时都会
        // 查找常量池中的是否存在，没有则创建该字符串
        System.out.println("引用赋值改变能否成功" + person.name + "," + person.id);
        person.name = "2333";
        person.id = 2333;
        System.out.println("原名" + person.name + "," + person.id);
        changePersonName(person);
        changePersonId(person);
        //person.name和person.id的值发生了改变，person中存储的是person在堆中的地址
        //堆中内容改变，栈中指向的堆地址不变，自然person.name和person.id改变
        System.out.println("对象传递改变属性值后" + person.name + "," + person.id);
        person.name = "2333";
        person.id = 2333;
        changeString(person.name);
        changeInt(person.id);
        //这样无法改变String类型的值,一般来说，从c语言理解，传了一个数组，内容变了，自然能体现到主函数上
        //但是String的重新赋值相当于把这个数组指向了一个新数组，并没有在原数组的内存地址上进行修改，
        // 因此，在主函数中，并无改变，切记切记
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