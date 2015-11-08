package Game;

public class Figure1 extends Figure {

	public Figure1(){
        int mask[][] = {{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
        this.setMask(mask); 
        position = 1;
        ofR=ofL=1;
    }

    @Override
    public void Rotate(int a) { 
    }
}
