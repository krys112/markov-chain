/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package markovChain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 *
 * @author Krys
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        //String txt = "the theremin is theirs, ok? yes, it is. this is a theremin.";
        String contents = "REPLACE THIS WITH DESIRABLE TEXT";      
        HashMap<String, List<String>> map = new HashMap<>();
        String result = " ";
        
        String[] words = contents.split("\\s+");
        //for (int i = 0; i < words.length; i++) {
          //  words[i] = words[i].replaceAll("[^\\w]", "");
        //}
        
        //try {
           // List<String> contents = new <String>(Files.readAllBytes(Paths.get("textfile.txt")));
           // System.out.println(contents);
        try {
            for (int j = 0; j < words.length; j++) {
                String txt = words[j];
            
                String gram = txt;
                
                if (map.containsKey(gram) == false) {
                    map.put(gram, new ArrayList<String>());
                    //map.put(gram, map.get(gram) + 1);
                }

           //if (txt.charAt(i + 3) == null) {
                if (j+1 >= words.length) {
                    String input = " ";
                    map.get(gram).add(input);
                } else {
                    map.get(gram).add(words[j + 1]);
                }
            
            }

            Map<String, List<String>> reversedMap = new TreeMap<String, List<String>>(map);

            for (Map.Entry entry : reversedMap.entrySet()) {
                //System.out.println(entry.getKey() + ", " + entry.getValue());
            }
            
            int rand = new Random().nextInt(words.length);
            String currentGram = words[rand]; //beginning.get(rand);
            result = currentGram;

            for (int i = 0; i < 50; i++) {
                ArrayList<String> poss = new ArrayList<String>(map.get(currentGram));
                //System.out.println("possibiltiies " +poss);
                int rng = new Random().nextInt(poss.size());
                String next = poss.get(rng);
                result += " " +next;
                currentGram = next;
                //System.out.println("next gram is "+currentGram+".");
                //System.out.println(result);

            }

            System.out.println(result);
        }
         catch (Exception e) {
           System.out.println(result);
        }

    }
}
