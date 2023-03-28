import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day11 {
    public static void readPuzzleInput(String fileName, List<MonkeyDay11> allMonkeys) {

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            //for each line of the file
            while (myReader.hasNextLine()) {
                List<Long> heldItems = new ArrayList<>();
                char operation;
                int opValue;
                int testValue;
                int monkeyTrue;
                int monkeyFalse;
                String data;
                myReader.nextLine();
                //ignore monkey number

                if (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    data = data.substring(18).trim();
                    String[] res = data.split(",");

                    for (String item: res) {
                        heldItems.add(Long.parseLong(item.trim()));

                    }

                } else {
                    break;
                }

                if (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    if (data.charAt(25) == 'o') {
                        operation = '^';
                        opValue = 2;
                    } else {
                        operation = data.charAt(23);
                        opValue = Integer.parseInt(data.substring(24).trim());
                    }

                } else {
                    break;
                }

                if (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    testValue = Integer.parseInt(data.substring(20).trim());

                } else {
                    break;
                }

                if (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    monkeyTrue = Integer.parseInt(data.substring(data.length()-1).trim());

                } else {
                    break;
                }

                if (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    monkeyFalse = Integer.parseInt(data.substring(data.length()-1).trim());

                } else {
                    break;
                }
                if (myReader.hasNextLine()) {
                    // remove empty line
                    myReader.nextLine();
                }

                allMonkeys.add(new MonkeyDay11(heldItems, operation, opValue, testValue, monkeyTrue, monkeyFalse));
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static double calculateMonkeyBusiness() {
        List<MonkeyDay11> allMonkeys = new ArrayList<>();
        Day11.readPuzzleInput("day11_1_input.txt", allMonkeys);
        int max = 0, max2 = 0, current;
        int mmc;

        mmc = getMMC(allMonkeys);

        for (int i = 0; i < 10000; i++) {

            for (MonkeyDay11 monkey : allMonkeys) {
                monkey.monkeyTurn(allMonkeys, mmc);
            }

        }

        for (MonkeyDay11 monkey : allMonkeys) {
            current = monkey.getInspectionTotal();

            if (current > max && max < max2) {
                max = current;
            } else if (current > max2) {
                max2 = current;
            }
        }

        System.out.println(max);
        System.out.println(max2);

        return (double) max * max2 ;
    }

    public static int getMMC(List<MonkeyDay11> allMonkeys) {
        int res = 1;

        for (MonkeyDay11 monkey : allMonkeys) {
            res = res * monkey.testValue;
        }

        return res;
    }

}
