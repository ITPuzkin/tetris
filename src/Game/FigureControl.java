package Game;

public class FigureControl {

private GameField field;
    
    //констуктор
    public FigureControl(GameField a){
        this.field = a;
    }
    
    //проверка на возможность движения влево
    public boolean lcheck(){
        int[][] ttt=field.getCurField();
        for(int i=0;i<4;i++){
            for(int j=4;j>=0;j--){
                if(ttt[field.getPos()[0]+i][field.getPos()[1]+j-1]==1)
                {
                    if(ttt[field.getPos()[0]+i][field.getPos()[1]+j-2]>ttt[field.getPos()[0]+i][field.getPos()[1]+j-1])
                    {
                        return false;
                    }
                }
            }
        }
        return true;  
    }

    //проверка на возможность движения вправо
    public boolean rcheck(){
        int[][] ttt=field.getCurField();
        for(int i=0;i<4;i++){
            for(int j=0;j<=4;j++){
                if(ttt[field.getPos()[0]+i][field.getPos()[1]+j]==1)
                {
                    if(ttt[field.getPos()[0]+i][field.getPos()[1]+j+1]>ttt[field.getPos()[0]+i][field.getPos()[1]+j])
                    {
                        return false;
                    }
                }
            }
        }
        return true;  
    }
    
    //проверка движения вниз
    public boolean underCheck(){
        int[][] ttt=field.getCurField();
        for(int i=0;i<4;i++){
            for(int j=0;j<5;j++){
                if(ttt[field.getPos()[0]+i][field.getPos()[1]+j]==1)
                {
                    if(ttt[field.getPos()[0]+i+1][field.getPos()[1]+j]>ttt[field.getPos()[0]+i][field.getPos()[1]+j])
                    {
                        return false;
                    }
                }
            }
        }
        return true;              
    }
    
    //смещение фигуры на 1 вниз
    public boolean moveFigure(){
        if (field.getcurFig() != null) {
            if (this.underCheck()) {
                field.offD();
                return true;
            }
            field.addtoField();
            field.setCurFigure(null);
            return false;
        }
        return false;
    }
    
    //смещение фигуры влево
    public boolean moveL() {
        if (field.getcurFig() != null) {
            if (this.lcheck()) {
                field.offL();
                return true;
            }
            return false;
        }
        return false;
    }
    
    //смещение фигуры вправо
    public boolean moveR() {
        if (field.getcurFig() != null) {
            if (this.rcheck()) {
                field.offR();
                return true;
            }
            return false;
        }
        return false;
    }
    
    //поворот фигуры
    public boolean rotR() {
        if (field.getcurFig() != null) {
            field.getcurFig().Rotate(1);
            if (field.getPos()[1] + field.getcurFig().ofL > 2 && field.getPos()[1] + 3 - field.getcurFig().ofR < 13) {
                return true;
            } else {
                field.getcurFig().Rotate(0);
                return false;
            }
        }
        return false;
    }
    
    //уронить фигуру
    public void dropFigure(){
        while(this.moveFigure());
    }

}
