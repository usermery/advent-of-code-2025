import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args){
        System.out.println("first result: " + firstTask());
        System.out.println("second result: " + secondTask());
    }

    private static String[] formatInput(String file){

        List<String> input = new ArrayList<>();
        try{
            input = Files.readAllLines(Path.of(file));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        String[] formattedInput = input.get(0).split(",");
        return formattedInput;

    }

    public static long firstTask(){

        long res = 0;
        String[] input = formatInput("day-02/input.txt");

        for(String s: input){

            String[] range = s.split("-");
            for(long i=Long.parseLong(range[0]); i<=Long.parseLong(range[1]); i++){

                int digits = String.valueOf(i).length();
                if(digits%2==0){
                    String id = String.valueOf(i);
                    String firstHalf = id.substring(0, digits/2);
                    String secondHalf = id.substring(digits/2, id.length());
                    if(firstHalf.equals(secondHalf)){
                        res+=i;
                    }
                }
            }

        }

        return res;

    }

    public static long secondTask(){
        
        long res = 0;
        String[] input = formatInput("day-02/input.txt");

        for(String s: input){
        
            String[] range = s.split("-");
            for(long i=Long.parseLong(range[0]); i<=Long.parseLong(range[1]); i++){
                if(String.valueOf(i).matches("^(\\d+)\\1+$")){
                    res+=i;
                }
            }

        }

        return res;
    }

}
