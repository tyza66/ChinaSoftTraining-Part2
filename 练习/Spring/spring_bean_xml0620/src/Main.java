import com.sdm.pojo.Dog;
import com.sdm.pojo.MoreType;
import com.sdm.pojo.Product;
import com.sdm.pojo.Student;
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
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Dog d1 = (Dog) applicationContext.getBean("d1");
        System.out.println(d1);

        //普通工厂模式
        Product pro1 = (Product) applicationContext.getBean("pro");
        pro1.desc();

        //静态工厂模式
        Product pro2 = (Product) applicationContext.getBean("pro2");
        pro2.desc();

        //注入后之后的对象
        Dog d2 = (Dog) applicationContext.getBean("d2");
        System.out.println(d2);

        //注入后之后的对象
        Dog d3 = (Dog) applicationContext.getBean("d3");
        System.out.println(d3);

        //学生
        Student stu = (Student) applicationContext.getBean("stu");
        System.out.println(stu);

        MoreType mo = (MoreType) applicationContext.getBean("mo");
        System.out.println(mo);

        Student stu1 = (Student) applicationContext.getBean("stu1");
        System.out.println(stu1);

        Dog d4 = (Dog) applicationContext.getBean("d4");
        System.out.println(d4);

        //关闭容器-销毁方法
        applicationContext.close();
    }
}