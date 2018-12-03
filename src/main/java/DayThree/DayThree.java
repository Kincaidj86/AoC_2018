package DayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DayThree {
    private List<String> input = new ArrayList<>();
    private HashMap<String, Integer> cloth = new HashMap<>();
    private Integer shared = 0;

    public Integer createList() {
        File file = new File("/Users/jkinc3/Desktop/AdventOfCode/src/main/resources/dayThreeInput");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            input.add(sc.nextLine());
        }
        input.forEach(x -> {
            String[] claim = x.replace(":", "").replace("@ ", "").replace("#", "").replace(",", " ").replace("x", " ").split(" ");
            Integer[][] toAdd = new Integer[2][2];
            toAdd[0][0] = Integer.parseInt(claim[1]);
            toAdd[0][1] = Integer.parseInt(claim[1]) + Integer.parseInt(claim[3]);
            toAdd[1][0] = Integer.parseInt(claim[2]);
            toAdd[1][1] = Integer.parseInt(claim[2]) + Integer.parseInt(claim[4]);

            for (int i = toAdd[0][0]; i < toAdd[0][1]; ++i) {
                for (int y = toAdd[1][0]; y < toAdd[1][1]; ++y) {
                    String key = Integer.toString(i) + "-" + Integer.toString(y);
                    if(cloth.get(key) == null) {
                        cloth.put(key, 1);
                    } else if(cloth.get(key) == 1) {
                        cloth.put(key, 2);
                        shared++;
                    }
                }
            }
        });
        return shared;
    }

    public Set<Integer> locateUnique() {
        HashMap<Integer, String> unique = new HashMap<>();
        input.forEach(x -> {
            String[] claim = x.replace(":", "").replace("@ ", "").replace("#", "").replace(",", " ").replace("x", " ").split(" ");
            Integer[][] toAdd = new Integer[3][2];
            toAdd[0][0] = Integer.parseInt(claim[1]);
            toAdd[0][1] = Integer.parseInt(claim[1]) + Integer.parseInt(claim[3]);
            toAdd[1][0] = Integer.parseInt(claim[2]);
            toAdd[1][1] = Integer.parseInt(claim[2]) + Integer.parseInt(claim[4]);
            toAdd[2][0] = Integer.parseInt(claim[0]);
            boolean getOut = false;
            for (int i = toAdd[0][0]; i < toAdd[0][1]; ++i) {
                if(getOut)
                    break;
                for (int y = toAdd[1][0]; y < toAdd[1][1]; ++y) {
                    if(getOut)
                        break;
                    String key = Integer.toString(i) + "-" + Integer.toString(y);
                    if(cloth.get(key) == 1) {
                        unique.put(toAdd[2][0], "unique");
                    } else if(cloth.get(key) == 2) {
                        unique.remove(toAdd[2][0]);
                        getOut = true;
                    }
                }
            }
        });
        return unique.keySet();
    }
}
