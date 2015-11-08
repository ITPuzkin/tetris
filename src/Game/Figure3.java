package Game;

public class Figure3 extends Figure {

	public Figure3()
    {
        int[][] mask = {{0,0,0,0},{0,1,1,0},{0,0,1,1},{0,0,0,0}};
        this.setMask(mask);
        position = 1;
        ofR=0;
        ofL=1;
    }

    @Override
    public void Rotate(int a) {
        if (position==1){
            int[][] mask = {{0,0,1,0},{0,1,1,0},{0,1,0,0},{0,0,0,0}};
            this.setMask(mask);
            position = 2;
            ofR =1;
            ofL =1;
        }
        else{
            int[][] mask = {{0,0,0,0},{0,1,1,0},{0,0,1,1},{0,0,0,0}};
            this.setMask(mask);
            position = 1;
            ofR =0;
            ofL =1;
        }
    }

}
