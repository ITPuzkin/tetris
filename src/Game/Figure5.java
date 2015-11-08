package Game;

public class Figure5 extends Figure {

	public Figure5()
    {
        int[][] mask = {{0,0,1,0},{0,0,1,0},{0,0,1,1},{0,0,0,0}};
        this.setMask(mask);
        position = 1;
        ofR =0;
        ofL =2;
    }

    @Override
    public void Rotate(int a) {
        if (a == 1) {
            if (position == 1) {
                int[][] mask = {{0, 0, 0, 0}, {0, 1, 1, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}};
                this.setMask(mask);
                position = 2;
                ofR = 0;
                ofL = 1;
            }
            else if (position == 2) {
                int[][] mask = {{0, 0, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 0}};
                this.setMask(mask);
                position = 3;
                ofR = 0;
                ofL = 2;
            }
            else if (position == 3) {
                int[][] mask = {{0, 0, 0, 0}, {0, 0, 0, 1}, {0, 1, 1, 1}, {0, 0, 0, 0}};
                this.setMask(mask);
                position = 4;
                ofR = 0;
                ofL = 1;
            }
            else if (position == 4) {
                int[][] mask = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 1}, {0, 0, 0, 0}};
                this.setMask(mask);
                position = 1;
                ofR = 0;
                ofL = 2;
            }
        } 
        else {
            if (position == 1) {
                int[][] mask = {{0, 0, 0, 0}, {0, 1, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, 0}};
                this.setMask(mask);
                position = 4;
                ofR = 0;
                ofL = 1;
            } else if (position == 2) {
                int[][] mask = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 1}, {0, 0, 0, 0}};
                this.setMask(mask);
                position = 1;
                ofR = 0;
                ofL = 2;
            } else if (position == 3) {
                int[][] mask = {{0, 0, 0, 0}, {0, 1, 1, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}};
                this.setMask(mask);
                position = 2;
                ofR = 0;
                ofL = 1;
            } else if (position == 4) {
                int[][] mask = {{0, 0, 0, 0}, {0, 0, 0, 1}, {0, 1, 1, 1}, {0, 0, 0, 0}};
                this.setMask(mask);
                position = 1;
                ofR = 0;
                ofL = 1;
            }
        }
    }

}
