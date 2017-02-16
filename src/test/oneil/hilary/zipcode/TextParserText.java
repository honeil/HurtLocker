package oneil.hilary.zipcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hilaryoneil on 2/15/17.
 */
public class TextParserText {

    @Test
    public void splitIntoObjects_TestingForAStringAtIndexZero_ShouldReturnStringWithoutRegex(){
        //Arrange
        TextParser textParser = new TextParser();
        String output = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
        //Act
        String[] expected = {"naMe:Milk;price:3.23;type:Food;expiration:1/25/2016", "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016", "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016"};
        String[] actual = textParser.splitIntoObjects(output);
        //Assert
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void splitIntoObjects_TestingThatMultipleStringsWereAddedToArray_ShouldReturnIntOfArrayIndex(){
        //Arrange
        TextParser textParser = new TextParser();
        String output = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
        //Act
        int expectedArraySize = 3;
        int actualArraySize = textParser.splitIntoObjects(output).length;
        //Assert
        Assert.assertEquals(expectedArraySize, actualArraySize);
    }

    @Test
    public void splitIntoKeyValuePairs_TestingForAStringAtIndexZero_ShouldReturnKeyValuePairWithoutRegex(){
        //Arrange
        TextParser textParser = new TextParser();
        String object = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        //Act
        String[] expected = {"naMe:Milk", "price:3.23", "type:Food", "expiration:1/25/2016"};
        String[] actual = textParser.splitIntoKeyValuePairs(object);
        //Assert
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void parsePriceFromFoodObjectTest_ShouldReturnPriceFromFoodObjectString(){
        //Arrange
        TextParser textParser = new TextParser();
        String foodObject = "2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:";
        //Act
        String expected = "3.23";
        String actual = textParser.parsePriceFromFoodObject(foodObject);
        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isMilkTest_TestIfNameValueWithoutRegexIsEqualToMilk_ShouldReturnTrue(){
        //Arrange
        TextParser textParser = new TextParser();
        String name = "naMe:Milk;price:3.23;";
        //Act
        boolean actual = textParser.isMilk(name);
        //Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void isMilkTest_TestIfNameValueWithoutRegexIsEqualToMilk_ShouldReturnFalse(){
        //Arrange
        TextParser textParser = new TextParser();
        String name = "BrEAD";
        //Act
        boolean actual = textParser.isMilk(name);
        //Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void isBreadTest_TestIfNameValueWithoutRegexIsEqualToBread_ShouldReturnTrue(){
        //Arrange
        TextParser textParser = new TextParser();
        String name = "aME:BreaD;price:1.23;type:Food;expiration:";
        //Act
        boolean actual = textParser.isBread(name);
        //Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void isBreadTest_TestIfNameValueWithoutRegexIsEqualToBread_ShouldReturnFalse(){
        //Arrange
        TextParser textParser = new TextParser();
        String name = "MIlK";
        //Act
        boolean actual = textParser.isBread(name);
        //Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void isApplesTest_TestIfNameValueWithoutRegexIsEqualToApples_ShouldReturnTrue(){
        //Arrange
        TextParser textParser = new TextParser();
        String name = "apPles";
        //Act
        boolean actual = textParser.isApple(name);
        //Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void isAppleTest_TestIfNameValueWithoutRegexIsEqualToApple_ShouldReturnFalse(){
        //Arrange
        TextParser textParser = new TextParser();
        String name = "MIlK";
        //Act
        boolean actual = textParser.isApple(name);
        //Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void isCookiesTest_TestIfNameValueWithoutRegexIsEqualToCookies_ShouldReturnTrue(){
        //Arrange
        TextParser textParser = new TextParser();
        String name = "CookieS";
        //Act
        boolean actual = textParser.isCookie(name);
        //Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void isCookiesTest_TestIfNameValueWithoutRegexIsEqualToCookies_ShouldReturnFalse(){
        //Arrange
        TextParser textParser = new TextParser();
        String name = "MIlK";
        //Act
        boolean actual = textParser.isCookie(name);
        //Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void correctNameSpellingTest_TestThatCapitalizationIsCorrectedAfterRegex_ShouldReturnMilk() {
        //Arrange
        TextParser textParser = new TextParser();
        String name = "MIlk";
        //Act
        String expected = "Milk";
        String actual = textParser.parseAndReturnCorrectCapitalization(name);
        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void correctNameSpellingTest_TestThatCapitalizationIsCorrectedAfterRegex_ShouldReturnBread() {
        //Arrange
        TextParser textParser = new TextParser();
        String name = "BrEAD";
        //Act
        String expected = "Bread";
        String actual = textParser.parseAndReturnCorrectCapitalization(name);
        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void correctNameSpellingTest_TestThatCapitalizationIsCorrectedAfterRegex_ShouldReturnApples() {
        //Arrange
        TextParser textParser = new TextParser();
        String name = "apPles";
        //Act
        String expected = "Apple";
        String actual = textParser.parseAndReturnCorrectCapitalization(name);
        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void correctNameSpellingTest_TestThatCapitalizationIsCorrectedAfterRegex_ShouldReturnCookies() {
        //Arrange
        TextParser textParser = new TextParser();
        String name = "Co0kieS";
        //Act
        String expected = "Cookies";
        String actual = textParser.parseAndReturnCorrectCapitalization(name);
        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void createArrayOfPairs_TestSizeOfArray_ShouldReturnNumOfObjects(){
        //Arrange
        TextParser textParser = new TextParser();
        String output = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
        //Act
        int expected = 3;
        int actual = textParser.createArrayOfPairs(output).size();
        //Arrange
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void createArrayOfPairs_TestSizeOfArray_ShouldReturnNumOfKeyValuePairsInAnObject(){
        //Arrange
        TextParser textParser = new TextParser();
        String output = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
        //Act
        int expected = 4;
        int actual = textParser.createArrayOfPairs(output).get(2).length;
        //Arrange
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void buildFoodObjectList_addFoodObjectsToAnArrayList_shouldReturnNumOfObjectsAdded() {
        //Arrange
        TextParser textParser = new TextParser();
        List<String[]> test = new ArrayList<String[]>();
        String[] object1 = {"naMe:Milk", "price:3.23", "type:Food", "expiration:1/25/2016"};
        String[] object2 = {"naME:BreaD", "price:1.23", "type:Food", "expiration:1/02/2016"};
        test.add(object1);
        test.add(object2);
        //Act
        int expected = 2;
        int actual = textParser.buildFoodObjectList(test).size();
        //Arrange
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void buildFoodObjectList_addFoodObjectsToAnArrayList_shouldReturnNameOfObjectAtIndexOne() {
        //Arrange
        TextParser textParser = new TextParser();
        List<String[]> test = new ArrayList<String[]>();
        String[] object1 = {"naMe:Milk", "price:3.23", "type:Food", "expiration:1/25/2016"};
        String[] object2 = {"naME:BreaD", "price:1.23", "type:Food", "expiration:1/02/2016"};
        test.add(object1);
        test.add(object2);
        //Act
        String expected = "Bread";
        String actual = textParser.buildFoodObjectList(test).get(1).getName();
        //Arrange
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void buildFoodObjectList_addFoodObjectsToAnArrayList_shouldReturnPriceOfObjectAtIndexZero() {
        //Arrange
        TextParser textParser = new TextParser();
        List<String[]> test = new ArrayList<String[]>();
        String[] object1 = {"naMe:Milk", "price:3.23", "type:Food", "expiration:1/25/2016"};
        String[] object2 = {"naME:BreaD", "price:1.23", "type:Food", "expiration:1/02/2016"};
        test.add(object1);
        test.add(object2);
        //Act
        String expected = "3.23";
        String actual = textParser.buildFoodObjectList(test).get(0).getPrice();
        //Arrange
        Assert.assertEquals(expected,actual);
    }

}


