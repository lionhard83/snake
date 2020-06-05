package snake;

import java.util.LinkedList;

public class SnakeGame {
    enum Move {TOP, BOTTOM, LEFT, RIGHT};
    enum Status {IN_GAME, LOSE, WIN};
    int[][] grid;
    private Move forbiddenMove = Move.LEFT;
    private Status currentStatus = Status.IN_GAME;
    LinkedList<Coord> snake = new LinkedList<>();
    private int m;
    private int n;
    public SnakeGame(int n, int m) throws Exception {
        if (n < 5 || m < 5) {
            throw new Exception("grid too small");
        }
        this.n = n;
        this.m = m;
        this.grid = new int[n][m];
        snake.add(new Coord(1, 1));
        snake.addFirst(new Coord(1, 2));
    }
    public void move(Move m) {
        if (m == this.forbiddenMove) return;
        Coord head = this.snake.getFirst();
        if (m == Move.RIGHT) {
            if (head.getY()+ 1 > this.m) {
                this.currentStatus = Status.LOSE;
                return;
            }
            this.snake.addFirst(new Coord(head.getX(), head.getY()+ 1));
            this.forbiddenMove = Move.LEFT;
        } else if (m == Move.LEFT) {
            if (head.getY()- 1 < 0) {
                this.currentStatus = Status.LOSE;
                return;
            }
            this.snake.addFirst(new Coord(head.getX(), head.getY()- 1));
            this.forbiddenMove = Move.RIGHT;
        } else if (m == Move.TOP) { 
            if (head.getX()- 1 < 0) {
                this.currentStatus = Status.LOSE;
                return;
            }
            this.snake.addFirst(new Coord(head.getX() - 1, head.getY()));
            this.forbiddenMove = Move.BOTTOM;
        } else if (m == Move.BOTTOM) {
            if (head.getX()+ 1 > this.n) {
                this.currentStatus = Status.LOSE;
                return;
            }
            this.snake.addFirst(new Coord(head.getX() + 1, head.getY()));
            this.forbiddenMove = Move.TOP;
        } 
        this.snake.removeLast();
    }
    public String toString() {
        String result =  this.currentStatus + "\n";
        for (int x = 0; x < this.grid.length; x++) {
            result += "[";
            for (int y = 0; y <this.grid[x].length; y++) {
                if (this.snake.contains(new Coord(x, y))) {
                    result += "[-,-]";
                } else {
                    result += "[" + x +"," + y +"]";
                }
                
            }
            result += "]\n";
        }
        return result;
    }
    
}