package ru.job4j.tracker;

import java.util.List;

/**
 * @author Ivan Stepachev(mailto:i1nes@icloud.com)
 * @version $Id$
 * @since 0.1
 */
public interface Input {

    String ask(String question);

    int ask(String question, List<Integer> range);
}
