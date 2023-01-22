import org.w3c.dom.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day7 {

    public static NodeFile parsePuzzleInput() {
        NodeFile fileSystem = new NodeFile("/");
        NodeFile pointer = fileSystem;
        NodeFile newNode;
        String fileName = "day7_1_input.txt";

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            //for each line of the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String[] parts = data.split(" ");

                if(parts[1].equals("ls")) {
                } else if(parts[1].equals("cd")) {
                    if(parts[2].equals("/")) {
                    } else if(parts[2].equals("..")) {
                        pointer = pointer.parent;

                    } else {
                        for(NodeFile child : pointer.children) {
                            if(child.name.equals(parts[2])) {
                                pointer = child;
                            }
                        }
                        if(!pointer.name.equals(parts[2])) {
                            newNode = new NodeFile(parts[2], -1, "dir", pointer);
                            pointer.children.add(newNode);

                        }
                    }
                } else if(parts.length == 2) {
                    if(!pointer.isChild(parts[1])) {
                        if(parts[0].equals("dir")) {
                            newNode = new NodeFile(parts[1], -1, "dir", pointer);
                        } else {
                            newNode = new NodeFile(parts[1], Integer.parseInt(parts[0]), "file", pointer);
                        }
                        pointer.addChild(newNode);
                    }
                } else {
                    System.out.println("Whoopsie!");
                }
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return fileSystem;
    }
}
