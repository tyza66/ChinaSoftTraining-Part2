import com.sdm.pojo.Dog;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //通过new关键字主动创建对象
        //Dog dog = new Dog();
        //IOC控制反转 把对象创建的权利以及管理对象之间的关系交给Spring容器来完成 本质是工厂模式+spring.xml

        //初始化Spring容器 并加载xml
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Dog d1 = (Dog) applicationContext.getBean("d1");
        System.out.println(d1);
    }
}