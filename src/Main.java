import java.util.List;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Please, insert a code!");
            System.exit(0);
        }
        switch (args[0]) {
            case "1" -> {
                List<Integer> elfCalories = Day1.getCaloriesPerElf();
                //Day 1 Puzzle 1 Solution
                System.out.println(Day1.getMaxCalories(elfCalories));
                //Day 1 Puzzle 2 Solution
                System.out.println(Day1.getTopThreeCalories(elfCalories));
            }
            case "2" -> {
                //Day 2 Puzzle 1 Solution
                System.out.println(Day2.getTotalScore());
                //Day 2 Puzzle 2 Solution
                System.out.println(Day2.getTotalScoreAlternate());
            }
            case "3" -> {
                // Day 3 Puzzle 1 Solution
                System.out.println(Day3.getSumPriorities());
                // Day 3 Puzzle 2 Solution
                System.out.println(Day3.getSumBadges());
            }
            case "4" -> {
                // Day 4 Puzzle 1 Solution
                System.out.println(Day4.findContainedAssignments());
                // Day 4 Puzzle 2 Solution
                System.out.println(Day4.findOverlappedAssignments());
            }
            case "5" -> {
                // Day 5 Puzzle 1 Solution
                System.out.println(Day5.topOfStack(false));
                // Day 5 Puzzle 2 Solution
                System.out.println(Day5.topOfStack(true));
            }
            case "6" -> {
                // Day 6 Puzzle 1 Solution
                System.out.println(Day6.findStartOfPacket(Day6.readPuzzleInput("day6_1_input.txt"), 4));
                // Day 6 Puzzle 2 Solution
                System.out.println(Day6.findStartOfPacket(Day6.readPuzzleInput("day6_1_input.txt"), 14));
            }
            case "7" -> {
                NodeFile fileSystem = Day7.parsePuzzleInput();
                fileSystem.calculateDirSize();
                // Day 7 Puzzle 1 Solution
                System.out.println(fileSystem.sumDirOverSize());
                // Day 7 Puzzle 2 Solution
                System.out.println(fileSystem.findSmallestDir(fileSystem.size - 40000000));
            }
            case "8" -> {
                int[][] treeMap = Day8.readPuzzleInput("day8_1_input.txt");
                System.out.println(Day8.countVisibleTrees(treeMap));
                System.out.println(Day8.findHighestScenicScore(treeMap));
            }
            case "9" -> {
                System.out.println(Day9.calculateVisitedPositions(1));
                System.out.println(Day9.calculateVisitedPositions(9));
            }
            case "10" -> System.out.println(Day10.calculateSignalStrength());
            case "11" -> System.out.println(Day11.calculateMonkeyBusiness());
            default -> System.out.println("Wrong code!");
        }
    }
}