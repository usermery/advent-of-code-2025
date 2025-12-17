package day05;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args){
        System.out.println("first result: " + firstTaskCafeteria());
        System.out.println("second result: " + secondTaskCafeteria());
    }

    public static List<List<String>> getInput(String file){
        List<String> input = new ArrayList<>();
        try{
            input = Files.readAllLines(Path.of(file));
        }catch(Exception e){
            e.printStackTrace();
        }

        List<String> ranges = new ArrayList<>();
        List<String> ids = new ArrayList<>();

        for(String s: input){
            if(s.isEmpty()){
                continue;
            }

            if(s.contains("-")){
                ranges.add(s);
            }else{
                ids.add(s);
            }
        }

        List<List<String>> res = new ArrayList<>();
        res.add(ranges);
        res.add(ids);
        return res;

    }

    public static long firstTaskCafeteria(){

        List<List<String>> input = getInput("day05/input.txt");
        List<String> ranges = input.get(0);
        List<String> ids = input.get(1);

        long res = 0;

        outer:
        for(String s: ids){
            long value = Long.parseLong(s);
            for(String t: ranges){

                String[] range = t.split("-");
                long start = Long.parseLong(range[0]);
                long end = Long.parseLong(range[1]);

                
                if (value >= start && value <= end) { 
                    res++;
                    continue outer;
                }

            }
        }

        return res;
    }

    public static long secondTaskCafeteria(){

        List<List<String>> input = getInput("day05/input.txt");
        List<String> ranges = input.get(0);

        long res = 0;

        List<long[]> list = new ArrayList<>();
        for (String r : ranges) {
            String[] p = r.split("-");
            long start = Long.parseLong(p[0]);
            long end = Long.parseLong(p[1]);
            list.add(new long[]{start, end});
        }

        list.sort((a, b) -> Long.compare(a[0], b[0]));

        List<long[]> merged = new ArrayList<>();
        long currentStart = list.get(0)[0];
        long currentEnd = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            long s = list.get(i)[0];
            long e = list.get(i)[1];

            if (s <= currentEnd) {
                currentEnd = Math.max(currentEnd, e);
            } else {
                merged.add(new long[]{currentStart, currentEnd});
                currentStart = s;
                currentEnd = e;
            }
        }

        merged.add(new long[]{currentStart, currentEnd});

        for(long[] range: merged){
            res+= range[1]-range[0]+1;
        }

        return res;
    }


}
