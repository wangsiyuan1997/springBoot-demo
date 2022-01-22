package com.springboot5.admin;

import org.junit.jupiter.api.*;

/**
 * @Date And @Time: 2022/1/14  16:01
 */
@DisplayName("junit5测试类")
public class Junit5Test {


    @DisplayName("DisplayName测试方法")
    @Test
    void testDisplayName(){
        System.out.println(1);
    }

    @DisplayName("简单的断言机制")
    @Test
    void testSimpleAssertions(){
        int count = count(2, 3);
        Assertions.assertEquals(5,count);
        Object obj1 = new Object();
        Object obj2 = new Object();
        Assertions.assertSame(obj1,obj2);

    }

    @Test
    @DisplayName("组合断言测试")
    public void all() {
        Assertions.assertAll("test",
                ()->Assertions.assertEquals(1,1),
                ()->Assertions.assertTrue(1>3));
    }

    int count(int i , int j){
        return i + j;
    }


    @Disabled
    @DisplayName("方法测试2")
    @Test
    void test2(){
        System.out.println(2);
    }

    @BeforeEach
    void testBefore(){
        System.out.println("单元测试就要开始了...");
    }

    @AfterEach
    void AfterEach(){
        System.out.println("单测试结束了...");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有单元测试就要开始了....BeforeAll");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("所有单元测试就要结束了....AfterAll");
    }
}
