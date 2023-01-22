import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5 {

    public static List<int[]> readPuzzleInput(String fileName, List<Stack<Character>> warehouse){

        List<int[]> puzzleInput = new ArrayList<>();
        int[] move= new int[3];
        LinkedList<Character> reverseAux = new LinkedList<Character>();

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            //for each line of the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if(data.contains("[")) {
                    for (int i = 0; i < (data.length() + 1) / 4; i++) {
                        if(i >= warehouse.size()) {
                            warehouse.add(new Stack<>());
                        }

                        if(!data.substring(i * 4, i * 4 + 3).isBlank()) {
                            warehouse.get(i).add((data + " ")
                                    .substring(i * 4, i * 4 + 3)
                                    .replaceAll("[\\[\\]]", "")
                                    .charAt(0));
                        }
                    }
                }

                if(data.isEmpty()) {
                    break;
                }
            }

            for (Stack<Character> stack: warehouse) {
                while(!stack.isEmpty()) {
                    reverseAux.add(stack.pop());
                }

                while(!reverseAux.isEmpty()) {
                    stack.push(reverseAux.remove());
                }
            }

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split("move | from | to ");
                for(int i = 1; i < parts.length ; i++) {
                    move[i-1] = Integer.parseInt(parts[i]);
                }
                puzzleInput.add(move.clone());
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return puzzleInput;
    }

    public static void rearrangeStacks(List<Stack<Character>> warehouse, List<int[]> procedure) {
        for (int[] instruction: procedure) {
            for(int i = 0; i < instruction[0]; i++) {
                warehouse.get(instruction[2]-1).push(warehouse.get(instruction[1]-1).pop());
            }
        }
    }

    public static void rearrangeStacksPickUp(List<Stack<Character>> warehouse, List<int[]> procedure) {
        Stack<Character> crane = new Stack<Character>();
        for (int[] instruction: procedure) {

            for(int i = 0; i < instruction[0]; i++) {
                crane.push(warehouse.get(instruction[1]-1).pop());
            }

            while(!crane.isEmpty()) {
                warehouse.get(instruction[2]-1).push(crane.pop());
            }
        }
    }

    public static String topOfStack(boolean config){
        String result = "";
        List<Stack<Character>> warehouse = new ArrayList<Stack<Character>>();
        List<int[]> procedure = Day5.readPuzzleInput("day5_1_input.txt", warehouse);

        if(config) {
            Day5.rearrangeStacksPickUp(warehouse, procedure);
        } else {
            Day5.rearrangeStacks(warehouse, procedure);
        }

        for (Stack<Character> stack: warehouse) {
            result += stack.pop();
        }

        return result;
    }

}
