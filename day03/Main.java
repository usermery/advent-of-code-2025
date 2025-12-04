package day03;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
     public static void main(String[] args){
        System.out.println("first result: " + firstTaskJoltage());
        System.out.println("second result: " + secondTaskJoltage());
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

    public static int firstTaskJoltage(){

        List<String> input = getInput("day03/input.txt");
        int res = 0;
        for(String s: input){
            int firstDigit = 0;
            int lastDigit = 0;
            int startIndexLastDigit = 0;
            for(int i =0; i<s.length()-1; i++){
                if(Integer.parseInt(s.substring(i,i+1))>firstDigit){
                   firstDigit = Integer.parseInt(s.substring(i,i+1));
                   startIndexLastDigit = i+1;
                }
            }
            for(int i =startIndexLastDigit; i<s.length(); i++){
                if(Integer.parseInt(s.substring(i,i+1))>lastDigit){
                   lastDigit = Integer.parseInt(s.substring(i,i+1));
                }
            }
            String f = String.valueOf(firstDigit);
            String l = String.valueOf(lastDigit);
            String number = f+l;
            res+=Integer.parseInt(number);
        }
        return res;
    }

    public static long secondTaskJoltage(){

        List<String> input = getInput("day03/input.txt");
        long res = 0;
        for(String s: input){
            int firstDigit = 0;
            int secondDigit = 0;
            int thirdDigit = 0;
            int fourthDigit = 0;
            int fifthDigit = 0;
            int sixthDigit = 0;
            int seventhDigit = 0;
            int eighthDigit = 0;
            int ninethDigit = 0;
            int tenthDigit = 0;
            int eleventhDigit = 0;
            int twelfthDigit = 0;
            int startIndexSecondDigit = 0;
            int startIndexThirdDigit = 0;
            int startIndexFourthDigit = 0;
            int startIndexFifthDigit = 0;
            int startIndexSixthDigit = 0;
            int startIndexSeventhDigit = 0;
            int startIndexEighthDigit = 0;
            int startIndexNinethDigit = 0;
            int startIndexTenthDigit = 0;
            int startIndexEleventhDigit = 0;
            int startIndexTwelfthDigit = 0;
            for(int i =0; i<s.length()-11; i++){
                if(Integer.parseInt(s.substring(i,i+1))>firstDigit){
                   firstDigit = Integer.parseInt(s.substring(i,i+1));
                   startIndexSecondDigit = i+1;
                }
            }
            for(int i =startIndexSecondDigit; i<s.length()-10; i++){
                if(Integer.parseInt(s.substring(i,i+1))>secondDigit){
                   secondDigit = Integer.parseInt(s.substring(i,i+1));
                   startIndexThirdDigit = i+1;
                }
            }
            for(int i =startIndexThirdDigit; i<s.length()-9; i++){
                if(Integer.parseInt(s.substring(i,i+1))>thirdDigit){
                   thirdDigit = Integer.parseInt(s.substring(i,i+1));
                   startIndexFourthDigit = i+1;
                }
            }
            for(int i =startIndexFourthDigit; i<s.length()-8; i++){
                if(Integer.parseInt(s.substring(i,i+1))>fourthDigit){
                   fourthDigit = Integer.parseInt(s.substring(i,i+1));
                   startIndexFifthDigit = i+1;
                }
            }
            for(int i =startIndexFifthDigit; i<s.length()-7; i++){
                if(Integer.parseInt(s.substring(i,i+1))>fifthDigit){
                   fifthDigit = Integer.parseInt(s.substring(i,i+1));
                   startIndexSixthDigit = i+1;
                }
            }
            for(int i =startIndexSixthDigit; i<s.length()-6; i++){
                if(Integer.parseInt(s.substring(i,i+1))>sixthDigit){
                   sixthDigit = Integer.parseInt(s.substring(i,i+1));
                   startIndexSeventhDigit = i+1;
                }
            }
            for(int i =startIndexSeventhDigit; i<s.length()-5; i++){
                if(Integer.parseInt(s.substring(i,i+1))>seventhDigit){
                   seventhDigit = Integer.parseInt(s.substring(i,i+1));
                   startIndexEighthDigit = i+1;
                }
            }
            for(int i =startIndexEighthDigit; i<s.length()-4; i++){
                if(Integer.parseInt(s.substring(i,i+1))>eighthDigit){
                   eighthDigit = Integer.parseInt(s.substring(i,i+1));
                   startIndexNinethDigit = i+1;
                }
            }
            for(int i =startIndexNinethDigit; i<s.length()-3; i++){
                if(Integer.parseInt(s.substring(i,i+1))>ninethDigit){
                   ninethDigit = Integer.parseInt(s.substring(i,i+1));
                   startIndexTenthDigit = i+1;
                }
            }
            for(int i =startIndexTenthDigit; i<s.length()-2; i++){
                if(Integer.parseInt(s.substring(i,i+1))>tenthDigit){
                   tenthDigit = Integer.parseInt(s.substring(i,i+1));
                   startIndexEleventhDigit = i+1;
                }
            }
            for(int i =startIndexEleventhDigit; i<s.length()-1; i++){
                if(Integer.parseInt(s.substring(i,i+1))>eleventhDigit){
                   eleventhDigit = Integer.parseInt(s.substring(i,i+1));
                   startIndexTwelfthDigit = i+1;
                }
            }
            for(int i =startIndexTwelfthDigit; i<s.length(); i++){
                if(Integer.parseInt(s.substring(i,i+1))>twelfthDigit){
                   twelfthDigit = Integer.parseInt(s.substring(i,i+1));
                }
            }
            String first = String.valueOf(firstDigit);
            String second = String.valueOf(secondDigit);
            String third = String.valueOf(thirdDigit);
            String fourth = String.valueOf(fourthDigit);
            String fifth = String.valueOf(fifthDigit);
            String sixth = String.valueOf(sixthDigit);
            String seventh = String.valueOf(seventhDigit);
            String eighth = String.valueOf(eighthDigit);
            String nineth = String.valueOf(ninethDigit);
            String tenth = String.valueOf(tenthDigit);
            String eleventh = String.valueOf(eleventhDigit);
            String twelfth = String.valueOf(twelfthDigit);
            String number = first+second+third+fourth+fifth+sixth+seventh+eighth+nineth+tenth+eleventh+twelfth;
            res+=Long.parseLong(number);
        }
        return res;
    }
}
