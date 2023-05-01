package org.example;

import org.example.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);

//        CarsDao carsDao = applicationContext.getBean(CarsDao.class);
    }
}
