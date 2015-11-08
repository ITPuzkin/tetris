package Game;

public abstract class Figure {

	protected int FigMask[][];// размер поля 4х4
    protected int position; //1- изначальное
    protected int ofL,ofR; //смещение границы относительно фигуры
    
    public int[][] getMask()
    {
        return this.FigMask;
    }
    
    public int[] getOf(){  //получить смещения
        int bak[]=new int[2];
        bak[0]=ofR;bak[1]=ofL;
        return bak;
    }
    
    public void setMask(int a[][])
    {
        this.FigMask=a;
    }
    
    public abstract void Rotate(int a);
}
