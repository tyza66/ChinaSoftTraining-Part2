import com.icss.config.SpringConfiguration;
import com.icss.dao.impl.AccountDaoImpl;
import com.icss.pojo.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {
    @Test
    public void test1(){
//        初始化spring容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Account account =  applicationContext.getBean("account", Account.class);
        System.out.println("account  " + account);
        Account account2 =  applicationContext.getBean("account", Account.class);
        System.out.println("account2  " + account2);

        System.out.println("account == account2 " + (account == account2));

        applicationContext.close();
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountDaoImpl accountDaoImpl = applicationContext.getBean("accountDaoImpl", AccountDaoImpl.class);
//        System.out.println("插入返回值 " + accountDaoImpl.insertAccount(new Account(1001,"tom",2000)));
//        System.out.println("修改返回值 " + accountDaoImpl.updateAccountById(new Account(1001,"jack",3000)));
//        System.out.println("删除返回值 " + accountDaoImpl.deleteAccountById(1001));
//        System.out.println(accountDaoImpl.selectAllAccount());
        System.out.println(accountDaoImpl.selectAccountById(1001));
    }

    @Test
    public void test3(){
//        加载配置文件 SpringConfiguration
      ApplicationContext applicationContext =   new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountDaoImpl accountDaoImpl = applicationContext.getBean("accountDaoImpl", AccountDaoImpl.class);
        System.out.println(accountDaoImpl.selectAccountById(1001));
    }
}


