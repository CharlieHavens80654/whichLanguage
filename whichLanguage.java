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
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while(sc.hasNext()){
            temp = temp + sc.next();
        }
        temp.toLowerCase();
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            Integer val = map.get(c);
            if (val != null) {
                map.put(c, val + 1);
            }
            else {
               map.put(c, 1);
           }
        }
        System.out.println(map);

    }
     
    


}
