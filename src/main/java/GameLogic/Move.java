package GameLogic;

import javax.swing.*;
import java.util.Arrays;


/**
 * Класс Move инкапсулирует информацию о ходе фигуры. Реализует паттерн Singleton.
 */
public class Move {

    /**
     * arrayOfChooseButton - массив из двух элементов, который хранит в себе начальное поле выбранной фигуры и поле назначения.
     */
    private JButton[] arrayOfChooseButton;


    /**
     * Конструктор Move() инициализирует массив arrayOfChooseButton.
     */
    private Move(){
        arrayOfChooseButton = new JButton[2];
    }


    /**
     * Хранит единственный объект хода на всю игру.
     */
    private static Move move = new Move();


    /**
     * Геттер для move. Для обращения к объекту хода вне данного класса.
     */
    public static Move getMoveObject(){
        return move;
    }


    /**
     * Добавляет выбранное поле в массив arrayOfChooseButton.
     */
    public void addButton(JButton button){
        if (arrayOfChooseButton[0]==null) arrayOfChooseButton[0]=button;
        else arrayOfChooseButton[1]=button;
    }


    /**
     * Проверяет, заполнен ли массив arrayOfChooseButton.
     */
    public boolean isFilled(){
        return (arrayOfChooseButton[0]!=null && arrayOfChooseButton[1]!=null)?true:false;
    }


    /**
     * Метод clean() используется в следующих случаях:
     *  -после успешно завершенного хода;
     *  -при логической ошибке, если фигура не может пойти на заданное поле.
     *
     */
    public void clean(){
        Arrays.fill(arrayOfChooseButton,null);
    }


    /**
     * Возвращает значение ячейки массива arrayOfChooseButton.
     */
    public JButton[] getArrayOfChooseButton(){
        return arrayOfChooseButton;
    }
}
