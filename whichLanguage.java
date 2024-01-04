import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Write a description of class AOC1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class whichLanguage
{
    
    public static void main(String[] args) throws Exception {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        String temp = "";
        Map<String, Integer> map = new HashMap<String, Integer>();
        while(sc.hasNext()){
            temp = temp + sc.next();
        }
        temp.toLowerCase();
        //creates a character map of all the characters in the input
        for (int i = temp.length(); i > 0; i--) {
            String c = temp.substring(i-1, i);
            Integer val = map.get(c);
            if (val != null) {
                map.put(c, val + 1);
            }
            else {
               map.put(c, 1);
           }
        }
        int size = (int)map.values().stream().distinct().count();
        double observed;
        double output = 0;
        double expected;
        for(int i = 0; i < size; i++){
            //creates the observed percentage of a
            observed = map.get("a");
            //creates the expected ammount
            expected = 0.084966*temp.length();
            //calcuates chi square thing
            output = Math.pow((observed-expected), 2);
            output = output/expected;    
        }
        System.out.println(map);
        System.out.println(output);

    }
     
    


}
