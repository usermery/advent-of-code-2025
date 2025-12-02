import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main{
    
    public static void main(String[] args){
        System.out.println("first result: " + firstTask());
    }

    private static List<String> getInput(String file){
        List<String> input = new ArrayList<>();
        try{
            input = Files.readAllLines(Path.of("day-01/input.txt"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return input;
    }

    public static int firstTask(){

        int res = 0;
        int dial = 50;

        for(String s: getInput("task-01/input.txt")){
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

    public static int secondTask(){

        int res = 0;
        int dial = 50;

        for(String s: getInput("task-01/input.txt")){

            char dir = s.charAt(0);
            int count = Integer.parseInt(s.substring(1, s.length()));
            int oldDial = dial;
            if(dir=='R'){
                dial = (dial + count) % 100;
                res += (oldDial + count) / 100;
            }else{
                dial = (dial - count + 100) % 100;
                int mirrorOldDial = (100-oldDial) % 100;
                res += (mirrorOldDial + count) / 100;
            }

        }

        return res;

    }

}