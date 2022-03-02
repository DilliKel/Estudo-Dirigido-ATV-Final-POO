import java.util.Stack;

public class RatInMaze extends Thread {
  private static final int N = 9;
  private static final int M = 33;
  private String name;
  private static int maze[][];

  int n = N, m = M;

  private boolean[][] visited = new boolean[N][M];

  public RatInMaze(String name, int maze[][]) {
    this.name = name;
    this.maze = maze;
  }

  public static void main(String[] args) {
    // setVisited(true);

    // if (isReachable(maze)) {
    // System.out.println("Path Found!\n");
    // } else
    // System.out.println("No Path Found!\n");
  }

  public void transformMaze() {
    for (int i = 0; i < RatInMaze.maze.length; i++) {
      for (int j = 0; j < RatInMaze.maze[i].length; j++) {
        if (RatInMaze.maze[i][j] == 42) { // *
          RatInMaze.maze[i][j] = 0;
        }
        if (RatInMaze.maze[i][j] == 69) { // E
          RatInMaze.maze[i][j] = 1;
        }
        if (RatInMaze.maze[i][j] == 64) { // @
          RatInMaze.maze[i][j] = 1;
        }
        if (RatInMaze.maze[i][j] == 83) { // S
          RatInMaze.maze[i][j] = 1;
        }
      }
    }
  }

  @Override
  public void run() {
    transformMaze();
    setVisited(true, visited);
    if (isReachable(maze, name, visited)) {
      System.out.printf("\n%s chegou primeiro!\n", name);
      System.exit(0);
    }
    ;
  }

  private static void setVisited(boolean b, boolean[][] visited) {
    for (int i = 0; i < visited.length; i++) {
      for (int j = 0; j < visited[i].length; j++) {
        visited[i][j] = b;
      }
    }
  }

  private static boolean isReachable(int maze[][], String ratName, boolean[][] visited) {
    // Posição do inicio(linha, coluna)
    int i = 0, j = 1;

    // posição do final(linha, coluna)
    int fx, fy;
    fx = 8;
    fy = 26;

    Stack<Node> s = new Stack<Node>();

    Node temp = new Node(i, j);

    s.push(temp);

    while (!s.empty()) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      temp = s.peek();
      int d = temp.getDirRandom();
      i = temp.getX();
      j = temp.getY();

      temp.removeAttempt(d);
      s.pop();
      s.push(temp);

      // Se conseguir chegar
      if (i == fx && j == fy) {
        return true;
      }

      if (d == 0) {
        // Checking the Up direction.
        if (i - 1 >= 0 && maze[i - 1][j] == 1 &&
            visited[i - 1][j]) {
          Node temp1 = new Node(i - 1, j);
          visited[i - 1][j] = false;
          s.push(temp1);
          System.out.printf("\n%s foi para cima\n", ratName);
        } else {
          // System.out.printf("\n%s: tentou ir para cima\n", ratName);
        }
      } else if (d == 1) {
        // Checking the left direction
        if (j - 1 >= 0 && maze[i][j - 1] == 1 &&
            visited[i][j - 1]) {
          Node temp1 = new Node(i, j - 1);
          visited[i][j - 1] = false;
          s.push(temp1);
          System.out.printf("\n%s foi para esquerda\n", ratName);
        } else {
          // System.out.printf("\n%s: tentou ir para esquerda\n", ratName);
        }
      } else if (d == 2) {
        // Checking the down direction
        if (i + 1 < N && maze[i + 1][j] == 1 &&
            visited[i + 1][j]) {
          Node temp1 = new Node(i + 1, j);
          visited[i + 1][j] = false;
          s.push(temp1);
          System.out.printf("\n%s para baixo\n", ratName);
        } else {
          // System.out.printf("\n%s: tentou ir para baixo\n", ratName);
        }
      } else if (d == 3) {
        // Checking the right direction
        if (j + 1 < M && maze[i][j + 1] == 1 &&
            visited[i][j + 1]) {
          Node temp1 = new Node(i, j + 1);
          visited[i][j + 1] = false;
          s.push(temp1);
          System.out.printf("\n%s para direita\n", ratName);
        } else {
          // System.out.printf("\n%s: tentou ir para direita\n", ratName);
        }
      }

      // Retract back(voltar)
      else {
        visited[temp.getX()][temp.getY()] = true;
        s.pop();
        System.out.printf("\n%s: voltou\n", ratName);
      }
    }

    // nenhum caminho encontrado
    return false;
  }
}