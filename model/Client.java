package aula13.exercicio1.model;

import java.util.ArrayList;
import java.util.List;

public class Client
{
    private int id;
    private String name;
    private String age;
    private List<Rent> rents;
    private float rentSum;
    
    public Client(
        final String id,
        final String name,
        final String age )
    {
        this.id = id.hashCode();
        this.name = name;
        this.age = age;
        this.rents = new ArrayList<>();
        this.rentSum = 0.0f;
    }
    
    public List<Rent> getRents()
    {
        return rents;
    }

    public String getName()
    {
        return name;
    }
    
    public String getAge()
    {
        return age;
    }
    
    public void addRent(
        final Rent rent )
    {
        rents.add( rent );
    }
    
    public void increaseSumRent(
        final float rentCost )
    {
        rentSum += rentCost;
    }

    @Override
    public String toString()
    {
        return "Client [id=" + id + ", name=" + name + ", age=" + age + ", Total= " + rentSum + "]\n"+
            "Rents "+rents ;
    }
    
}