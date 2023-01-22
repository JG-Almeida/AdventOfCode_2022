import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {

    /**
     * Read the puzzle input and store the result on an integer array with four positions
     * where the first two positions correspond to the first interval and the later two positions
     * correspond to the second interval
     *
     * @param fileName name of the puzzle input file
     *
     * @return puzzle input
     */
    public static List<int[]> readPuzzleInput(String fileName){

        List<int[]> puzzleInput = new ArrayList<>();
        int indexStart;
        int indexEnd;
        int[] assignmentPair = new int[4];

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            //for each line of the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                indexEnd = data.indexOf('-');
                assignmentPair[0] = Integer.parseInt(data.substring(0, indexEnd));

                indexStart = indexEnd + 1;
                indexEnd = data.indexOf(',');
                assignmentPair[1] = Integer.parseInt(data.substring(indexStart, indexEnd));

                indexStart = indexEnd + 1;
                indexEnd = data.indexOf('-', data.indexOf(','));
                assignmentPair[2] = Integer.parseInt(data.substring(indexStart, indexEnd));

                indexStart = indexEnd + 1;
                assignmentPair[3] = Integer.parseInt(data.substring(indexStart));

                puzzleInput.add(assignmentPair.clone());
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return puzzleInput;
    }

    public static int findContainedAssignments() {
        int containedAssignments = 0;
        List<int[]> assignmentPairs = readPuzzleInput("day4_1_input.txt");

        for(int[] pair: assignmentPairs) {
            if(pair[0] <= pair[2] && pair[1] >= pair[3]) {
                containedAssignments++;
            } else if(pair[2] <= pair[0] && pair[3] >= pair[1]) {
                containedAssignments++;
            }
        }

        return containedAssignments;
    }

    public static int findOverlappedAssignments() {
        int overlappedAssignments = 0;
        List<int[]> assignmentPairs = readPuzzleInput("day4_1_input.txt");

        for(int[] pair: assignmentPairs) {
            if(pair[0] <= pair[2] && pair[1] >= pair[2]) {
                overlappedAssignments++;
            } else if(pair[2] <= pair[0] && pair[3] >= pair[0]) {
                overlappedAssignments++;
            }
        }

        return overlappedAssignments;
    }

}
