import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

    /**
     * Read the puzzle input for day 2 and store it into list for char arrays that will have two values,
     * for the first value it will have A, B and C and for the second value it will have X, Y, Z
     *
     * @param fileName name of the input file
     *
     * @return list of char arrays
     */
    public static List<char[]> readPuzzleInput(String fileName){

        List<char[]> puzzleInput = new ArrayList<>();
        char[] round;

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            //for each line of the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                round = new char[]{data.charAt(0), data.charAt(2)};
                puzzleInput.add(round);
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return puzzleInput;
    }

    /**
     * Calculate the total score if X, Y, and Z correspond to rock, paper, scissors
     * Points:
     * 0 for lost, 3 for draw, 6 for win
     * 1 for rock, 2 for paper, 3 for scissors
     *
     * @return total score
     */
    public static int getTotalScore() {
        List<char[]> strategyGuide = readPuzzleInput("day2_1_input.txt");
        int totalScore = 0;

        for (char[] round : strategyGuide) {
            switch(round[0]) {
                case 'A':
                    switch(round[1]) {
                        case 'X':
                            totalScore += 4; // 3 + 1
                            break;
                        case 'Y':
                            totalScore += 8; // 6 + 2
                            break;
                        case 'Z':
                            totalScore += 3; // 0 + 3
                            break;
                    }
                    break;
                case 'B':
                    switch(round[1]) {
                        case 'X':
                            totalScore += 1; // 0 + 1
                            break;
                        case 'Y':
                            totalScore += 5; // 3 + 2
                            break;
                        case 'Z':
                            totalScore += 9; // 6 + 3
                            break;
                    }
                    break;
                case 'C':
                    switch(round[1]) {
                        case 'X':
                            totalScore += 7; // 6 + 1
                            break;
                        case 'Y':
                            totalScore += 2; // 0 + 2
                            break;
                        case 'Z':
                            totalScore += 6; // 3 + 3
                            break;
                    }
                    break;
            }
        }

        return totalScore;
    }

    /**
     * Calculate the total score if X, Y, and Z correspond to lose, draw, and win
     * Points:
     * 0 for lost, 3 for draw, 6 for win
     * 1 for rock, 2 for paper, 3 for scissors
     *
     * @return total score
     */
    public static int getTotalScoreAlternate() {
        List<char[]> strategyGuide = readPuzzleInput("day2_1_input.txt");
        int totalScore = 0;

        for (char[] round : strategyGuide) {
            switch(round[0]) {
                case 'A':
                    switch(round[1]) {
                        case 'X':
                            totalScore += 3; // 0 + 3
                            break;
                        case 'Y':
                            totalScore += 4; // 3 + 1
                            break;
                        case 'Z':
                            totalScore += 8; // 6 + 2
                            break;
                    }
                    break;
                case 'B':
                    switch(round[1]) {
                        case 'X':
                            totalScore += 1; // 0 + 1
                            break;
                        case 'Y':
                            totalScore += 5; // 3 + 2
                            break;
                        case 'Z':
                            totalScore += 9; // 6 + 3
                            break;
                    }
                    break;
                case 'C':
                    switch(round[1]) {
                        case 'X':
                            totalScore += 2; // 0 +2
                            break;
                        case 'Y':
                            totalScore += 6; // 3 + 3
                            break;
                        case 'Z':
                            totalScore += 7; // 6 + 1
                            break;
                    }
                    break;
            }
        }

        return totalScore;
    }

}
