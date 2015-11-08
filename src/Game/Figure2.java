package Game;

public class Figure2 extends Figure {

	public Figure2()
    {
        int[][] mask = {{0,0,0,0},{0,0,0,0},{1,1,1,1},{0,0,0,0}};
        this.setMask(mask);
        position = 1;
        ofL=ofR=0;
    }

    @Override
    public void Rotate(int a) {
        if (position==1){
            int[][] mask = {{0,0,1,0},{0,0,1,0},{0,0,1,0},{0,0,1,0}};
            this.setMask(mask);
            position = 2;
            ofL=2;ofR=1;
        }
        else{
            int[][] mask = {{0,0,0,0},{0,0,0,0},{1,1,1,1},{0,0,0,0}};
            this.setMask(mask);
            position = 1;
            ofL=ofR=0;
        }
    }

}
