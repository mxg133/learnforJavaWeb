package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import pojo.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 孟享广
 * @date 2020-11-01 4:27 下午
 * @description
 *1、什么是 JSON?
 * JSON (JavaScript Object Notation) 是一种轻量级的数据交换格式。易于人阅读和编写。同时也易于机器解析和生成。JSON 采用完全独立于语言的文本格式，而且很多语言都提供了对 json 的支持(包括 C, C++, C#, Java, JavaScript, Perl, Python 等)。 这样就使得 JSON 成为理想的数据交换格式。
 * json 是一种轻量级的数据交换格式。
 * 轻量级指的是跟 xml 做比较。
 * 数据交换指的是客户端和服务器之间业务数据的传递格式。
 *
 *
 * 1.1、JSON 在 JavaScript 中的使用。 1.1.1、json 的定义
 * json 是由键值对组成，并且由花括号(大括号)包围。每个键由引号引起来，键和值之间使用冒号进行分隔， 多组键值对之间进行逗号进行分隔。
 *
 *
 * 1.1.2、json 的访问
 * json 本身是一个对象。
 * json 中的 key 我们可以理解为是对象中的一个属性。
 * json 中的 key 访问就跟访问对象的属性一样: json 对象.key
 *
 *
 * 1.1.3、json 的两个常用方法
 * json 的存在有两种形式。
 * 一种是:对象的形式存在，我们叫它 json 对象。
 * 一种是:字符串的形式存在，我们叫它 json 字符串。
 * 一般我们要操作 json 中的数据的时候，需要 json 对象的格式。
 * 一般我们要在客户端和服务器之间进行数据交换的时候，使用 json 字符串。
 * JSON.stringify() 把 json 对象转换成为 json 字符串
 * JSON.parse() 把 json 字符串转换成为 json 对象
 */
public class JsonTest {
    /**
     * 1.2.1、javaBean和json的互转
     */
    @Test
    public void test1(){
        Person person = new Person(1, "tom");
        // 创建Gson对象实例
        Gson gson = new Gson();
        // toJson方法可以把java对象转换成为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);

        // fromJson把json字符串转换回Java对象
        // 第一个参数是json字符串
        // 第二个参数是转换回去的Java对象类型
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);
    }

    /**
     * 1.2.2、List 和json的互转
     */
    @Test
    public void test2(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "-11-"));
        personList.add(new Person(2, "-22-"));

        Gson gson = new Gson();

        // 把List转换为json字符串
        String personListJsonString = gson.toJson(personList);
        System.out.println(personListJsonString);

        List<Person> json = gson.fromJson(personListJsonString, new PersonListType().getType());
        System.out.println(json);
    }

    /**
     * 1.2.3、map 和json的互转
     */
    @Test
    public void test3(){
        Map<Integer, Person> personHashMap = new HashMap<>();
        personHashMap.put(1, new Person(1, "-11-"));
        personHashMap.put(2, new Person(2, "-22-"));

        Gson gson = new Gson();

        // 把 map 集合转换成为 json字符串
        String personMapJsonString = gson.toJson(personHashMap);
        System.out.println(personMapJsonString);

//        Map<Integer, Person> personMap2 = gson.fromJson(personMapJsonString, new PersonMapType().getType());
        Map<Integer, Person> personMap2 = gson.fromJson(personMapJsonString, new TypeToken<Map<Integer, Person>>(){}.getType());

        System.out.println(personMap2);
        Person p1 = personMap2.get(1);
        System.out.println(p1);
    }

}
