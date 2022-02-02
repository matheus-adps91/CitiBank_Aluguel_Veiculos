package aula13.exercicio1.exception;

public class CarNotFoundException
    extends
        Exception
{
    private static final long serialVersionUID = - 5769760187130423660L;
    
    public CarNotFoundException(
        final String id )
    {
        super("O carro com o ID " +id+" não foi encontrado");
    }
}