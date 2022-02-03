package aula13.exercicio1.database;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import aula13.exercicio1.model.Car;
import aula13.exercicio1.model.CarCategory;
import aula13.exercicio1.model.enums.Category;
import aula13.exercicio1.model.enums.Vehicle;

public final class TableRentDataBase
{
    public final static Map<CarCategory,List<Car>> loadDatabase() 
    {
        final List<Car> premiumCars = Arrays.asList( new Car( Vehicle.MUSTANG ), new Car(Vehicle.CAYENNE ) );
        List<Car> executiveCars = Arrays.asList( new Car(Vehicle.HILUX), new Car(Vehicle.TRAILBLAZER ) );
        List<Car> basicCars = Arrays.asList( new Car( Vehicle.UNO ), new Car( Vehicle.GOL ) );
        List<Car> intermediumCars = Arrays.asList( new Car( Vehicle.DUSTER ), new Car(Vehicle.RENEGADE ) );

        Comparator<Car> carComparator = Comparator.comparing( Car::getDairy );
        premiumCars.sort( carComparator );
        executiveCars.sort( carComparator );
        basicCars.sort( carComparator );
        intermediumCars.sort( carComparator );
        
        Comparator<CarCategory> carCategoryComparator = Comparator.comparing( CarCategory::getIndex );
        Map<CarCategory, List<Car>> rentTable = new TreeMap<>( carCategoryComparator );
        rentTable.put( new CarCategory( Category.PREMIUM ), premiumCars );
        rentTable.put( new CarCategory( Category.EXECUTIVE ),  executiveCars );
        rentTable.put( new CarCategory( Category.BASIC ), basicCars );
        rentTable.put( new CarCategory( Category.INTERMEDIUM ), intermediumCars );
        return rentTable;
    }
}
