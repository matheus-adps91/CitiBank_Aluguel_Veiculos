package aula13.exercicio1.exception;

public class CarCategoryNotFoundException
    extends
        Exception
{
    private static final long serialVersionUID = - 8969913623648438993L;
    
    public CarCategoryNotFoundException(
        final String category )
    {
        super("A categoria "+ category +" não foi encontrada");
    }
}