import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
  private int x, y;
  private int dir;
  private List<Integer> tries;

  public Node(int i, int j) {
    this.x = i;
    this.y = j;
    this.tries= new ArrayList<>();

    this.tries.add(0);
    this.tries.add(1);
    this.tries.add(2);
    this.tries.add(3);

    // default value for direction set to 0 (Up)
    this.dir = 0;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setDir(int dir) {
    this.dir = dir;
  }

  public int getDirRandom() {
    if (tries.size() == 0) {
      return 4;
    } else {
      int index = (int)(Math.random() * tries.size());
      return tries.get(index);
    }
  }

  public void removeAttempt(int i) {
    tries.removeAll(Arrays.asList(i));
  }
}
