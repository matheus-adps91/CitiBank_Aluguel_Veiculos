package aula13.exercicio1.model.enums;

public enum Vehicle
{
    GOL("123","Volkswagen", "Gol", "G3", "Preto", "1.0", 130.00f ),
    UNO("456","Fiat", "Uno", "Way", "Branco", "1.0", 150.00f ),
    RENEGADE("789","Jeep", "Renegade", "Standard", "Azul", "1.8", 350.00f),
    DUSTER("321","Renault", "Duster", "Dynamique", "Vermelho", "1.6", 350.00f),
    HILUX("654","Toyota", "Hilux", "SW4", "Verde", "3.0", 1_500.00f),
    TRAILBLAZER("987","Chevrolet", "TrailBlazer","LTZ", "Laranja", "3.0", 1_800.00f),
    CAYENNE("998","Porsche", "Cayenne", "Turbo GT", "Preto", "4.0", 3_500.00f),
    MUSTANG("999","Ford", "Mustang", "Mach 1", "Amarelo", "5.0", 4_000.00f);

    private String sourceId;
    private String brand;
    private String name;
    private String model;
    private String color;
    private String engine;
    private float dairy;
    
    Vehicle(
        final String sourceId,
        final String brand,
        final String name,
        final String model,
        final String color,
        final String engine,
        final float dairy )
    {
        this.sourceId = sourceId;
        this.brand = brand;
        this.name = name;
        this.model = model;
        this.color = color;
        this.engine = engine;
        this.dairy = dairy;
    }
    
    public String getSourceId()
    {
        return sourceId;
    }

    public String print() {
        return "Car name:"+getName()+" model: "+getModel();
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
    
}