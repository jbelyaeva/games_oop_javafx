package ru.job4j.chess.firuges.black;

import static org.hamcrest.core.Is.is;
import static ru.job4j.chess.firuges.Cell.A6;

import junit.framework.TestCase;
import org.junit.Assert;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest extends TestCase {

  public void testPosition() {
    BishopBlack bishopBlack = new BishopBlack(A6);
    bishopBlack.position();
    Assert.assertThat(bishopBlack.position(), is(A6));
  }

  public void testWay() throws ImpossibleMoveException {
    BishopBlack bishopBlack = new BishopBlack(Cell.C1);
    bishopBlack.way(Cell.G5);
    Cell[] cells = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
    Assert.assertThat(bishopBlack.way(Cell.G5), is(cells));
  }

  public void testIsDiagonalTrue() {
    BishopBlack bishopBlack = new BishopBlack(Cell.C1);
    Assert.assertThat( bishopBlack.isDiagonal(Cell.C1,Cell.G5), is(true));
  }

  public void testIsDiagonalFalse() {
    BishopBlack bishopBlack = new BishopBlack(Cell.C1);
    Assert.assertThat( bishopBlack.isDiagonal(Cell.C1,Cell.G8), is(false));
  }

  public void testCopy() {
    BishopBlack bishopBlack = new BishopBlack(A6);
    Figure bishopBlackNew = bishopBlack.copy(A6);
    Assert.assertThat(bishopBlackNew.position(), is(A6));
  }

  public void testDiagonalC1G6Exeption(){
    BishopBlack bishopBlack = new BishopBlack(Cell.C1);
    try {
      bishopBlack.way(Cell.G6);
      Assert.fail("Expected ImpossibleMoveException");
    } catch (ImpossibleMoveException thrown) {
      Assert.assertNotEquals("", thrown.getMessage());
    }
  }
}