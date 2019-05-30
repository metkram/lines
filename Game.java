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

class Game {
  static int  randomNumber(int number) {
    int i = (int) (Math.random() * number);
    return i;
  }

  static Cube[][] createGameMatrix() {
    Cube matrix[][] = new Cube[5][5];

    for(int i = 0; i < 5; i++) {
      for(int u = 0; u < 5; u++) {
        matrix[i][u] = new Cube(randomNumber(4));
      }
    }

    return matrix;
  }

  static Cube[][] gameMatrix = createGameMatrix();

  public static void main(String[] args) {
    System.out.println("Hey yo, it's not a game. I'm simply trying to create OOP application" + randomNumber(3));

    for(int i = 0; i < gameMatrix.length; i++) {
      for(int u = 0; u < gameMatrix[i].length; u++) {
        System.out.print(gameMatrix[i][u].value + " ");
      }
      System.out.println();
    }
  }
}
