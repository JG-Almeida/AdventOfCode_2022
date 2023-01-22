public class CPU {
    int clock;
    int registerX;

    public CPU() {
        this.clock = 0;
        this.registerX = 1;
    }

    public int noop() {
        this.clock++;
        this.draw();
        return calculateSignalStrength();
    }

    public int addX(int v) {
        int signalStrength = 0;
        this.clock++;
        this.draw();
        signalStrength += calculateSignalStrength();
        this.clock++;
        this.draw();
        signalStrength += calculateSignalStrength();
        this.registerX += v;
        return signalStrength;
    }

    public int calculateSignalStrength() {
        if((this.clock - 20) % 40 == 0) {
            return this.registerX * this.clock;
        }

        return 0;
    }

    public void draw() {
        if(this.clock % 40 >= this.registerX && this.clock % 40 <= this.registerX + 2) {
            System.out.print("#");
        } else {
            System.out.print(".");
        }

        if(this.clock % 40 == 0) {
            System.out.println();
        }
    }
}
