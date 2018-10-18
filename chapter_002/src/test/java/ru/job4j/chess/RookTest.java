package ru.job4j.chess;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.RookBlack;

public class RookTest {

    @Test
    public void whenBlackRookOnF8GoToF1() {
        RookBlack rookBlack = new RookBlack(Cell.F8);
        Cell[] result = rookBlack.way(Cell.F8, Cell.F5);
        Cell[] expect = {Cell.F7, Cell.F6, Cell.F5};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test
    public void whenBlackRookOnF8GoToF2() {
        RookBlack rookBlack = new RookBlack(Cell.F5);
        Cell[] result = rookBlack.way(Cell.F5, Cell.F8);
        Cell[] expect = {Cell.F6, Cell.F7, Cell.F8};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test
    public void whenBlackRookOnC8GoToF8() {
        RookBlack rookBlack = new RookBlack(Cell.C8);
        Cell[] result = rookBlack.way(Cell.C8, Cell.F8);
        Cell[] expect = {Cell.D8, Cell.E8, Cell.F8};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test
    public void whenBlackRookOnF8GoToC8() {
        RookBlack rookBlack = new RookBlack(Cell.F8);
        Cell[] result = rookBlack.way(Cell.F8, Cell.C8);
        Cell[] expect = {Cell.E8, Cell.D8, Cell.C8};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenWrongWayForRook() {
        RookBlack rookBlack = new RookBlack(Cell.F8);
        rookBlack.way(Cell.F8, Cell.D5);

    }
}
