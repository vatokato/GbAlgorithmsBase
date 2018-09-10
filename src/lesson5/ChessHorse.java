package lesson5;

public class ChessHorse {
    static int sizeX;
    static int sizeY;
    static int[][] board;
    static int move;
    static long iter;

    static void init (int x, int y, int startX, int startY) {
        sizeX=x;
        sizeY=y;
        board = new int[sizeY][sizeX];
        move=0;
        iter=0;

        if( moveTo(startX, startY,1) ) {
            System.out.println("Победа с точки "+startX+" "+startY+":");
            System.out.println("Итераций: "+iter);
        }
        else {
            System.out.println("Поражение. Итераций: "+iter);
        }
        printBoard();
    }

    static boolean moveTo(int x, int y, int move) {
        iter++;
        if(checkBoard(x,y)) return false;
        board[y][x]=move;

//      System.out.println("move="+move+" , iter="+iter);
//      printBoard();
//      System.out.println();

        if( gameIsEnd() ) return true;

        move++;
        //влево вниз
        if(moveTo(x-2,y+1, move)) return true;
        //влево вверх
        if(moveTo(x-2,y-1, move))  return true;

        //вниз влево
        if(moveTo(x-1,y+2, move))  return true;
        //вверх влево
        if(moveTo(x-1,y-2, move)) return true;

        //вверх вправо
        if(moveTo(x+1,y-2, move)) return true;
        //вниз вправо
        if(moveTo(x+1,y+2, move)) return true;

        // вправо вверх
        if(moveTo(x+2,y-1, move))  return true;
        // вправо вниз
        if(moveTo(x+2,y+1, move)) return true;

        board[y][x]=0;
        return false;
    }

    static boolean checkBoard(int x, int y) {
        if(x<0 || x>=sizeX || y<0 || y>=sizeY) return true;
        return board[y][x]!=0;
    }

    static boolean gameIsEnd() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if(board[i][j]==0) return false;
            }
        }
        return true;
    }

    static void printBoard() {
        int r;
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                r=board[i][j];
                System.out.print((r < 10 ? "0"+r : r) + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        init(8, 8, 0, 0);
    }
}
