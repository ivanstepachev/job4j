package ru.job4j.chess;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.PawnBlack;

public class PawnTest {

    @Test
    public void whenBlackPawnOnA7() {
        PawnBlack pawnBlack = new PawnBlack(Cell.A7);
        Cell[] result = pawnBlack.way(Cell.A7, Cell.A6);
        Cell[] expect = {Cell.A6};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test
    public void whenBlackPawnOnH7() {
        PawnBlack pawnBlack = new PawnBlack(Cell.H7);
        Cell[] result = pawnBlack.way(Cell.H7, Cell.H6);
        Cell[] expect = {Cell.H6};
        Assert.assertThat(result, Is.is(expect));
    }
}
