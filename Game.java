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
      }
    }

    return matrix;
  }
}

class Game {

  static GameMatrix newGame = new GameMatrix();

  public static void main(String[] args) {
    System.out.println("Hey yo, it's not a game. I'm simply trying to create OOP application" + RandomNumber.newNumber(4));

    for(int i = 0; i < newGame.matrix.length; i++) {
      for(int u = 0; u < newGame.matrix[i].length; u++) {
        System.out.print(newGame.matrix[i][u].value + " ");
      }
      System.out.println();
    }
  }
}
