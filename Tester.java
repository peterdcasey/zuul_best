
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
import java.util.stream.*;

public class Tester
{
    public static void main(String[] args) {
        var list = new ArrayList<Integer>();
        list.add(23); list.add(73); list.add(3);
        List<Integer> x = List.of(1,2,3,4,5);
        List<String> s = List.of("yes", "no", "maybe");
        
        List<Integer> t = x.stream()
                            .filter(num -> num >= 2 && num <= 4)
                            .collect(Collectors.toList());
                            
        List<Integer> w = new ArrayList<>();
        
        for (int num : x) {
            if (num >= 2 && num <= 4) {
                w.add(num);   
            }
        }
        
        for (int index = 0; index < x.size(); index++) {
            int num = x.get(index);
            
            if (num >= 2 && num <= 4) {
                w.add(num);   
            }
        }
        
        System.out.println(w);
    }
}
