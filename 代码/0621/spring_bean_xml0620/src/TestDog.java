import com.icss.pojo.Dog;
import com.icss.pojo.MoreType;
import com.icss.pojo.Product;
import com.icss.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDog {
    public static void main(String[] args) {
//        创建狗对象 主动
      /*  Dog dog = new Dog(); //调用无参数构造方法
        System.out.println(" dog " + dog);*/

//        IOC 控制反转  把对象创建的权利以及管理对象之间的关系交给Spring容器完成 (本质 工厂模式 + spring.xml)

//        初始化spring容器 并加载xml ApplicationContext 对象已经被创建
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
       /* Dog dog = (Dog) applicationContext.getBean("d1");
        System.out.println(" dog " + dog);*/
/*//      普通工厂模式
        Product pro1 = (Product) applicationContext.getBean("pro");
        pro1.desc();

//        静态工厂
        Product pro2 = (Product)applicationContext.getBean("pro2");
        pro2.desc();*/

       Student stu1 = (Student)applicationContext.getBean("stu1");
        System.out.println("stu1 " + stu1);
       /*  Student stu2 = (Student)applicationContext.getBean("stu1");
        System.out.println("stu2 " + stu2);
        System.out.println("stu1 == stu2 " + (stu1 == stu2));*/
        MoreType moreType = (MoreType)applicationContext.getBean("mo");
        System.out.println("moreType " + moreType);

        Dog d2 = (Dog)applicationContext.getBean("d2");
        System.out.println("d2" + d2);
//        关闭容器
        applicationContext.close();



    }
}
