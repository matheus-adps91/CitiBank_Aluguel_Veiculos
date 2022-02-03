package aula13.exercicio1.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import aula13.exercicio1.exception.CarCategoryNotFoundException;
import aula13.exercicio1.exception.CarNotFoundException;
import aula13.exercicio1.exception.ClientNotFoundException;
import aula13.exercicio1.model.Car;
import aula13.exercicio1.model.CarCategory;
import aula13.exercicio1.model.Client;
import aula13.exercicio1.model.Rent;
import aula13.exercicio1.model.enums.Category;
import aula13.exercicio1.printer.Printer;
import aula13.exercicio1.reader.Reader;

public class CarRentService
{
    public static void creatCarRent(
        final Map<String, Client> dataBaseClient,
        final Map<CarCategory, List<Car>> dataBaseRent )
    {
        Printer.printWelcomeMessage();
        do {
            Printer.printMenuRent( dataBaseRent );
            Printer.printMessage( "Digite a categoria do veículo a ser alugado" );
            String sCategory = Reader.input.next();
            Set<CarCategory> Categories = dataBaseRent.keySet();         
            CarCategory carCategory = null;
            try {
                carCategory = getCarCategory( sCategory, Categories );
            } catch( CarCategoryNotFoundException e ) {
                Printer.printMessage( e.getMessage() );
                Printer.printErrorMessage( );
                Printer.printLine();
                break;
            }
            
            Printer.printMessage( "Digite o código do veículo a ser alugado" );
            String idToRent = Reader.input.next();
            List<Car> cars = dataBaseRent.get( carCategory );
            
            Car car = null;
            try {
                car = getCar( cars, idToRent );
            } catch ( CarNotFoundException e ) {
               Printer.printMessage( e.getMessage() );
               Printer.printErrorMessage();
               Printer.printLine();
               break;
            }
            
            Printer.printMessage( "Digite quantos dias o veículo ficará alugado" );
            int dayQuantityToRent = Reader.input.nextInt();
            Printer.printMessage( "Digite a quantidade de veículos a ser alugado" );
            int carQuantityToRent = Reader.input.nextInt();
            
            Rent rent = new Rent( carQuantityToRent, dayQuantityToRent, car, carCategory );
            
            Printer.printMessage( "Digite o ID do usuário que está efetuando a logação" );
            String userId = Reader.input.next();
            Client client = null;
            try {
                client = ClientService.findClientById( dataBaseClient, userId );
            } catch( ClientNotFoundException e ) {
                Printer.printMessage( e.getMessage() );
                Printer.printErrorMessage();
                Printer.printLine();
                break;
            }
            client.addRent( rent );
            float rentCost = calculate( rent );
            client.increaseSumRent( rentCost );
            Printer.printMessage( "Locação concluída com sucesso" );
            Printer.printLine();
            Printer.printMessage( "Deseja fazer uma nova locação [ 0 - Não / 1 - Sim ]" );
            int option = Reader.input.nextInt();
            if ( option == 0 )
                break;
        } while ( true );
    }

    private static CarCategory getCarCategory(
        final String category,
        final Set<CarCategory> categories ) 
            throws CarCategoryNotFoundException
    {
        if ( Category.BASIC.getVehicleCategory().equals( category ) )
            return new CarCategory( Category.BASIC );
        if ( Category.INTERMEDIUM.getVehicleCategory().equals( category ) )
            return new CarCategory( Category.INTERMEDIUM );
        if ( Category.EXECUTIVE.getVehicleCategory().equals( category ) )
            return new CarCategory( Category.EXECUTIVE );
        if ( Category.PREMIUM.getVehicleCategory().equals( category ) )
            return new CarCategory( Category.PREMIUM );
        throw new CarCategoryNotFoundException( category );
    }
    
    private static Car getCar(
        final List<Car> cars,
        final String id) 
            throws CarNotFoundException 
    {
        for( Car car : cars ) {
           if( car.getSourceId().equals( id ) )
               return car;
        }
        throw new CarNotFoundException( id );
    }
    
    private static float calculate(
        final Rent rent ) 
    {
        return rent.getQuantity() * rent.getDays() * rent.getCar().getDairy();
    }
    
}