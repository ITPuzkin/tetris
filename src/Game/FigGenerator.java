package Game;

import java.util.Random;

public class FigGenerator {
	
public GameField field;
    
    public FigGenerator(GameField a){
        this.field = a;
    }
    // создает случайну фигуры и выкидывает ее на поле
    public void nextFigure() {
        if (field.getcurFig() == null) {
            Random j = new Random();
            Figure cur = new Figure1();
            int k = j.nextInt(7);
            switch (k) {
                case 0: {
                    cur = new Figure1();
                    break;
                }
                case 1: {
                    cur = new Figure2();
                    break;
                }
                case 2: {
                    cur = new Figure3();
                    break;
                }
                case 3: {
                    cur = new Figure4();
                    break;
                }
                case 4: {
                    cur = new Figure5();
                    break;
                }
                case 5: {
                    cur = new Figure6();
                    break;
                }
                case 6: {
                    cur = new Figure7();
                    break;
                }
            }
            field.setstartPos(1, 6);//координаты фигуры на поле
            field.setCurFigure(cur);
        }
    }

}
