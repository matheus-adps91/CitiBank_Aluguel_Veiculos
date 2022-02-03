package aula13.exercicio1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aula13.exercicio1.database.TableRentDataBase;
import aula13.exercicio1.model.Car;
import aula13.exercicio1.model.CarCategory;
import aula13.exercicio1.model.Client;
import aula13.exercicio1.printer.Printer;
import aula13.exercicio1.reader.Reader;
import aula13.exercicio1.service.CarRentService;
import aula13.exercicio1.service.ClientService;

public class Controller
{          
    public static void run() 
    {
        final Map<CarCategory, List<Car>> tableRentDataBase = TableRentDataBase.loadDatabase();
        final Map<String, Client> clientDataBase = new HashMap<>();
        boolean repeat = true;
        do {
            Printer.printWelcomeMessage();
            Printer.printMessage( "1 - Cadastrar Cliente" );
            Printer.printMessage( "2 - Consultar Cliente" );
            Printer.printMessage( "3 - Locar Veículo" );
            Printer.printMessage( "4 - Sair" );
            int option = Reader.input.nextInt();
            
            switch(option) {
                case 1:
                    ClientService.createClient(clientDataBase);
                    break;
                case 2:
                    ClientService.getClient(clientDataBase);
                    break;
                case 3:
                    CarRentService.creatCarRent( clientDataBase, tableRentDataBase );
                    break;
                case 4:
                    repeat = false;
                    break;
                default:
                    Printer.printMessage( "Opção Incorreta");
                    Printer.printLine();
            }
        } while( repeat );
        Printer.exitMessage();
        Reader.input.close();
    }
}