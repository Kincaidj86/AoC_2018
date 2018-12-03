package DayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CheckSumCalc {
    private List<String> boxIds = new ArrayList<>();
    private int twos = 0;
    private int threes = 0;

    private void createList() {
        File file = new File("/Users/jkinc3/Desktop/AdventOfCode/src/main/resources/dayTwoInput.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            boxIds.add(sc.nextLine());
        }
    }

    public Integer calculateCheckSum() {
        createList();
        boxIds.forEach(x -> calculateTwosAndThrees(x));
        return twos * threes;
    }

    private void calculateTwosAndThrees(String boxId) {
        HashMap<Integer, Integer> alphabetMap = new HashMap<>();
        boxId.chars().forEach(x -> {
            int toAdd = 0;
            if(alphabetMap.get(x) == null) {
                toAdd = 1;
            } else {
                toAdd = alphabetMap.get(x) + 1;
            }
            alphabetMap.put(x, toAdd);
        });

        if(alphabetMap.containsValue(2)){
            twos += 1;
        }
        if(alphabetMap.containsValue(3)){
            threes += 1;
        }
    }

    public String findSharedLetters() {
        for (int i = 0; i < boxIds.size(); i++) {
            String firstLine = boxIds.get(i);
            for (int j = i + 1; j < boxIds.size(); j++) {
                String secondLine = boxIds.get(j);
                StringBuilder sharedLetters = new StringBuilder();
                int difference = 0;
                for (int k = 0; k < firstLine.length(); k++) {
                    if (firstLine.charAt(k) != secondLine.charAt(k)) {
                        if (++difference > 1) {
                            break;
                        }
                    } else {
                        sharedLetters.append(firstLine.charAt(k));
                    }
                }
                if (difference == 1) {
                    return sharedLetters.toString();
                }
            }
        }
        return null;
    }

}
