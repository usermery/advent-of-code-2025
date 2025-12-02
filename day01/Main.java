package day01;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main{
    
    public static void main(String[] args){
        System.out.println("first result: " + firstTaskDial());
        System.out.println("second result: " + secondTaskDial());
    }

    private static List<String> getInput(String file){
        List<String> input = new ArrayList<>();
        try{
            input = Files.readAllLines(Path.of(file));
        }catch(Exception e){
            e.printStackTrace();
        }
        return input;
    }

    public static int firstTaskDial(){

        int res = 0;
        int dial = 50;

        for(String s: getInput("day01/input.txt")){
            char dir = s.charAt(0);
            int count = Integer.parseInt(s.substring(1, s.length()));
            if(dir=='R'){
                dial = (dial + count) % 100;
            }else{
                dial = (dial - count + 100) % 100;
            }
            if(dial==0){
                res++;
            }
        }

        return res;

    }

    public static int secondTaskDial(){

        int res = 0;
        int dial = 50;

        for(String s: getInput("day01/input.txt")){

            char dir = s.charAt(0);
            int count = Integer.parseInt(s.substring(1, s.length()));

            int oldDial = dial;
            int newDial;

            if(dir=='R'){
                newDial = dial + count;
                int oldBlock = Math.floorDiv(oldDial, 100);
                int newBlock = Math.floorDiv(newDial, 100);
                res += (newBlock - oldBlock);
            }else{
                newDial = dial - count;
                int oldBlock = Math.floorDiv(oldDial - 1, 100);
                int newBlock = Math.floorDiv(newDial - 1, 100);
                res += (oldBlock - newBlock);
            }

            dial = newDial;

        }

        return res;

    }

}