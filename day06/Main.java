package day06;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    
    public static void main(String[] args){
        System.out.println("first result: " + firstTaskHomework("day06/input.txt"));
        System.out.println("second result: " + secondTaskHomework("day06/input.txt"));
    }

    public static String[] getOperationsFromInput(String file){
        List<String> input = new ArrayList<>();
        try{
            input = Files.readAllLines(Path.of(file));
        }catch(Exception e){
            e.printStackTrace();
        }

        return input.get(input.size()-1).split("\\s+");
    }

    public static List<String[]> getNumbersFromInput(String file){

        List<String> input = new ArrayList<>();
        try{
            input = Files.readAllLines(Path.of(file));
        }catch(Exception e){
            e.printStackTrace();
        }

        input.remove(input.size()-1);

        List<String[]> numbers = new ArrayList<>();

        String [] l=input.get(input.size()-1).split("\\s+");

        for(int i = 0; i<l.length; i++){
            numbers.add(new String[input.size()]);
        }

        for(int i =0; i<input.size();i++){
            String[] n = input.get(i).split("\\s+"); 
            for(int j=0; j<n.length;j++){                  
                numbers.get(j)[i]=n[j];
            }
        }

        return numbers;

    }

    public static long firstTaskHomework(String file){
        var numbers = getNumbersFromInput(file);
        var ops = getOperationsFromInput(file);

        long res = 0;

        for(int i =0; i<numbers.size();i++){
            String o = ops[i];
            if(o.equals("+")){
                long temp = 0;
                for(int j=0;j<numbers.get(0).length;j++){
                    temp+=Long.parseLong(numbers.get(i)[j]);
                }
                res+=temp;
            }else{
                long temp = 1;
                for(int j=0;j<numbers.get(0).length;j++){
                    temp*=Long.parseLong(numbers.get(i)[j]);
                }
                res+=temp;
            }
            
        }
        return res;
    }

    public static List<String> getOperationsFromInput2(String file){

        List<String> input = new ArrayList<>();
        try{
            input = Files.readAllLines(Path.of(file));
        }catch(Exception e){
            e.printStackTrace();
        }

        List<String> operations = new ArrayList<>();

        String[] ops = input.get(input.size()-1).split("\\s+");

        for(String s: ops){
            operations.add(s);
        }

        Collections.reverse(operations);
        return operations;
    }

    public static List<List<String>> getNumbersFromInput2(String file){

        List<String> input = new ArrayList<>();
        try{
            input = Files.readAllLines(Path.of(file));
        }catch(Exception e){
            e.printStackTrace();
        }

        //Removes the lines containing the arithmetic operations
        input.remove(input.size()-1);

        // Initializes a list of lists, one list collects all numbers related to one problem
        List<List<String>> numbers = new ArrayList<>();

        //Number of arithmetic operataions
        int opsCount = getOperationsFromInput2(file).size();

        //Fills numbers with as many empty lists as needed
        for(int i=0;i<opsCount;i++){
            numbers.add(new ArrayList<>());
        }

        //max digits of one number
        int linesCount = input.size();

        //Length of one line
        int lineLength = input.get(0).length();

        // Points to the list representing the current problem
        int currentOps = 0;

        for(int j=lineLength-1;j>=0;j--){

            StringBuilder sb = new StringBuilder();

            for(int k=0; k<linesCount; k++){
                if(input.get(k).charAt(j)==' '){
                    sb.append("");
                }else{
                    sb.append(input.get(k).charAt(j));
                }
            }

            if(!(String.valueOf(sb).isEmpty())){
                List<String> temp = numbers.get(currentOps);
                temp.add(String.valueOf(sb));
                numbers.set(currentOps,temp);
            }else{
                currentOps++;
            }

        }


        return numbers;

    }

    public static long secondTaskHomework(String file){

        var numbers = getNumbersFromInput2(file);
        var ops = getOperationsFromInput2(file);

        long res = 0;

        for(int i = 0; i<numbers.size();i++){   
            String o = ops.get(i);             
            if(o.equals("+")){
                long temp = 0;
                for(int j=0;j<numbers.get(i).size();j++){
                    temp+=Long.parseLong(numbers.get(i).get(j));
                }
                res+=temp;
            }else{
                long temp = 1;
                for(int j=0;j<numbers.get(i).size();j++){
                    temp*=Long.parseLong(numbers.get(i).get(j));
                }
                res+=temp;
            }
            
        }
        return res;
    }

}
