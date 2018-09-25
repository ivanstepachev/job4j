package ru.job4j.chess;

public class ImpossibleMoveException extends RuntimeException {

    public ImpossibleMoveException(String error) {
        error = "Ход невозможен";
    }
}
