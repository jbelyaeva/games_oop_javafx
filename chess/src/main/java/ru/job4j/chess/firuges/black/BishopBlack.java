package ru.job4j.chess.firuges.black;

import static java.lang.Math.abs;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
  private final Cell position;

  public BishopBlack(final Cell ps) {
    position = ps;
  }

  @Override
  public Cell position() {
    return position;
  }

  @Override
  public Cell[] way(Cell dest) throws ImpossibleMoveException {
    if (!isDiagonal(position, dest)) {
      throw new ImpossibleMoveException(
          String.format("Could not move by diagonal from %s to %s", position, dest)
      );
    }
    int size = abs(position().getX() - dest.getX());
    Cell[] steps = new Cell[size];
    int deltaX = dest.getX() - position().getX();
    int deltaY = dest.getY() - position().getY();
    for (int index = 1; index <= size; index++) {
        steps[index - 1] =
            Cell.findBy(
                position().getX() + deltaX / size * index,
                position().getY() + deltaY / size * index);
    }
    return steps;
  }

  public boolean isDiagonal(Cell source, Cell dest) {
    int deltaX = dest.getX() - source.getX();
    int deltaY = dest.getY() - source.getY();
    return abs(deltaX) == abs(deltaY);
  }

  @Override
  public Figure copy(Cell dest) {
    return new BishopBlack(dest);
  }
}
