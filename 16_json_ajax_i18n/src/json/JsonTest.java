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
