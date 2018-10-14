package ru.job4j.chess;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class BishopTest {

    @Test
    public void whenBlackBishopOnF8GoToH6() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell[] result = bishopBlack.way(Cell.F8, Cell.H6);
        Cell[] expect = {Cell.G7, Cell.H6};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test
    public void whenBlackBishopOnF8GoToB4() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell[] result = bishopBlack.way(Cell.F8, Cell.B4);
        Cell[] expect = {Cell.E7, Cell.D6, Cell.C5, Cell.B4};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenBlackBishopGoWrongVertical1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        bishopBlack.way(Cell.F8, Cell.F2);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenBlackBishopGoWrongVertical2() {
        BishopBlack bishopBlack = new BishopBlack(Cell.E5);
        bishopBlack.way(Cell.E5, Cell.E8);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenBlackBishopGoWrongHorizontal1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        bishopBlack.way(Cell.F8, Cell.B8);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenBlackBishopGoWrongHorizontal2() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        bishopBlack.way(Cell.F8, Cell.H8);
    }
}
