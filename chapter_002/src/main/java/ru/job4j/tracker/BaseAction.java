package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {

    private final int keyNumber;
    private final String menuOption;

    protected BaseAction(final int keyNumber, final String menuOption) {
        this.keyNumber = keyNumber;
        this.menuOption = menuOption;
    }

    @Override
    public int key() {
        return keyNumber;
    }

    @Override
    public String info() {
        return menuOption;
    }
}
