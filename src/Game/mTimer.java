package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mTimer implements ActionListener {

	public GameField newgame;
    public FigGenerator gen;
    public FigureControl cont;
    public int delay;

    public mTimer(GameField a, FigureControl b) {
        newgame = a;
        cont = b;
        gen = new FigGenerator(newgame);
    }

    /*
     * Действия которые будет выполнять таймер с заданной переодичностью
     * Проверяет есть ли на поле фигура, если нет, создает ее, иначе сдвигает вниз на 1
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (newgame.isgame) {
            if (newgame.getcurFig() == null) {
                gen.nextFigure();
            } else {
                cont.moveFigure();
            }
        }
    }

}
