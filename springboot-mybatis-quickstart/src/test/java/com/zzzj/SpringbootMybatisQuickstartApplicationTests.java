package com.zzzj;

import com.zzzj.mapper.UserMapper;
import com.zzzj.pojo.User;
import com.zzzj.pojo.User2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest//当前测试类中的测试方法运行时，会启动整个SpringBoot应用-一旦启动会创建好IOC容器
class SpringbootMybatisQuickstartApplicationTests {
    @Autowired//注入UserMapper接口的实现类对象
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);
    }
    @Test
    public void testDeleteById() {
        System.out.println("执行完毕后影响的行数："+userMapper.deleteById(5));
    }

    @Test
    public void testInsert() {
        User user = new User(null, "666888", "zhouyu", "周瑜", 18);
        System.out.println("执行完毕后影响的行数："+userMapper.insert(user));
    }
    @Test////测试一个不与表中列表名数量完全相同的类时，mb是否会执行

    public void testInsert2() {
        User2 user2 = new User2("gaoyu","高于",18);
        System.out.println("执行完毕后影响的行数："+userMapper.insert2(user2));
    }

    @Test
    public void testUpdate() {
        User user = new User(7, "1212121", "wanou", "玩偶", 20);
        System.out.println("执行完毕后影响的行数："+userMapper.update(user));
    }
    @Test
    public void testUpdate2() {
        //User user = new User(7, "1212121", "wanou", "玩偶", 20);
        User user = new User(7, null, null, null, 21);
        System.out.println("执行完毕后影响的行数："+userMapper.update2(user));
    }

    @Test
    public void testFindById() {
        System.out.println(userMapper.findById("123456","daqiao"));
    }


}
