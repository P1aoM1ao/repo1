package cn.test.test;

import cn.test.dao.AccountDao;
import cn.test.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    //测试查询
    public void run1() throws IOException {
        //加载MyBatis文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //查询所有的账户信息
        List<Account> list = accountDao.findAll();
        for(Account account : list){
            System.out.println(account);
        }
        //
        //accountDao.saveAccount(acc);
        //关闭资源
        session.close();
        in.close();

    }
    //测试保存
    @Test
    //测试查询
    public void run2() throws IOException {
        Account account = new Account();
        account.setName("伊泽瑞尔");
        account.setMoney(10000d);
        //加载MyBatis文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //保存信息
        accountDao.saveAccount(account);
        //提交事务
        session.commit();
        //关闭资源
        session.close();
        in.close();

    }
}
