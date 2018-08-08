package ru.job4j.calculate;

/**
 * Обертка над строкой
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }
    /**
     * Проверяет, что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса.
     */
    public boolean startWith(String prefix) {
    boolean result = true;
    char[] value = prefix.toCharArray();
    for (int indexData = 0; indexData < data.length; indexData++) {
    }
    for (int indexValue = 0; indexValue < value.length; indexValue++) {
    }
    if ((data[0] != value[0]) || (data[1] != value[1])) {
        result = false;
    }
    return result;
    }
}


