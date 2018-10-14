package ru.job4j.chess;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;


public class LogicTest {

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.move(Cell.A7, Cell.A6);
    }

    @Test(expected = OccupiedWayException.class)
    public void whenWayIsOccupied() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new PawnBlack(Cell.G7));
        logic.move(Cell.F8, Cell.H6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveIsImpossible() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.E7));
        logic.move(Cell.E7, Cell.A7);
    }

    @Test
    public void whenBlackBishopOnF8toA3() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        boolean result = logic.move(Cell.F8, Cell.A3);
        Assert.assertThat(result, Is.is(true));
    }
}
