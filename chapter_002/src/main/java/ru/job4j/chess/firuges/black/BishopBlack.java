package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.*;

/**
 * @author Ivan Stepachev (i1nes@icloud.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (Math.abs(source.x - dest.x) != Math.abs(source.y - dest.y)) {
            throw new ImpossibleMoveException("Ход невозможен");
        }
        Cell[] steps = new Cell[Math.abs(source.x - dest.x)];
        int deltaX;
        int deltaY;
        for (int index = 0; index < steps.length; index++) {
            deltaX = dest.x > source.x ? source.x + index : source.x - index;
            deltaY = dest.y > source.y ? source.y + index : source.y - index;
            steps[index] = Cell.find(deltaX, deltaY);
        }

        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }


}
