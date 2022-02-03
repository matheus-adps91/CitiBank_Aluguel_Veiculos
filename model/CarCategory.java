package aula13.exercicio1.model;

import aula13.exercicio1.model.enums.Category;

public class CarCategory
{
    private String category;
    private int index;
    
    public CarCategory(
        final Category category )
    {
        this.category = category.getVehicleCategory();
        this.index = category.getIndex();
    }

    public String getCategory()
    {
        return category;
    }


    public int getIndex()
    {
        return index;
    }
    
    @Override
    public String toString()
    {
        return "Categoria: "+category;
    }
    
}