import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day10 {

    public static List<int[]> readPuzzleInput(String fileName) {

        List<int[]> instructions = new ArrayList<>();
        int[] instruction = new int[2];

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            //for each line of the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(" ");
                switch(parts[0]){
                    case "addx":
                        instruction[0] = 1;
                        instruction[1] = Integer.parseInt(parts[1]);
                        break;
                    case "noop":
                        instruction[0] = 2;
                        instruction[1] = 0;
                        break;
                }
                instructions.add(instruction.clone());
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return instructions;
    }

    public static int calculateSignalStrength() {
        List<int[]> instructions = readPuzzleInput("day10_1_input.txt");
        CPU communicationSystem = new CPU();
        int signalStrength = 0;

        for (int[] instruction : instructions) {
            switch(instruction[0]) {
                case 1:
                    signalStrength += communicationSystem.addX(instruction[1]);
                    break;
                case 2:
                    signalStrength += communicationSystem.noop();
                    break;
            }
        }
        return signalStrength;
    }
}
