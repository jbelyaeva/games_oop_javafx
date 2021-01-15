package ru.job4j.chess;

import java.util.Arrays;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public final class Logic {
  private final Figure[] figures = new Figure[32];
  private int index = 0;

  public void add(Figure figure) {
    figures[index++] = figure;
  }

  public void move(Cell source, Cell dest)
      throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
    int index = findBy(source);
    Cell[] steps = figures[index].way(dest);
    if (!free(steps)) {
      throw new OccupiedCellException("String can not be empty!");
    }
    figures[index] = figures[index].copy(dest);
  }

  private boolean free(Cell[] steps) throws OccupiedCellException {
    for (int i = 0; i < figures.length; i++) {
      if (figures[i] != null) {
        for (int j = 0; j < steps.length; j++) {
          if (figures[i].position() == steps[j]) {
            throw new OccupiedCellException("String can not be empty!");
          }
        }
      }
    }
    return true;
  }

  public void clean() {
    Arrays.fill(figures, null);
    index = 0;
  }

  private int findBy(Cell cell) throws FigureNotFoundException {
    for (int index = 0; index != figures.length; index++) {
      Figure figure = figures[index];
      if (figure != null && figure.position().equals(cell)) {
        return index;
      }
    }
    throw new FigureNotFoundException();
  }
}
