package com.ren.admin;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-09 17:26
 * @description:
 *
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith({SpringExtension.class})
 **/
//@SpringBootTest
@DisplayName("Junit5功能测试类")
public class Junit5Test {

  //  @Autowired
  //  private DataSource dataSource;

    /**
     * 测试前置条件
     */
    @DisplayName("测试前置条件")
    @Test
    public void testAssumptions() {
        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println("111111");
    }

    /**
     * 断言：前面的断言失败，后面的断言就不会在执行
     */
    @DisplayName("测试简单断言")
    @Test
    public void testSimpleAssertions() {
        int cal = cal(2, 3);
        // 断言相等
        assertEquals(6,cal,"业务逻辑计算失败");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1,obj2,"两个对象不一样");
    }

    @DisplayName("array assertion")
    @Test
    public void testArray() {
        assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3,5},"两个数组不一样");
    }

    /**
     * 所有断言全部需要成功
     */
    @DisplayName("组合断言")
    @Test
    public void testAll() {
        assertAll("test",
                ()-> assertTrue(true && false,"第一个断言"),
                ()-> assertEquals(1,2,"第二个断言")
                );
    }

    int cal(int i, int j){
        return i+j;
    }

    @DisplayName("测试displayname注解")
    @Test
    public void testDisplayName() {
        System.out.println(1);
    //    System.out.println(dataSource);
    }

    @Disabled
    @DisplayName("测试方法2")
    @Test
    public void test2() {
        System.out.println(2);
    }

    @RepeatedTest(5)
    public void test3() {
        System.out.println(5);
    }

    /**
     * 规定方法超时时间，超出时间测试出异常
     * */
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @Test
    public void testTimeOut() throws InterruptedException {
        Thread.sleep(600);
        System.out.println("超时");
    }

    @BeforeEach
    public void testBeforeEach() {
        System.out.println("测试就要开始了");
    }

    @AfterEach
    public void testAfterEach() {
        System.out.println("测试结束了");
    }

    @BeforeAll
    public static void testBeforeAll() {
        System.out.println("所有测试就要开始了");
    }

    @AfterAll
    public static void testAfterAll() {
        System.out.println("所有测试已经结束了");
    }
}
