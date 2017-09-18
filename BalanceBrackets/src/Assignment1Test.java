
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package edu.neu.info6205.test;

//import edu.neu.info6205.src.Assignment1Solution;
import java.io.*;
import java.util.HashMap;
/**
 *
 * @author Rachan Hegde
 */
public class Assignment1Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
      Assignment1Solution soln = new Assignment1Solution();
         
      /**
       * LOAD INPUT FILE HERE
       */
      String path = "PositiveScenarioInput.java";
      String base = "C:/Users/Mayur/Documents/Algorithm's/Assignmet1/";
      String relative = new File(base).toURI().relativize(new File(path).toURI()).getPath();
      
      String inputFile = readFile("PositiveScenarioInput.java"); //C:\\Users\\Mayur\\Documents\\Algorithm's\\Assignmet1\\PositiveScenarioInput.java
      inputFile = inputFile.replaceAll("//.*|/\\*((.|\\n)(?!=*/))+\\*/", "");
      if (soln.validateClass(inputFile)) {
            System.out.println("Its a valid Java Class File"); 
            printFileStats(inputFile);
        } else {
            System.out.println("Its not a valid Java Class File"); 
        }
      
      
    }
 

    private static void printFileStats(String inputFile) {
        /**
         * TODO -- implement this
         */
    	String delimiters = "[\\p{Punct}\\s]+";//"\\s+|,\\s*|\\.\\s*";

    	   // analyzing the string 
    	   String[] s = inputFile.split(delimiters);
    	   
    	   HashMap<String,Integer> map = new HashMap<String,Integer>();          
    	   //String s = "aasjjikkk";
    	   for(int i = 0; i < s.length; i++){
    	      //char c = s.charAt(i);
    	      Integer val = map.get(new String(s[i]));
    	      if(val != null){
    	        map.put(s[i], new Integer(val + 1));
    	      }else{
    	        map.put(s[i],1);
    	      }
    	   }
    	   
    	   for (String key : map.keySet()) {
    		    System.out.println(key + " " + map.get(key));
    		}
     	
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * DO NOT CHANGE THIS
     * @param fileName
     * @return
     * @throws IOException 
     */
    
    public static String readFile(String fileName) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        return sb.toString();
    } finally {
        br.close();
    }
}
}
