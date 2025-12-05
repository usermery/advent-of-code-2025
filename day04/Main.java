package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException {
        System.out.println("first result: " + firstTaskRolls());
        System.out.println("second result: " + secondTaskRolls());
    }

    public static char[][] getInput(String file){

        List<String> lines = new ArrayList<String>();
        try{
            lines = Files.readAllLines(Path.of(file));
        }catch(Exception e){
            e.printStackTrace();
        }

        char[][] input = new char[lines.size()][lines.get(0).length()];
        

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            for (int j = 0; j < lines.get(0).length(); j++) {
                input[i][j] = line.charAt(j);
            }
        }

        return input;
    }

    public static int firstTaskRolls() {

        int res = 0;
        char[][] input = getInput("day04/input.txt");

        int rows = input.length;
        int cols = input[0].length;

        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (input[i][j] != '@') {
                   continue; 
                }

                int count = 0;

                for (int[] d : dirs) {
                    int nr = i + d[0];
                    int nc = j + d[1];
   
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                        if (input[nr][nc] == '@') {
                            count++;
                        }
                    }
                }   

                if (count < 4) {
                    res++;
                }
            }
        }

        return res;   
    }

    public static int secondTaskRolls() {
        char[][] input = getInput("day04/input.txt");
        int rows = input.length;
        int cols = input[0].length;

        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };

        int totalRemoved = 0;

        boolean changed = true;
        while (changed) {
            changed = false;

            List<int[]> toRemove = new ArrayList<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    if (input[i][j] != '@')
                        continue;

                    int count = 0;

                    for (int[] d : dirs) {
                        int nr = i + d[0];
                        int nc = j + d[1];

                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                            if (input[nr][nc] == '@') {
                                count++;
                            }
                        }
                    }

                    if (count < 4) {
                        toRemove.add(new int[] { i, j });
                    }
                }
            }

            if (toRemove.isEmpty())
                break;

            for (int[] pos : toRemove) {
                input[pos[0]][pos[1]] = 'x';
            }

            totalRemoved += toRemove.size();
            changed = true;
        }

        return totalRemoved;
    }

}
