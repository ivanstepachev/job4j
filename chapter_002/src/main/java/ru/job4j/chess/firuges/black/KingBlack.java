package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Ivan Stepachev (i1nes@icloud.com)
 * @version $Id$
 * @since 0.1
 */
public class KingBlack implements Figure {
    private final Cell position;

    public KingBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps;
        if ((dest.x == source.x && source.y + 1 == dest.y)
                || (dest.x == source.x && source.y - 1 == dest.y)
                || (dest.x == source.x + 1 && source.y == dest.y)
                || (dest.x == source.x - 1 && source.y == dest.y)
                || (dest.x == source.x + 1 && source.y + 1 == dest.y)
                || (dest.x == source.x + 1 && source.y - 1 == dest.y)
                || (dest.x == source.x - 1 && source.y + 1 == dest.y)
                || dest.x == source.x - 1 && source.y - 1 == dest.y) {
            steps = new Cell[]{dest};
        } else {
            throw new ImpossibleMoveException("Ход невозможен");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}
