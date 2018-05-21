package eu.webdude.dsa.crackingthecodinginterview.recursionanddp;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Position)) return false;
    Position position = (Position) o;
    return Objects.equals(row, position.row) &&
      Objects.equals(col, position.col);
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, col);
  }

  Position left() {
    return Position.of(row, col + 1);
  }

  Position down() {
    return Position.of(row + 1, col);
  }
}
