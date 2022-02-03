package aula13.exercicio1.service;

import java.util.Map;

import aula13.exercicio1.exception.ClientNotFoundException;
import aula13.exercicio1.model.Client;
import aula13.exercicio1.printer.Printer;
import aula13.exercicio1.reader.Reader;

public class ClientService
{
    public static void createClient(
        final Map<String, Client> clients )
    {
        Printer.printWelcomeMessage();
        boolean repeat = false;
        do {
            Printer.printIdCodeMessage();
            String code = Reader.input.next();
            Printer.printMessage( "Digite o seu nome" );
            String name = Reader.input.next();
            Printer.printMessage( "Digite a sua idade" );
            String age = Reader.input.next();
            
            if ( isClientSaved(clients, code) ) {
                Printer.printMessage( "Código inválido" );
                Printer.printLine();
                repeat = true;
            } else {
                Client client = new Client( code, name, age );
                clients.put( code, client );
                repeat = false;
                Printer.printMessage( "Cliente cadastrado com sucesso" );
                Printer.printLine();
            }
        } while ( repeat );
    }

    public static void getClient(
        final Map<String,Client> clients ) 
    {
        Printer.printWelcomeMessage();
       do {
           Printer.printIdCodeMessage();
           String id = Reader.input.next();
            try {
                Client client = findClientById( clients, id );
                Printer.clientMessage( client );
                Printer.printLine();
            } catch( ClientNotFoundException e ) {
                Printer.printMessage( e.getMessage() );
            }
            Printer.printMessage( "Deseja fazer uma nova busca [ 0 - Não / 1 - Sim ]" );
            int option = Reader.input.nextInt();
            if ( option == 0 )
                break;
       } while ( true );
    }
    
    private static boolean isClientSaved(
        final Map<String,Client> clients,
        final String code)
    {
        return clients.containsKey( code );
    }
    
    public static Client findClientById(
        final Map<String, Client> clients,
        final String id ) 
            throws ClientNotFoundException
    {
        if ( clients.containsKey( id ) ) {
            return clients.get( id );
        }
        throw new ClientNotFoundException( id );
    }
    
}