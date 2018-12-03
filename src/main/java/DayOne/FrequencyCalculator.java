package DayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FrequencyCalculator {
    private Integer cumulative = 0;
    private List<Integer> inputFrequencies = new ArrayList<>();
    private List<Integer> trackedFrequencies = new ArrayList<>();

    public void createList() {
        File file = new File("/Users/jkinc3/Desktop/AdventOfCode/src/main/resources/dayOneInput.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            inputFrequencies.add(Integer.parseInt(sc.nextLine()));
        }
    }

    public Integer calculateCumulative() {
        inputFrequencies.forEach(x -> cumulative += x);
        return cumulative;
    }

    public Integer discoverDuplicate() {
        int i = 0;
        cumulative = 0;
        while(isNotDuplicate(inputFrequencies.get(i) + cumulative)) {
            cumulative += inputFrequencies.get(i);
            trackedFrequencies.add(cumulative);
            ++i;
            if(inputFrequencies.size() == i) {
                i = 0;
            }
        }
        return inputFrequencies.get(i) + cumulative;

    }

    private boolean isNotDuplicate(Integer current) {
        return !trackedFrequencies.contains(current);
    }
}
