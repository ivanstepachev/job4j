package ru.job4j.calculate;

/**
 * @author Ivan Stepachev (mailto:i1nes@icloud.com)
 * @version $Id$
 * @since 17.08.2018
 */
public class UnionArray {

    /** Объединяет два массив друг за другом в один массив.
     * @param first первый массив
     * @param second второй массив.
     * @return Объединенный массив.
     */
    public int[] integrateArrays(int[] first, int[] second) {
        int[] merge = new int[first.length + second.length];
        for (int index = 0; index != second.length; index++) {
            merge[index] = first[index];
            merge[merge.length - 1 - index] = second[second.length - 1 - index];
        }
        return merge;
    }
}

