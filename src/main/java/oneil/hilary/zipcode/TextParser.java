package oneil.hilary.zipcode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hilaryoneil on 2/15/17.
 */
public class TextParser {

    public List<String[]> foodPairs = new ArrayList<String[]>();
    public static List<Food> foodObjectList= new ArrayList<Food>();

    String[] splitIntoObjects (String text){
        return text.split("##");
    }

    String[] splitIntoKeyValuePairs(String text){
       return text.split("[^\\w:./]");
    }

    String parsePriceFromFoodObject(String foodObject) {
        String price ="";
        Pattern p = Pattern.compile("\\d{1,2}[.]\\d{1,2}"); /* Kirbs showed me this one*/
        Matcher m = p.matcher(foodObject);
        while (m.find()) {
            price = m.group();
        }
        return price;
    }

     List<String[]> createArrayOfPairs(String text){
        String[] foodObjects = splitIntoObjects(text);
        for (int i = 0; i < foodObjects.length; i++) {
            String[] foodObject = splitIntoKeyValuePairs(foodObjects[i]);
            foodPairs.add(foodObject);
        }
        return foodPairs;
    }

    boolean isMilk (String name){
        Pattern p = Pattern.compile("(?i)milk");
        Matcher m = p.matcher(name);
        return m.find();

    }

    boolean isBread (String name){
        Pattern p = Pattern.compile("(?i)bread");
        Matcher m = p.matcher(name);
        return m.find();
    }

    boolean isCookie (String name){
        Pattern p = Pattern.compile("[Cc][O0o][O0o][Kk][Ii][Ee][Ss]");
        Matcher m = p.matcher(name);
        return m.find();
    }

    boolean isApple (String name){
        Pattern p = Pattern.compile("[Aa][Pp]{2}[Ll][Ee][Ss]");
        Matcher m = p.matcher(name);
        return m.find();
    }

    String parseAndReturnCorrectCapitalization (String name) {
        String correctSpelling ="";
        if(isMilk(name)) correctSpelling = "Milk";
        if(isBread(name))correctSpelling = "Bread";
        if(isApple(name))correctSpelling = "Apple";
        if(isCookie(name)) correctSpelling = "Cookies";
        return correctSpelling;
    }

    List<Food> buildFoodObjectList(List<String[]> foodPairs){
        for (String[] foodObject : foodPairs) {
            String name = parseAndReturnCorrectCapitalization(foodObject[0]);
            String price = parsePriceFromFoodObject(foodObject[1]);
            Food food = new Food(name, price);
            foodObjectList.add(food);
        }
        return foodObjectList;
    }


}
