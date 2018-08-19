package ru.job4j.calculate;

/**
 * @author Ivan Stepachev (mailto:i1nes@icloud.com)
 * @version $Id$
 * @since 17.08.2018
 */
public class UnionArray {

    /**
     * Объединяет два отсортированных массив друг за другом в один отсортированный массив.
     *
     * @param first  первый массив
     * @param second второй массив.
     * @return Объединенный массив.
     */
    public int[] merge(int[] first, int[] second) {
        int i, j;
        int k = 0;
        int[] common = new int[first.length + second.length];
        for (i = 0, j = 0; i < first.length && j < second.length; i++, j++) {
            if (first[i] > second[j]) {
                common[k++] = second[j];
                i--;
            } else {
                common[k++] = first[i];
                j--;
            }
        }
        for ( ; i < first.length; i++) {
            common[k++] = first[i];
        }
        for ( ; j < second.length; j++) {
            common[k++] = second[j];
        } return common;
    }
}

