package org.example;

import org.example.bean.Leaf;
import org.example.config.BeanConfig;
import org.example.config.ComponentConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfig.class);
        Leaf leaf = context.getBean(Leaf.class);
        System.out.println(leaf);

        AnnotationConfigApplicationContext context2 =
                new AnnotationConfigApplicationContext(ComponentConfig.class);
        Leaf leaf2 = context2.getBean(Leaf.class);
        System.out.println(leaf2);

        ClassPathXmlApplicationContext context3 =
                new ClassPathXmlApplicationContext("life-context.xml");
        Leaf leaf3 = context3.getBean(Leaf.class);
        System.out.println(leaf3);
    }
}
