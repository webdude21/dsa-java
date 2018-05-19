package eu.webdude.dsa.crackingthecodinginterview;

class Position {

  final Integer row;

  final Integer col;

  private Position(Integer row, Integer col) {
    this.row = row;
    this.col = col;
  }

  static Position of(Integer row, Integer col) {
    return new Position(row, col);
  }

  Position left() {
    return Position.of(row, col + 1);
  }

  Position down() {
    return Position.of(row + 1, col);
  }
}
