package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.RookBlack;

public class LogicTest {

    @Test
    public void moveWithImpossibleMoveException() throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        Figure bishop = new BishopBlack(Cell.G8);
        Figure rook = new RookBlack(Cell.E7);
        logic.add(bishop);
        logic.add(rook);
        try {
            logic.move(Cell.G8, Cell.D6);
            Assert.fail("Expected ImpossibleMoveException");
        } catch (ImpossibleMoveException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void movePossible()
        throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bishop = new BishopBlack(Cell.F8);
        logic.add(bishop);
        logic.move(Cell.F8, Cell.D6);
    }

    @Test
    public void moveWithOccupiedCellException ()
        throws FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bishop = new BishopBlack(Cell.F8);
        Figure rook = new RookBlack(Cell.E7);
        logic.add(bishop);
        logic.add(rook);
        try {
            logic.move(Cell.F8, Cell.E7);
            Assert.fail("Expected OccupiedCellException");
        } catch (OccupiedCellException  thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void moveFigureNotFoundException()
        throws ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        Figure bishop = new BishopBlack(Cell.F8);
        Figure rook = new RookBlack(Cell.E7);
        logic.add(bishop);
        logic.add(rook);
        try {
            logic.move(Cell.A1, Cell.E7);
            Assert.fail("Expected FigureNotFoundException");
        } catch (FigureNotFoundException  thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }


}