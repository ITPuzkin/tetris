package Game;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.Timer;

import com.google.gson.Gson;

/**
 * Servlet implementation class Game
 */
@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Game() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession ses = request.getSession(true);
        
        if ((GameField) ses.getAttribute("field") == null) { //если сессия новая, создаем все необходимое и сохраняем в ней
            ses.setAttribute("ID", ses.getId());
            GameField newgame = new GameField();
            FigureControl cont = new FigureControl(newgame);
            mTimer secondThread = new mTimer(newgame, cont);
            Timer time = new Timer(1000, secondThread);
            time.start();
            int[][] ff = newgame.getCurField();
            
            ses.setAttribute("field", newgame);
            ses.setAttribute("control", cont);
            ses.setAttribute("thread", secondThread);
            ses.setAttribute("mas", ff);
            ses.setAttribute("time", time);
        }
        //достаем из сессии все необходимое
        FigureControl cont = (FigureControl) ses.getAttribute("control");
        GameField newgame = (GameField) ses.getAttribute("field");
        Timer time = (Timer) ses.getAttribute("time");
        
        Gson jj = new Gson(); //объект GSON для передачи масива в виде JSON
        PrintWriter wr = response.getWriter();
        response.setContentType("application/json");//установка типа данных в ответе
        
        if ("stg".equals(request.getParameter("a"))) {//при нажатии кгопки Start
            if (!time.isRunning()) {
                time.start();
            }
        }
        else if ("a".equals(request.getParameter("a"))) {//нажатие клавиши <-
            if (time.isRunning()) {
                if (!cont.moveL()) {
                    System.out.println("eror move left!");
                }
            }
        } else if ("b".equals(request.getParameter("a"))) {//нажатие клавиши ->
            if (time.isRunning()) {
                if (!cont.moveR()) {
                    System.out.println("eror move right!");
                }
            }
        } else if ("c".equals(request.getParameter("a"))) {//нажатие клавиши вниз 
            if (time.isRunning()) {
                cont.dropFigure();
            }
        } else if ("r".equals(request.getParameter("a"))) {//нажатие клавиши вверх
            if (time.isRunning()) {
                if (!cont.rotR()) {
                    System.out.println("eror rotate!");           
                }
            }
        } else if ("ex".equals(request.getParameter("a"))) {//нажатие кнопки Pause
            time.stop();
            return;
        } else if ("ng".equals(request.getParameter("a"))) {//нажатие кнопки NewGame
            ses.invalidate(); // отсоеденение всего от сесси 
            return;
        }
        //если игра идет, отправляем состояние поля
        if (time.isRunning()) {
            ses.setAttribute("mas", newgame.getCurField());
            int[][] ff = (int[][]) ses.getAttribute("mas");
            ff[24][0] = newgame.getPoint();//сюда пишем количество очков
            if(newgame.isgame){
                ff[24][1]=1;}
            else{
                ff[24][1]=0;
            }
            // преобразуем масив в json и пишем в выходной поток
            wr.println(jj.toJson(ff));
            if (newgame.pointCheck()) { //проверка количества очков
                time.setDelay(newgame.getSpeed());
            }
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
