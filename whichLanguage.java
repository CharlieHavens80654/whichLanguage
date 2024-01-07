import java.io.File;
import java.util.ArrayList;
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
        //lines 27-34 creates a string map of all the characters in the input
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

        //lines 37-49 is just putting the letter frequency percents into a 2D array
        double[][] array = new double[16][87];
        File perc = new File("percents.txt");
        Scanner per = new Scanner(perc).useDelimiter(",|\\n");;
        int i = 0;
        int j = 0;
        while(per.hasNext()){
            array[i][j] = per.nextDouble();
            i++;
            if(i > 15){
                i = 0;
                j++;
            }
        }

        //lines 52-56 create a list of all the different letters we have the frequencies for
        ArrayList<String> letters = new ArrayList<String>();
        File let = new File("letters.txt");
        Scanner lett = new Scanner(let);
        while(lett.hasNext()){
            String temp2 = lett.next().toLowerCase();
            temp.substring(0,1);
            letters.add(temp2);
        }
        //lines 63-69 creates a list of all the languages this works with
        ArrayList<String> languages = new ArrayList<String>();
        File lang = new File("languages.txt");
        Scanner lan = new Scanner(lang);
        while(lan.hasNext()){
            String temp2 = lan.next().toLowerCase();
            temp.substring(0,1);
            languages.add(temp2);
        }
        
        double observed;
        double output = 0;
        double expected;
        double min = 1000000000000000.0;
        String language = "";
        for(int k = 0; k < 16; k++){
            double count = 0;
            for(int index = 0; index < 87; index ++){
                String temp1 = letters.get(index);
                if(map.get(temp1)!= null){
                    observed = map.get(temp1);
                }else{
                    observed = 0;
                }
    
                //creates the expected ammount
                double percent = array[k][index];
                expected = percent*temp.length();
                //calcuates chi square thing
                output = Math.pow((observed-expected), 2);
                if(expected != 0){
                    output = output/expected;
                }
                count = count + output;
            }
            Math.pow(count, 0.5);
            if(count < min){
                    min = count;
                    language = languages.get(k);
            }
        }
        System.out.println(language);
    }
}
