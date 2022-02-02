package aula13.exercicio1.model.enums;

public enum Category
{
    BASIC("Básico", 1),
    INTERMEDIUM("Intermediário", 2),
    EXECUTIVE("Executivo", 3),
    PREMIUM("Premium", 4);
    
    private String vehicleCategory;
    private int index;

    private Category(
        final String vehicleCategory,
        final int index)
    {
        this.vehicleCategory = vehicleCategory;
        this.index = index;
    }

    public int getIndex()
    {
        return index;
    }

    public String getVehicleCategory()
    {
        return vehicleCategory;
    }
}