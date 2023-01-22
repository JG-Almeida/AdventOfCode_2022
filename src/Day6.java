import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Day6 {

    public static String readPuzzleInput(String fileName) {
        String result = "";

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            //for each line of the file
            while (myReader.hasNextLine()) {
                result = myReader.nextLine();

            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return result;
    }

    public static int findStartOfPacket(String signal, int size) {
        int result = 0;
        LinkedList<Character> marker = new LinkedList<Character>();

        for (int i = 0; i < signal.length() ; i++) {

            while(isCharInList(marker, signal.charAt(i))) {
                marker.removeLast();
            }

            marker.push(signal.charAt(i));

            if(marker.size() == size) {
                result = i + 1;
                break;
            }
        }

        return result;
    }

    static boolean isCharInList(LinkedList<Character> list, char character) {
        for (Character c : list) {
            if(c == character) {
               return true;
            }
        }
        return false;
    }

}
