import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Position {
    int x;
    int y;
    List<int[]> visitedPositions;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.visitedPositions = new ArrayList<>();
        visitedPositions.add(new int[]{0,0});
    }

    public int calcDistance(Position a) {
        return (int) sqrt(pow(this.x - a.x, 2) + pow(this.y - a.y, 2));
    }

    public void move(int direction) {
        switch(direction) {
            case 1:
                x++;
                break;
            case 2:
                x--;
                break;
            case 3:
                y++;
                break;
            case 4:
                y--;
                break;
        }
    }

    public void follow(Position head) {
        if(this.calcDistance(head) < 2) {
            return;
        }

        if(head.y != this.y) {
            if(head.y > this.y) {
                this.y++;
            } else {
                this.y--;
            }
        }

        if(head.x != this.x) {
            if(head.x > this.x) {
                this.x++;
            } else {
                this.x--;
            }
        }

        for(int[] position : visitedPositions) {
            if(position[0] == this.x && position[1] == this.y) {
                return;
            }
        }

        visitedPositions.add(new int[]{this.x, this.y});
    }

}
