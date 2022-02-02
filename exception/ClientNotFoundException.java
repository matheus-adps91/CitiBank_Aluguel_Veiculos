package aula13.exercicio1.exception;

public class ClientNotFoundException
    extends
        Exception
{
    private static final long serialVersionUID = - 5291411369942027578L;
    
    public ClientNotFoundException(
        final String id )
    {
        super("Cliente com o ID " +id+" não foi encontrado");
    }
}