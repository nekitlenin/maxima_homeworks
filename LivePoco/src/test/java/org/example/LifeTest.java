package org.example;

import org.example.bean.*;
import org.example.config.ComponentConfig;
import org.example.config.BeanConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeTest {
    private Leaf leafNoContext;
    private Leopard leopardNoContext;

    private Leaf leafXmlContext;
    private Leaf leafXmlContext2;
    private Leopard leopardXmlContext;

    private Leaf leafAnnotationContext;
    private Leopard leopardAnnotationContext;

    private Leaf leafComponentContext;
    private Leopard leopardComponentContext;

    @Before
    public void init() {
        /**
         * Получение готового объекта по традиционному способу
         */
        leafNoContext = new Leaf(new Bug(new Bird(new Spider(new Snake(new Mangust(new Leopard()))))));
        leopardNoContext = new Leopard();

        /**
         * Создание контейнера (Способ с xml-файлом)
         */
        ClassPathXmlApplicationContext xmlContext =
                new ClassPathXmlApplicationContext("life-context.xml");
        /** Получение готового объекта из контейнера по имени класса */
        leafXmlContext = xmlContext.getBean(Leaf.class);
        leopardXmlContext = xmlContext.getBean(Leopard.class);
        /** Получение готового объекта из контейнера по bean id (leaf и leaf2 синглтоны) */
        leafXmlContext2 = (Leaf) xmlContext.getBean("leaf");

        /**
         * Создание контейнера (Способ с аннотациями @Bean)
         */
        AnnotationConfigApplicationContext annotationContext =
                new AnnotationConfigApplicationContext(BeanConfig.class);
        leafAnnotationContext = annotationContext.getBean(Leaf.class);
        leopardAnnotationContext = annotationContext.getBean(Leopard.class);

        /**
         * Создание контейнера (Способ с аннотациями @Component, @Autowired, @ComponentScan)
         */
        AnnotationConfigApplicationContext componentContext =
                new AnnotationConfigApplicationContext(ComponentConfig.class);
        leafComponentContext = componentContext.getBean(Leaf.class);
        leopardComponentContext = componentContext.getBean(Leopard.class);
    }

    /**
     * Тесты традиционного способа без спринга
     */
    @Test
    public void lifeTest_whenLeafNoContextToString_thenLongString() {
        String s = leafNoContext.toString();
        System.out.println(s);
        Assert.assertEquals("Листик съел жучок,жучка съела птичка,птичку съел паук,паука съела змея," +
                "змею съел мангуст,мангуста съел леопард,леопард живёт - поживает!", s);
    }

    @Test
    public void lifeTest_whenLeopardNoContextToString_thenShortString() {
        String s = leopardNoContext.toString();
        System.out.println(s);
        Assert.assertEquals("леопард живёт - поживает!", s);
    }

    /**
     * Тесты XmlConfig
     */
    @Test
    public void lifeTest_whenLeafXmlContextToString_thenLongString() {
        String s = leafXmlContext.toString();
        System.out.println(s);
        Assert.assertEquals("Листик съел жучок,жучка съела птичка,птичку съел паук,паука съела змея," +
                "змею съел мангуст,мангуста съел леопард,леопард живёт - поживает!", s);
    }

    @Test
    public void lifeTest_whenLeafXmlContext2ToString_thenLongString() {
        String s = leafXmlContext2.toString();
        System.out.println(s);
        Assert.assertEquals("Листик съел жучок,жучка съела птичка,птичку съел паук,паука съела змея," +
                "змею съел мангуст,мангуста съел леопард,леопард живёт - поживает!", s);
    }

    @Test
    public void lifeTest_whenLeopardXmlContextToString_thenShortString() {
        String s = leopardXmlContext.toString();
        System.out.println(s);
        Assert.assertEquals("леопард живёт - поживает!", s);
    }

    /**
     * Тесты BeanConfig
     */
    @Test
    public void lifeTest_whenLeafAnnotationContextToString_thenLongString() {
        String s = leafAnnotationContext.toString();
        System.out.println(s);
        Assert.assertEquals("Листик съел жучок,жучка съела птичка,птичку съел паук,паука съела змея," +
                "змею съел мангуст,мангуста съел леопард,леопард живёт - поживает!", s);
    }

    @Test
    public void lifeTest_whenLeopardAnnotationContextToString_thenShortString() {
        String s = leopardAnnotationContext.toString();
        System.out.println(s);
        Assert.assertEquals("леопард живёт - поживает!", s);
    }

    /**
     * Тесты ComponentConfig
     */
    @Test
    public void lifeTest_whenLeafComponentToString_thenLongString() {
        String s = leafComponentContext.toString();
        System.out.println(s);
        Assert.assertEquals("Листик съел жучок,жучка съела птичка,птичку съел паук,паука съела змея," +
                "змею съел мангуст,мангуста съел леопард,леопард живёт - поживает!", s);
    }

    @Test
    public void lifeTest_whenLeopardComponentContextToString_thenShortString() {
        String s = leopardComponentContext.toString();
        System.out.println(s);
        Assert.assertEquals("леопард живёт - поживает!", s);
    }
}
