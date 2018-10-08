package ru.job4j.chess;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;


public class BishopTest {

    @Test
    public void whenBlackBishopOnC8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell[] result = bishopBlack.way(Cell.C8, Cell.A6);
        Cell[] expect = {Cell.B7, Cell.A6};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test
    public void whenBlackBishopOnF8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell[] result = bishopBlack.way(Cell.F8, Cell.B4);
        Cell[] expect = {Cell.E7, Cell.D6, Cell.C5, Cell.B4};
        Assert.assertThat(result, Is.is(expect));
    }
}
