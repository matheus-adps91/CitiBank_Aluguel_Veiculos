package aula13.exercicio1.model;

import aula13.exercicio1.model.enums.Vehicle;

public class Car
{
    private String sourceId;
    private String brand;
    private String name;
    private String model;
    private String color;
    private String engine;
    private float dairy;

    public Car(
        final Vehicle especification )
    {
        this.sourceId = especification.getSourceId();
        this.brand = especification.getBrand();
        this.name = especification.getName();
        this.model = especification.getModel();
        this.color = especification.getColor();
        this.engine = especification.getEngine();
        this.dairy = especification.getDairy();
    }

    public String getSourceId()
    {
        return sourceId;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getName()
    {
        return name;
    }

    public String getModel()
    {
        return model;
    }

    public String getColor()
    {
        return color;
    }

    public String getEngine()
    {
        return engine;
    }

    public float getDairy()
    {
        return dairy;
    }
    
    @Override
    public String toString()
    {
        return "Código [" +sourceId+ "] Carro ["+ brand +" "+ name +" "+ model +" "+ color +" "+ engine + "] Diária= ["+ dairy + "]";
    }
}