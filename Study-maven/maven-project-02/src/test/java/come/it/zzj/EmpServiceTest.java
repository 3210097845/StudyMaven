package come.it.zzj;

import com.zzzj.EmpService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("EmpService测试类")

public class EmpServiceTest {

    @BeforeEach
    public void testBefore(){
        System.out.println("before...");
    }

    @AfterEach
    public void testAfter(){
        System.out.println("after...");
    }

    @BeforeAll //该方法必须被static修饰
    public static void testBeforeAll(){
        System.out.println("before all ...");
    }

    @AfterAll //该方法必须被static修饰
    public static void testAfterAll(){
        System.out.println("after all...");
    }

    @Test
    @DisplayName("获取年龄")
    public void testGetAge() throws IllegalAccessException {
        EmpService empService = new EmpService();
        int age = empService.getAge("140624200506207270");
        System.out.println(age);
    }
    //断言
    @DisplayName("测试获取性别")
    @Test
    public void testGetGender() throws IllegalAccessException {
        EmpService empService = new EmpService();
        assertEquals("男",empService.getGender("140624200506207270"),"性别有误差");
        assertThrows(IllegalArgumentException.class,() ->empService.getGender(null));

    }
    @DisplayName("测试获取性别")
    @ParameterizedTest
    @ValueSource(strings ={"140624200506207270","140624200506207210","140624200506207230"})
    public void testGetGender(String idcard) throws IllegalAccessException {//strings中存储的数据会传入到idcard中
        EmpService empService = new EmpService();
        String gender=empService.getGender(idcard);
        assertEquals("男",gender);
    }
}
