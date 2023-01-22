import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {

    /**
     * Read the puzzle input and store the result in a list of strings
     * each string corresponds rucksack
     *
     * @param fileName name of the day 3 file input
     *
     * @return puzzle input separated by compartments
     */
    public static List<String> readPuzzleInput(String fileName){

        List<String> puzzleInput = new ArrayList<>();

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            //for each line of the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                puzzleInput.add(data);
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return puzzleInput;
    }

    /**
     * For each rucksack, find the item that is common in both compartments.
     * Sum the priorities for all the common items.
     *
     * @return sum of priorities
     */
    public static int getSumPriorities() {
        int sumPriorities = 0;
        boolean found = false;
        List<String> rucksacks = readPuzzleInput("Day3_1_input.txt");

        for (String sack: rucksacks) {
            for (int i = 0; i < sack.length() / 2 && !found ; i++) {
                for(int j = 0;j < sack.length() / 2 && !found ; j++)
                if(sack.charAt(i) == sack.charAt( j + sack.length() / 2)) {
                    if(Character.isUpperCase(sack.charAt(i))) {
                        sumPriorities += (sack.charAt(i) - 'A' + 27) ;
                    } else {
                        sumPriorities += (sack.charAt(i) - 'a' + 1) ;
                    }
                    found = true;
                }
            }
            found = false;
        }

        return sumPriorities;
    }

    /**
     * Find the badge for each group of rucksacks and sum their priorities
     *
     * @return sum of badge priorities
     */
    public static int getSumBadges() {
        int sumBadges = 0;
        boolean found = false;
        List<String> rucksacks = readPuzzleInput("Day3_1_input.txt");

        for(int i = 0; i < rucksacks.size(); i+=3) {
            for(int x = 0; x < rucksacks.get(i).length() && !found; x++) {
                for(int y = 0; y < rucksacks.get(i+1).length() && !found; y++){
                    if(rucksacks.get(i).charAt(x) == rucksacks.get(i+1).charAt(y)) {
                        for(int z = 0; z < rucksacks.get(i+2).length() && !found; z++) {
                            if(rucksacks.get(i).charAt(x) == rucksacks.get(i+2).charAt(z)) {
                                if(Character.isUpperCase(rucksacks.get(i).charAt(x))) {
                                    sumBadges += (rucksacks.get(i).charAt(x) - 'A' + 27) ;
                                } else {
                                    sumBadges += (rucksacks.get(i).charAt(x) - 'a' + 1) ;
                                }
                                found = true;
                            }
                        }
                    }
                }
            }
            found = false;
        }

        return sumBadges;
    }
}
