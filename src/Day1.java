import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    /**
     * Read the puzzle input and return a list of integers with the result
     *
     * @param fileName file name of the puzzle input
     *
     * @return list of integers with the puzzle input
     */
    public static List<Integer> readPuzzleInput(String fileName) {

        List<Integer> result = new ArrayList<>();

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            //for each line of the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                //add -1 to the list if there is a blank row, otherwise add the calorie value
                if(data.isBlank()) {
                    result.add(-1);
                } else {
                    result.add(Integer.parseInt(data));
                }
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Parse the puzzle input aggregating the number of calories per elf
     *
     * @return each elf's calorie count
     */
    public static List<Integer> getCaloriesPerElf(){
        List<Integer> elfCaloriesRaw;
        List<Integer> elfCalories = new ArrayList<>();
        int currentCalories = 0;

        elfCaloriesRaw = readPuzzleInput("day1_1_input.txt");

        //go through every value of the list, -1 means it's a different elf
        for (int calories: elfCaloriesRaw) {
            if (calories == -1) {
                elfCalories.add(currentCalories);
                currentCalories = 0;
            } else {
                currentCalories += calories;
            }
        }

        return elfCalories;
    }

    /**
     *  Find the most calories that an elf is carrying from the given list
     *
     * @param elfCalories   list of calories per elf
     * @return the most calories being carried by an elf
     */
    public static int getMaxCalories(List<Integer> elfCalories){
        int max = 0;

        //search for the max
        for(int elf : elfCalories) {
            if(elf > max) {
                max = elf;
            }
        }
        return max;
    }

    /**
     * Sort list, sum the top three values and return the result
     *
     * @param elfCalories list of the number of calories per elf
     *
     * @return the sum of the top three elf calories
     */
    public static int getTopThreeCalories(List<Integer> elfCalories) {
        Collections.sort(elfCalories, Collections.reverseOrder());
        return elfCalories.get(0) + elfCalories.get(1) + elfCalories.get(2);
    }
}
