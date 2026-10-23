package uk.ac.westminster.products_api;

// A PhysicalProduct IS-A Product because it inherits from Product class
//
public class PhysicalProduct extends Product{
    private double weighKg;
    private String dimensions;

    public PhysicalProduct(Long id, String name, double price, double weighKg, String dimensions) {
        super(id, name, price);
        this.weighKg = weighKg;
        this.dimensions = dimensions;
    }

    public PhysicalProduct(){}

    public double getWeighKg() {
        return weighKg;
    }

    public void setWeighKg(double weighKg) {
        this.weighKg = weighKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}
