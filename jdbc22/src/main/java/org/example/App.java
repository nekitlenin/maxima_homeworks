package org.example;

public class App 
{
    public static void main( String[] args )
    {
        CarsDao carsDao = new CarsDao();
        carsDao.createCarsTable();

//        carsDao.dropCarsTable();

        carsDao.addCarsTable("Ford",
                "Focus",
                "Н135ОУ716",
                java.sql.Date.valueOf("1999-8-4"));
        carsDao.addCarsTable("Honda",
                "Civic",
                "А001АА716",
                java.sql.Date.valueOf("2012-1-2"));
        carsDao.addCarsTable("Skoda",
                "Oktavia",
                "У659АН716",
                java.sql.Date.valueOf("2008-11-2"));

//        System.out.println(carsDao.getListOfCarCarsTable());
//        carsDao.deleteCarById(2);

//        carsDao.cleanCarsTable();
    }
}
