import java.util.Scanner;

class Cube {
  String name;
  int value;

  Cube(int number) { //I have to add this comment 'cause git cannot see any changes
    value = number;
    switch(number) {
      case(0):
        name = "Zero";
        break;
      case(1):
        name = "One";
        break;
      case(2):
        name = "Two";
        break;
      case(3):
        name = "Three";
        break;
      case(4):
        name = "Four";
        break;
    }
  }
}

class ZeroCube extends Cube {
  ZeroCube(Integer n){
    super(n);
  }
}

class RandomNumber { // This class returns random number from 0 to "your wish"
  static int newNumber(int number) {
    int i = (int) (Math.random() * number);
    return i;
  }
}

class GameMatrix { // This class creares new game matrix and manupulates it
  Cube[][] matrix;
  Cube[][] tempMatrix = new Cube[5][5];
  Integer[] temp1 = new Integer[2];
  Integer[] temp2 = new Integer[2];
  GameMatrix() {
    matrix = createGameMatrix();
  }

  Cube[][] createGameMatrix() {
    Cube matrix[][] = new Cube[5][5];

    for(int i = 0; i < 5; i++) {
      for(int u = 0; u < 5; u++) {
        if(u == 0) {
          matrix[i][u] = new ZeroCube(0);
        } else {
          matrix[i][u] = new Cube(RandomNumber.newNumber(4));
        }
        tempMatrix[i][u] = new Cube(0);
      }
    }
    return matrix;
  }
  void step() {
    for(int i = 0; i < 5; i++) {
      for(int u = 0; u < 5; u++) {
        tempMatrix[i][u] = matrix[i][u];
      }
    }
    tempMatrix[temp1[0]][temp1[1]] = matrix[temp2[0]][temp2[1]];
    tempMatrix[temp2[0]][temp2[1]] = matrix[temp1[0]][temp1[1]];
    for(int i = 0; i < 5; i++) {
      for(int u = 0; u < 5; u++) {
        matrix[i][u] = tempMatrix[i][u];
      }
    }
  }
}

class Game {
  static Scanner in = new Scanner(System.in);
  static GameMatrix newGame = new GameMatrix();

  public static void main(String[] args) {
    System.out.println("Hey yo, it's not a game. I'm simply trying to create OOP application" + RandomNumber.newNumber(4));
    for(int i = 0; i < newGame.matrix.length; i++) {
      for(int u = 0; u < newGame.matrix[i].length; u++) {
        System.out.print(newGame.matrix[i][u].value + " ");
      }
      System.out.println();
    }
    System.out.print("Line #: ");
    newGame.temp1[0] = in.nextInt();
    System.out.print("Column #: ");
    newGame.temp1[1] = in.nextInt();
    System.out.print("Line2 #: ");
    newGame.temp2[0] = in.nextInt();
    System.out.print("Column2 #: ");
    newGame.temp2[1] = in.nextInt();
    System.out.println(newGame.temp1[0] + " " + newGame.temp1[1]);
    System.out.println(newGame.temp2[0] + " " + newGame.temp2[1]);
    newGame.step();
    for(int i = 0; i < newGame.matrix.length; i++) {
      for(int u = 0; u < newGame.matrix[i].length; u++) {
        System.out.print(newGame.matrix[i][u].value + " ");
      }
      System.out.println();
    }
  }
}
