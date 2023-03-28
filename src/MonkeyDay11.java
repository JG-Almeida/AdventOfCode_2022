import java.util.List;

public class MonkeyDay11 {
    List<Long> heldItems;
    Character operation;
    int opValue;
    int testValue;
    int monkeyTrue;
    int monkeyFalse;
    int inspectionTotal = 0;

    public MonkeyDay11(List<Long> heldItems, Character operation, int opValue, int testValue, int monkeyTrue, int monkeyFalse) {
        this.heldItems = heldItems;
        this.operation = operation;
        this.opValue = opValue;
        this.testValue = testValue;
        this.monkeyTrue = monkeyTrue;
        this.monkeyFalse = monkeyFalse;
    }

    public int getInspectionTotal() {
        return inspectionTotal;
    }

    public void addItem (Long newItem) {
        heldItems.add(newItem);
    }

    public void monkeyTurn(List<MonkeyDay11> allMonkeys, int mmc) {
        for (Long item: heldItems) {
            //count inspection
            inspectionTotal++;

            //calculate new worry level
            switch (operation) {
                case '*' -> item = item * opValue % mmc;
                case '+' -> item = item + opValue % mmc;
                case '^' -> item = item * item % mmc;
            }

            //monkey gets bored part 1
//            item = item / 3;

            //monkey throws item to another monkey
            if (item % testValue == 0) {
                allMonkeys.get(monkeyTrue).addItem(item);

            } else {
                allMonkeys.get(monkeyFalse).addItem(item);

            }

        }

        heldItems.clear();
    }
}
