import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8 {
    public static int[][] readPuzzleInput(String fileName) {
        int height = 0;
        int length;
        String rows = "";
        int[][] treeMap = new int[0][];

        try {
            File myObj = new File(fileName);
            Scanner countRows = new Scanner(myObj);

            //for each line of the file
            while (countRows.hasNextLine()) {
                rows = countRows.nextLine();
                height++;
            }

            length = rows.length();

            countRows.close();
            Scanner myReader = new Scanner(myObj);

            treeMap = new int[height][length];
            height = 0;

            //for each line of the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                length = 0;
                for (char tree : data.toCharArray()) {
                    treeMap[height][length] = Character.getNumericValue(tree);
                    length++;
                }
                height++;
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return treeMap;
    }

    public static int countVisibleTrees(int[][] treeMap) {
        int visibleTrees = 0;
        boolean visible;

        for(int x = 0; x < treeMap.length; x++) {
            for(int y = 0; y < treeMap[x].length; y++) {
                visible = true;

                //check left
                for(int z = 0; z < x; z++) {
                    if(treeMap[z][y] >= treeMap[x][y]) {
                        visible = false;
                        break;
                    }
                }

                if(visible) {
                    visibleTrees++;
                    continue;
                }

                visible = true;

                //check right
                for(int z = x + 1; z < treeMap.length; z++) {
                    if(treeMap[z][y] >= treeMap[x][y]) {
                        visible = false;
                        break;
                    }
                }

                if(visible) {
                    visibleTrees++;
                    continue;
                }

                visible = true;

                //check top
                for(int z = 0; z < y; z++) {
                    if(treeMap[x][z] >= treeMap[x][y]) {
                        visible = false;
                        break;
                    }
                }

                if(visible) {
                    visibleTrees++;
                    continue;
                }

                visible = true;

                //check bottom
                for(int z = y + 1; z < treeMap[x].length; z++) {
                    if(treeMap[x][z] >= treeMap[x][y]) {
                        visible = false;
                        break;
                    }
                }

                if(visible) {
                    visibleTrees++;
                }

            }
        }
        return visibleTrees;
    }

    public static int findHighestScenicScore(int[][] treeMap) {
        int currentScenicScore = 0;
        int maxScenicScore = 0;
        int countTrees;

        for(int x = 1; x < treeMap.length-1; x++) {
            for(int y = 1; y < treeMap[x].length-1; y++) {

                countTrees = 0;

                //check left
                for(int z = x - 1; z >= 0; z--) {
                    countTrees++;
                    if(treeMap[z][y] >= treeMap[x][y]) {
                        break;
                    }
                }

                currentScenicScore = countTrees;
                countTrees = 0;

                //check right
                for(int z = x + 1; z < treeMap.length; z++) {
                    countTrees++;
                    if(treeMap[z][y] >= treeMap[x][y]) {
                        break;
                    }
                }

                currentScenicScore = currentScenicScore * countTrees;
                countTrees = 0;

                //check top
                for(int z = y - 1; z >= 0; z--) {
                    countTrees++;
                    if(treeMap[x][z] >= treeMap[x][y]) {
                        break;
                    }
                }

                currentScenicScore = currentScenicScore * countTrees;
                countTrees = 0;

                //check bottom
                for(int z = y + 1; z < treeMap[x].length; z++) {
                    countTrees++;
                    if(treeMap[x][z] >= treeMap[x][y]) {
                        break;
                    }
                }

                currentScenicScore = currentScenicScore * countTrees;

                if(maxScenicScore < currentScenicScore) {
                    maxScenicScore = currentScenicScore;
                }

            }
        }

        return maxScenicScore;
    }
}
