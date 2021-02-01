package edu.escuelaing.arep.calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import edu.escuelaing.arep.utilities.LinkedList;


/**
 * App Class
 * @author Angie Daniela Ruiz Alfonso
 */
public class App
{
    public static void main(String[] args)
    {
        LinkedList<Double> myLinkedList = null;
        LinkedList<Double> myLinkedList2 = null;
        try {
        	//test data
            myLinkedList = makeLinkedList("resources\\data1.txt");
           //test data
            myLinkedList2 = makeLinkedList("resources\\data2.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //test 1
        double mean = mean(myLinkedList);
        double standar_deviation = standardDeviation(myLinkedList);
        System.out.println(String.format("The Mean is %s and the Standard Deviation is %s",mean,standar_deviation));
       //test 2
        double mean2 = mean(myLinkedList2);
        double standar_deviation2 = standardDeviation(myLinkedList2);
        System.out.println(String.format("The Mean is %s and the Standard Deviation is %s",mean2,standar_deviation2));
    }

    /**
     * Creates a linkedlist given its values in an text file
     * @param testCasePath The path of the file that contain the example values
     * @return  A LinkedList with the values provided in the laboratory
     * @throws Exception
     */
    public static LinkedList<Double> makeLinkedList(String testCasePath) throws Exception {
        LinkedList<Double> myLinkedList = new LinkedList<Double>();
        File file = new File(testCasePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        double value;
        String string;
        string = bufferedReader.readLine();
        //while the test path have examples
        while( string != null){
            value = Double.parseDouble(string);
            myLinkedList.add(value);
            string = bufferedReader.readLine();
        }
        return myLinkedList;
    }

    /**
     * Calculates the mean of the values stored in an LinkedList
     * @param linkedList The linkedlist with the values
     * @return The mean of the values stored in an LinkedList
     */
    public static Double mean(LinkedList<Double> linkedList) {
    	//taken: https://www.programiz.com/java-programming/examples/standard-deviation
    	
        double sum = 0.0;
        for(double value:linkedList){
            sum = sum+value;
        }
        double ans = (sum / linkedList.getSize());
        
        //we aproximate to match with the example path values
        return (double)Math.round(ans * 100d) / 100d;
    }

    /**
     * Calculates the standard deviation of the values stored in an LinkedList
     * @param linkedList The linkedlist with the values
     * @return The standard deviation of the values stored in an LinkedList
     */
    public static double standardDeviation(LinkedList<Double> linkedList){
        double mean = mean(linkedList);
        double sum = 0.0;
        double x;
        for (double value:linkedList){
            x=value-mean;
            sum = sum+x*x;
        }
        double ans = Math.sqrt(sum/(linkedList.getSize()-1));

        //we aproximate to match with the example path values
        return (double)Math.round(ans * 100d) / 100d;
    }
    
    /**
     * Generate the json format of the mean and standard deviation
     * @param numbers The values of the numbers that the user entry
     * @return The json format of the mean and standard deviation
     */
    public static String calculate(String numbers){
        LinkedList<Double> myLinkedList = new LinkedList<Double>();
        List<String> stringList = Arrays.asList(numbers.split(","));
        for (String string : stringList) {
            double value = Double.parseDouble(string);
            myLinkedList.add(value);
        }

        double mean = (double)Math.round(mean(myLinkedList)*100d)/100d;
        double std = (double)Math.round(standardDeviation(myLinkedList)*100d)/100d;
        String json = "{\"mean\":"+mean+",\"std\":"+std+"}";
        return json;
    }
}
