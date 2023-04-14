package org.example;

import org.example.dao.CarsDao;
import org.example.dao.CarsDaoHibernate;
import org.example.dao.CarsDaoJdbc;
import org.example.dao.CarsDaoSpringHibernate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        /** Используем JDBC */
//        CarsDao carsDaoJdbc = new CarsDaoJdbc();
//        carsDaoJdbc.createCarsTable();
//
//        carsDaoJdbc.addCar("Ford",
//                "Focus",
//                "Н135ОУ716",
//                java.sql.Date.valueOf("1999-8-4"));
//        carsDaoJdbc.addCar("Honda",
//                "Civic",
//                "А001АА716",
//                java.sql.Date.valueOf("2012-1-2"));
//        carsDaoJdbc.addCar("Skoda",
//                "Oktavia",
//                "У659АН716",
//                java.sql.Date.valueOf("2008-11-2"));
//
//        System.out.println(carsDaoJdbc.getListOfCarCarsTable());
////        carsDao.deleteCarById(2);
////        carsDao.cleanCarsTable();
//        carsDaoJdbc.dropCarsTable();
//
//
        /** Используем Hibernate */
//        CarsDao carsDaoHibernate = new CarsDaoHibernate();
//        carsDaoHibernate.createCarsTable();
//
//        carsDaoHibernate.addCar("Ford",
//                "Focus",
//                "Н135ОУ716",
//                java.sql.Date.valueOf("1999-8-4"));
//        carsDaoHibernate.addCar("Honda",
//                "Civic",
//                "А001АА716",
//                java.sql.Date.valueOf("2012-1-2"));
//        carsDaoHibernate.addCar("Skoda",
//                "Oktavia",
//                "У659АН716",
//                java.sql.Date.valueOf("2008-11-2"));
//
//        System.out.println(carsDaoHibernate.getListOfCarCarsTable());
//        carsDao.deleteCarById(2);
//        carsDao.cleanCarsTable();
//        carsDaoHibernate.dropCarsTable();


        /** Используем Spring и Hibernate */
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        CarsDao carsDaoSpringHibernate = applicationContext.getBean(CarsDao.class);

        carsDaoSpringHibernate.addCar("Ford",
                "Focus",
                "Н135ОУ716",
                java.sql.Date.valueOf("1999-8-4"));
        carsDaoSpringHibernate.addCar("Honda",
                "Civic",
                "А001АА716",
                java.sql.Date.valueOf("2012-1-2"));
        carsDaoSpringHibernate.addCar("Skoda",
                "Oktavia",
                "У659АН716",
                java.sql.Date.valueOf("2008-11-2"));

        System.out.println(carsDaoSpringHibernate.getListOfCarCarsTable());
        System.out.println(carsDaoSpringHibernate.selectCarById(2));
    }
}
