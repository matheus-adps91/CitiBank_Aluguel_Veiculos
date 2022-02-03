package aula13.exercicio1.printer;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import aula13.exercicio1.model.Car;
import aula13.exercicio1.model.CarCategory;
import aula13.exercicio1.model.Client;

public class Printer
{
    public static void printWelcomeMessage() {
        System.out.printf("%s\n", "Seja bem Vindo Lockerz - Locadora de Veículos"  );
    }
    
    public static void printIdCodeMessage() {
        System.out.printf("%s\n", "Digite seu código de identificação"  );
    }
    
    public static void printMessage(
        final String message) 
    {
        System.out.printf("%s\n", message  );
    }
    
    public static void printRentMenu(
        final Map<CarCategory, List<Car>> rentTable) 
    {
        for( Entry<CarCategory,List<Car>> entry : rentTable.entrySet() ) {
            System.out.println(entry.getKey()+"\n");
            for( Car car : entry.getValue() ) {
                System.out.println( car);
            }
        }
    }

    public static void printLine()
    {
        System.out.println( "---------------------------------------------------------" );
    }

    public static void clientMessage(
        final Client client )
    {
        System.out.println( client );
    }

    public static void printMenuRent(
        final Map<CarCategory,List<Car>> dataBaseRentTable )
    {
        System.out.println( "Carros Disponíveis para locação" );
        printLine();
        for ( Map.Entry<CarCategory, List<Car>> entry : dataBaseRentTable.entrySet() ) {
            System.out.println( entry.getKey() );
            for ( Car car : entry.getValue() ) {
                System.out.println( car );
            }
            printLine();
        }
    }

    public static void printErrorMessage()
    {
        System.out.println( "Operação cancelada, voltando ao menu principal" );
    }
    
    public static void exitMessage()
    {
        System.out.println( "Fechando a aplicação" );
    }
}
