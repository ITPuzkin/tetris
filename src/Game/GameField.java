package Game;

public class GameField {
	
	
	private int gameField[][]; //матрица игрового поля
    private int curPos[]; //текущая позиция фигуры
    private Figure curFigure;//текущая фигура
    private int fieldsize[];//размеры поля
    public boolean isgame; //статус игры
    private int curPoint; //текущие очки игрока
    private int speed;//скорость игры

    public GameField() {
        speed = 1000;
        curPoint = 0;
        isgame = true;
        fieldsize = new int[2];
        fieldsize[0] = 25;
        fieldsize[1] = 16;
        gameField = new int[fieldsize[0]][fieldsize[1]];
        curPos = new int[2];
        curFigure = null;
        for (int i = 0; i < fieldsize[0]; i++) {// заполняем все поле 0
            for (int j = 0; j < fieldsize[1]; j++) {
                gameField[i][j] = 0;
            }
        }
        for (int i = 0; i < fieldsize[0]; i++) { // левая стенка
            for (int j = 0; j < 3; j++) {
                gameField[i][j] = 3;
            }
        }
        for (int i = 0; i < fieldsize[0]; i++) { // правая стенка
            gameField[i][fieldsize[1] - 1] = 3;
            gameField[i][fieldsize[1] - 2] = 3;
            gameField[i][fieldsize[1] - 3] = 3;
        }
        for (int j = 0; j < fieldsize[1]; j++) { // пол
            gameField[fieldsize[0] - 1][j] = 3;
            gameField[fieldsize[0] - 3][j] = 3;
            gameField[fieldsize[0] - 2][j] = 3;
        }
    }
    
        //вызывается при столкновении фигуры с дном или уже упавшими фигурами
    public void addtoField() {
        gameField = this.getCurField();
        for (int i = 0; i < fieldsize[0] - 1; i++) {
            for (int j = 0; j < fieldsize[1] - 1; j++) {
                if (gameField[i][j] == 1) {
                    gameField[i][j] = 2;
                }
            }
        }
        this.rowCheck();
        if (this.gameover()) {
            isgame = false;
        }
    }

    //проверка на окончание игры
    public boolean gameover() {
        for (int i = 2; i < 12; i++) {
            if (gameField[2][i] == 2) {
                return true;
            }
        }
        return false;
    }
    
    public int max(int a, int b) {
        return ((a) > (b)) ? (a) : (b);
    }

    //возвращает текущее состояние игрового поля
    public int[][] getCurField() {
        int[][] ttt = this.getGameField();
        int[][] curfield = new int[fieldsize[0]][fieldsize[1]];
        for (int i = 0; i < fieldsize[0]; i++) {//копируем масивы
            System.arraycopy(ttt[i], 0, curfield[i], 0, fieldsize[1]);
        }
        if (curFigure != null) {
            for (int i = curPos[0]; i < curPos[0] + 4; i++) {
                for (int j = curPos[1]; j < curPos[1] + 4; j++) {
                    curfield[i][j] = max(curFigure.getMask()[i - curPos[0]][j - curPos[1]], curfield[i][j]);
                }
            }
        } else {
            return curfield;
        }
        return curfield;
    }
    
    public boolean pointCheck() {
        if (this.curPoint % 100 == 0) {
            return true;
        }
        return false;
    }

    public void offD() {
        this.curPos[0] += 1;
    }

    public void offR() {
        this.curPos[1] += 1;
    }

    public void offL() {
        this.curPos[1] -= 1;
    }
    
    //проверяет и если есть удаляет заполненые строки
    public void rowCheck() {
        int count = 0;
        for (int i = fieldsize[0] - 2; i >= 0; i--) {
            for (int j = 3; j < fieldsize[1] - 3; j++) {
                if (gameField[i][j] == 2) {
                    count++;
                }
            }
            if (count == 10) {
                for (int k = i; k > 0; k--) {
                    gameField[k] = gameField[k - 1];
                }
                i++;
                curPoint+=10;
                if (pointCheck()) {
                    if (this.speed > 100) {
                        this.speed -= 100;
                    }
                }
            }
            count = 0;
        }
    }
	// гетерры сеттеры
    public Figure getcurFig() {
        return this.curFigure;
    }

    public int[] getFieldSize() {
        return this.fieldsize;
    }

    public int[][] getGameField() {
        return this.gameField;
    }

    public void setCurFigure(Figure a) {
        this.curFigure = a;
    }

    public void setPos(int a) {
        this.curPos[0] += a;
    }

    public GameField getGF() {
        return this;
    }

    public int getPoint() {
        return this.curPoint;
    }

    public int getSpeed() {
        return this.speed;
    }
    
    public int[] getPos() {
        return this.curPos;
    }

    public void setstartPos(int a, int b) {
        this.curPos[0] = a;
        this.curPos[1] = b;
    }

}
