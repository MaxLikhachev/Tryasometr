package su.vistar.model.dto;

public class CarDTO {
    private String brand;
    private String model;
    private int year;

    private float min=0;
    private float max=0;

    public CarDTO(){}
    public CarDTO(String brand, String model, int year){
        setModel(model);
        setBrand(brand);
        setYear(year);
    }

    public float getMin(){return this.min;}
    public void setMin(float min){this.min = min;}

    public float getMax(){return this.min;}
    public void setMax(float max){this.max = max;}

    public String getBrand(){return this.brand;}
    public void setBrand(String brand){this.brand=brand;}

    public String getModel(){return this.model;}
    public void setModel(String model){this.model=model;}

    public int getYear(){return this.year;}
    public void setYear(int year){this.year = year;}
}
