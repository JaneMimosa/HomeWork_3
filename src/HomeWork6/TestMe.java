package HomeWork6;

public class TestMe {
    @BeforeSuite
    void beforeSuite() {
        System.out.println("BeforeSuite");
    }
    @AfterSuite
    void afterSuite() {
        System.out.println("AfterSuite");
    }
    @Test (priority = 1)
    void method1() {
        System.out.println("Method 1 with priority 1");
    }
    @Test (priority = 4)
    void method2() {
        System.out.println("Method 2 with priority 4");
    }
    @Test
    void method3() {
        System.out.println("Method 3 with default priority");
    }
    @Test (priority = 8)
    void method4() {
        System.out.println("Method 4 with priority 8");
    }
}
