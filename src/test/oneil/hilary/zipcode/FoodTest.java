package oneil.hilary.zipcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hilaryoneil on 2/15/17.
 */
public class FoodTest {

    @Test
    public void getNameTest_ShouldReturnName(){
        //Arrange
        Food food = new Food("cookies", "2.25");
        //Act
        String expected = "cookies";
        String actual = food.getName();
        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPriceTest_ShouldReturnName(){
        //Arrange
        Food food = new Food("cookies", "2.25");
        //Act
        String expected = "2.25";
        String actual = food.getPrice();
        //Assert
        Assert.assertEquals(expected,actual);
    }

}


