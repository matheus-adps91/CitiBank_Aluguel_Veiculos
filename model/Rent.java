package aula13.exercicio1.model;

public class Rent
{
    private int quantity;
    private int days;
    private Car car;
    private CarCategory carCategory;
    
    public Rent(
        final int quantity,
        final int days,
        final Car car,
        final CarCategory carCategory )
    {
        this.quantity = quantity;
        this.days = days;
        this.car = car;
        this.carCategory = carCategory;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getDays()
    {
        return days;
    }

    public Car getCar()
    {
        return car;
    }

    public CarCategory getCarCategory()
    {
        return carCategory;
    }
    
    @Override
    public String toString()
    {
        return "Rent [quantity=" + quantity + ", days=" + days + ", car=" + car + ", carCategory=" + carCategory + "]";
    }
    
}