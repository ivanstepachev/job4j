package ru.job4j.chess;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.KnightBlack;



public class KnightTest {
    @Test
    public void whenKnigtOnD5() {
        KnightBlack knightBlack = new KnightBlack(Cell.D5);
        Cell[] result = knightBlack.way(Cell.D5, Cell.E7);
        Cell[] expect = {Cell.E7};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test
    public void whenKnightOnE4() {
        KnightBlack knightBlack = new KnightBlack(Cell.E4);
        Cell[] result = knightBlack.way(Cell.E4, Cell.C3);
        Cell[] expect = {Cell.C3};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test
    public void whenKnightOnF3() {
        KnightBlack knightBlack = new KnightBlack(Cell.F3);
        Cell[] result = knightBlack.way(Cell.F3, Cell.G5);
        Cell[] expect = {Cell.G5};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenKnightGoWrong() {
        KnightBlack knightBlack = new KnightBlack(Cell.F3);
        knightBlack.way(Cell.F3, Cell.F2);

    }
}
