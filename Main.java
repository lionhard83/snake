package snake;

import snake.SnakeGame.Move;

public class Main {
    public static void main(String args[]) {
        try {
            SnakeGame s = new SnakeGame(6, 6);
            System.out.println(s);
            s.move(Move.RIGHT);
            System.out.println(s);
            s.move(Move.LEFT);
            System.out.println(s);
            s.move(Move.TOP);
            System.out.println(s);
            s.move(Move.TOP);
            System.out.println(s);
        } catch (Exception err) {

        }
    }
}