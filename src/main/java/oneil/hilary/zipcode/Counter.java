package oneil.hilary.zipcode;

import java.util.List;

/**
 * Created by hilaryoneil on 2/16/17.
 */
public class Counter {

    static int numOfExceptions =0;
    static int numofMilkAt323 = 0;
    static int numOfMilkAt123 = 0;
    private int totalNumOfMilk = numofMilkAt323 + numOfMilkAt123;
    static int numOfBread = 0;
    static int numOfCookies = 0;
    static int numOfApplesAt23 =0;
    static int numOfApplesAt25 = 0;
    private int totalNumOfApples = numOfApplesAt23 +numOfApplesAt25;

    void countNumOfFoodObject(List<Food> listOfFoodObjects){
        for(int i =0; i <listOfFoodObjects.size(); i++){
            if(listOfFoodObjects.get(i).getName().equals("Milk")){
                if(listOfFoodObjects.get(i).getPrice().equals("3.23"))
                    numofMilkAt323++;
                if(listOfFoodObjects.get(i).getPrice().equals("1.23"))
                    numofMilkAt323++;
            }
            if(listOfFoodObjects.get(i).equals("Bread"))
                numOfBread++;
            if(listOfFoodObjects.get(i).getName().equals("Cookies"))
                numOfCookies++;
            if(listOfFoodObjects.get(i).getName().equals("Apples")){
                if(listOfFoodObjects.get(i).getPrice().equals("0.23"))
                    numOfApplesAt23++;
                if(listOfFoodObjects.get(i).getPrice().equals("0.25"))
                    numOfApplesAt25++;
            }
        }
    }

}
