import com.sdm.pojo.Dog;
import com.sdm.pojo.Product;
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

        //普通工厂模式
        Product pro1 = (Product) applicationContext.getBean("pro");
        pro1.desc();

        //静态工厂模式
        Product pro2 = (Product) applicationContext.getBean("pro2");
        pro2.desc();
    }
}