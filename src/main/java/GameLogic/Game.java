package GameLogic;

import ChessPieces.*;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.*;
import java.util.List;

/**
 * Главный класс нашей игры. Он инкапсулирует данные состояния игры, а также предоставляет методы для работы с этими данными и их изменением. Согласно объекту
 * этого класса создается
 */
public class Game implements Serializable {


    /**
     * Map-контейнер, который хранит в себе состояние полей на шахматной доске. Ключом данного словаря является координата поля, а значением является объект фигуры
     * (если клетка свободна - null);
     */

    private Map<String, ChessPiece> chessPiece;


    /**
     * В chessFieldForWhite отображены координаты полей на объекты кнопок, которые имеют данные координаты, на доске при игре за белых.
     */
    transient private Map<String, JButton> chessFieldsForWhite;


    /**
     * В chessFieldForBlack отображены координаты полей на объекты кнопок, которые имеют данные координаты, на доске при игре за черных.
     */
    transient private Map<String, JButton> chessFieldsForBlack;


    /**
     * Хранит цвет фигур, которые ходят в данный момент.
     */
    private Color activeColor;


    private static Game game;


    private boolean mustBeReversed;

    private String whiteKingCoordinate;
    private String blackKingCoordinate;

    private List<List<String>> moves;
    private int moveCounter = 0;


    /**
     * Конструктор инициализирующий объект Game. В нем инициализируются поля chessPiece, chessField, active. Здесь мы реализуем паттерн Singleton, так как
     * объект игры должен быть один на все программу. При завершении игры мы будем удалять данный объект с помощью метода this.end().
     */
    private Game(Color color,boolean mustBeReversed){
        this.chessPiece = new HashMap<>(ArrangementOfPieces.defaultGame);
        this.activeColor = color;
        this.chessFieldsForWhite = new HashMap<>();
        this.chessFieldsForBlack = new HashMap<>();
        this.mustBeReversed = mustBeReversed;
        this.moves = new ArrayList<>();
    }

    /**
     * Перегруженный конструктор, дополнительно задает поле chessPiece.
     */
    private Game(Color color, Map<String,ChessPiece> arrangementOfPieces){
        this.chessPiece = arrangementOfPieces;
        activeColor = color;
        chessFieldsForWhite = new HashMap<>();
        chessFieldsForBlack = new HashMap<>();
        mustBeReversed = true;
        this.moves = new ArrayList<>();
    }


    /**
     * Инициализирует новую игру (только в том случае, если предыдущая игра была завершена и переменная game очищена).
     */
    public static void initGame(Color activeColor,boolean mustBeReversed){
        if (game==null) game=new Game(activeColor,mustBeReversed);
    }

    /**
     * Перегруженный метод.
     */
    public static void initGame(Color activeColor,Map<String,ChessPiece> arrangementOfPieces){
        if (game==null) game=new Game(activeColor,arrangementOfPieces);
    }



    /**
     * Возвращает объект игры. Если переменная game еще не инициализирована, то вызывается конструктор;
     */
    public static Game getGame(){
        return game;
    }


    /**
     * После завершения игры очищает объект игры;
     */
    public static void gameOver(){
        game = null;
    }

    /**
     * Возвращает объект фигуры, расположенной по координате coordinate.
     */
    public ChessPiece getChessPiece(String coordinate){
        return chessPiece.get(coordinate);
    }


    /**
     * Изменяет словарь chessPieces (отслеживает перемещение фигур по доске и заносит данные в словарь).
     */
    public void makeMove(String coordinate1,String coordinate2){
        chessPiece.put(coordinate2,chessPiece.get(coordinate1));
        this.addMove(coordinate1,coordinate2);
        if (getKingCoordinate(Color.WHITE).equals(coordinate1)) setKingCoordinate(Color.WHITE,coordinate2);
        if (getKingCoordinate(Color.BLACK).equals(coordinate1)) setKingCoordinate(Color.BLACK,coordinate2);
        Icon icon = game.getChessPiece(coordinate1).getFigureIcon();
        game.getChessField(Color.WHITE,coordinate1).setIcon(null);
        game.getChessField(Color.BLACK,coordinate1).setIcon(null);
        game.getChessField(Color.BLACK,coordinate2).setIcon(icon);
        game.getChessField(Color.WHITE,coordinate2).setIcon(icon);
        this.removeChessPiece(coordinate1);
    }

    /**
     * Проверяет наличие фигуры, расположенной по координате (coordinate).
     */
    public  boolean isFilled(String coordinate){
        return chessPiece.get(coordinate)!=null?true:false;
    }


    /**
     * Возвращает цвет фигур, которые ходят в данный момент.
     */
    public Color getActiveColor(){
        return activeColor;
    }

    public Color getNoActiveColor(){return activeColor.equals(Color.WHITE)?Color.BLACK:Color.WHITE;}


    /**
     * Задает цвет фигур, которые ходят в данный момент.
     */
    void changeActiveColor(){
        if (activeColor==Color.WHITE){
            activeColor=Color.BLACK;
        }else activeColor=Color.WHITE;
    }


    /**
     * Проверяет, будет ли король находится под ударом после хода с координаты coordinate1 на координату coordinate2.
     * Если фигура после хода ставит под угрозу своего короля, то возвращается false. Если фигура ставит под угрозу
     * чужого короля, но при этом ее король останется под угрозой, то возвращается false. Если фигура ставит под угрозу
     * чужого короля, в то время как союзному королю ничто не угрожает, то возвращается true.
     */
    public boolean isCheck(String coordinate1,String coordinate2){
        return true;
    }


    /**
     * Возвращает поле chessField.
     */
    public Map<String,JButton> getChessFields(Color color){
        if (Color.BLACK.equals(color)) return chessFieldsForBlack;
        return chessFieldsForWhite;
    }


    /**
     * Возвращает объект кнопки, которая имеет координату coordinate.
     */
    public JButton getChessField(Color color,String coordinate){
        if (Color.BLACK.equals(color)) return chessFieldsForBlack.get(coordinate);
        return chessFieldsForWhite.get(coordinate);
    }


    /**
     * Регистрирует кнопку с ее координатой.
     */
    public void setChessFields(String key,JButton value, Color color){
        if (Color.BLACK.equals(color)){
            chessFieldsForBlack.put(key,value);
            return;
        }
        chessFieldsForWhite.put(key,value);
    }

    public void addMove(String coordinate1, String coordinate2){
        moves.add(List.of(coordinate1,coordinate2));
    }

    public List<String> getPreviousMove(){
        return moves.get(moves.size()-1);
    }

    public boolean isMustBeReversed(){
        return mustBeReversed;
    }


    /**
     * Проверяет, может ли король уйти от угрозы. Возвращает false.Иначе
     */
    public boolean checkPat(Color color){
        for (Map.Entry<String,ChessPiece> map:new HashMap<>(chessPiece).entrySet()){
            if (map.getValue().getFigureColor().equals(color)) continue;
            for (char c='A';c<='H';c++){
                for (int i=1;i<=8;i++){
                    if (map.getValue().enableMakeMoved(map.getKey(),c+String.valueOf(i),game) && !map.getValue().checkThreat(map.getKey(),c+String.valueOf(i),game,color)) return false;
                }
            }
        }
        return true;
    }

    /**
     * Может ли соперник совершить ход. Если да то возвращается false. Иначе true (Игра заканчивается в ничью).
     */

    public void removeChessPiece(String s) {
        chessPiece.remove(s);
    }

    public Map<String,ChessPiece> getChessPieces() {
        return chessPiece;
    }

    public void setKingCoordinate(Color color, String coordinate){
        if (color==Color.WHITE) whiteKingCoordinate = coordinate;
        else blackKingCoordinate = coordinate;
    }
    public String getKingCoordinate(Color color){
        return color==Color.WHITE?whiteKingCoordinate:blackKingCoordinate;
    }

    public boolean movesIsEmpty(){return moves.isEmpty();}

    public void pawnPromotion(){

    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public void increaseMoveCounter() {
        this.moveCounter+=1;
    }
}
