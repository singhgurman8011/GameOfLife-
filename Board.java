import java.util.ArrayList;
import java.awt.Point;

public class Board {
  private int width, height;
  private ArrayList<Point> liveCells;
    
  public Board(int width, int height) {
    this.width = width;
    this.height = height;
    this.liveCells = new ArrayList<>();
  }

  public void clear() {
    liveCells.clear();
  }

  public boolean getCell(int x, int y) {
    Point p = new Point(x,y);

    if(liveCells.contains(p)){
      return true;
    }
    else{
      return false;
    }
  }

  public void makeCellLive(int x, int y) {
    Point p = new Point(x,y);
    if(liveCells.contains(p)==false){
      liveCells.add(p);
    }
  }

  public ArrayList<Point>  getLiveCells(){     
    ArrayList<Point> copy = new ArrayList<>();
    for (Point p :liveCells){
      copy.add(new Point(p));
    }
    return copy;
  }
}
