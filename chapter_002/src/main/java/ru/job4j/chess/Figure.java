package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

abstract class Figure {

    final Cell position;

    Figure(Cell position) {
        this.position = position;
    }

    abstract Cell position();

    abstract Cell[] way(Cell source, Cell dest); // Не забыть про исключение

    abstract Figure copy(Cell dest);
}
