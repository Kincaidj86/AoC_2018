import DayOne.FrequencyCalculator;
import DayThree.DayThree;
import DayTwo.CheckSumCalc;

public class AdventOfCode {
    public static void main(String[] args) {
        FrequencyCalculator frequencyCalculator = new FrequencyCalculator();
        frequencyCalculator.createList();
        System.out.println(frequencyCalculator.calculateCumulative());
        System.out.println(frequencyCalculator.discoverDuplicate());

        CheckSumCalc checkSumCalc = new CheckSumCalc();
        System.out.println(checkSumCalc.calculateCheckSum());
        System.out.println(checkSumCalc.findSharedLetters());

        DayThree dayThree = new DayThree();
        System.out.println(dayThree.createList());
        System.out.println(dayThree.locateUnique());
    }
}
