package ru.job4j.chess.firuges.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Ivan Stepachev (i1nes@icloud.com)
 * @version $Id$
 * @since 0.1
 */
public class QeenWhite implements Figure {
    private final Cell position;

    public QeenWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaX;
        int deltaY;
        Cell[] steps;
        if (source.x == dest.x) {
            steps = new Cell[Math.abs(source.y - dest.y)];
            for (int i = 0; i < steps.length; i++) {
                deltaY = dest.y > source.y ? source.y + i + 1 : source.y - i - 1;
                steps[i] = Cell.find(source.x, deltaY);
            }
        } else if (source.y == dest.y) {
            steps = new Cell[Math.abs(source.x - dest.x)];
            for (int i = 0; i < steps.length; i++) {
                deltaX = dest.x > source.x ? source.x + i + 1 : source.x - i - 1;
                steps[i] = Cell.find(deltaX, source.y);
            }
        } else if (Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y)) {
            steps = new Cell[Math.abs(source.x - dest.x)];
            for (int i = 1; i <= steps.length; i++) {
                deltaX = dest.x > source.x ? source.x + i : source.x - i;
                deltaY = dest.y > source.y ? source.y + i : source.y - i;
                steps[i - 1] = Cell.find(deltaX, deltaY);
            }
        } else {
            throw new ImpossibleMoveException("Ход невозможен");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenWhite(dest);
    }
}
