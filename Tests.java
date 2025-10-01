import java.util.ArrayList;
import java.awt.Point;

public class Tests {
  public static void testBoard() {
    System.out.println("BOARD TESTS");
    Board board = new Board(100,100);
    board.makeCellLive(1,2);
    boolean testsPassed = testCell(board,1,2,true);
    testsPassed = testsPassed && testCell(board,2,3,false);
    if (testsPassed) {
      System.out.println("BOARD: ALL TESTS PASSED");
    }
    else {
      System.out.println("BOARD: SOME TESTS FAILED!!!");
    }
  }
  private static boolean testCell(Board board,int x, int y, boolean expected) {
    boolean actual = board.getCell(x,y);
    boolean passed = actual == expected;
    System.out.println("Cell at " + x + "," + y + ". Live = " + actual + ". Passed = " + passed);
    return passed;
  }

  public static void testGame() {
    System.out.println("GAME TESTS");
    Game game = new Game(100,100);
    //Create a horizontal blinker
    game.makeCellLive(6,6);
    game.makeCellLive(7,6);
    game.makeCellLive(8,6);

    //Now create the next generation
    game.newGeneration();

    //Now check our horizontal blinker has turned into a vertical one
    ArrayList<Point> actual = game.getLiveCells();
    boolean passed = actual.size() == 3 && contains(actual,7,5) && contains(actual,7,6) && contains(actual,7,7);
    System.out.print("Live cells in second generation:");
    printCells(actual);
    System.out.println();
    if (passed) {
      System.out.println("GAME: TEST PASSED");
    }
    else {
      System.out.println("GAME: TEST FAILED");
    }
  }

  private static boolean contains(ArrayList<Point> points, int x, int y) {
    Point testPoint = new Point(x,y);
    return points.contains(testPoint);
  }  

  private static void printCells(ArrayList<Point> points) {
    for (Point point:points) {
      System.out.print(" (" + point.x + "," + point.y + ")");
    }

  }
}
