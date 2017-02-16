package oneil.hilary.zipcode;

/**
 * Created by hilaryoneil on 2/15/17.
 */
public class Food {

    private String name;
    private String price;

    Food(String name, String price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

}
