import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day9 {

    public static List<int[]> readPuzzleInput(String fileName) {

        List<int[]> moves = new ArrayList<>();
        int[] move = new int[2];

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            //for each line of the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(" ");
                switch(parts[0]){
                    case "R":
                        move[0] = 1;
                        break;
                    case "L":
                        move[0] = 2;
                        break;
                    case "U":
                        move[0] = 3;
                        break;
                    case "D":
                        move[0] = 4;
                        break;
                }
                move[1] = Integer.parseInt(parts[1]);
                moves.add(move.clone());
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return moves;
    }

    public static int calculateVisitedPositions(int knots) {

        List<int[]> moves = Day9.readPuzzleInput("day9_1_input.txt");
        Position head = new Position(0, 0);
        Position[] tails = new Position[knots];

        for(int i = 0; i < knots; i++) {
            tails[i] = new Position(0, 0);
        }

        for (int[] move: moves) {
            for(int x = 0; x < move[1] ; x++) {
                head.move(move[0]);
                int index = 0;
                for(Position tail:tails) {
                    if(index == 0) {
                        tail.follow(head);
                    } else {
                        tail.follow(tails[index-1]);
                    }
                    index++;
                }
            }
        }

        return tails[tails.length-1].visitedPositions.size();

    }
}
