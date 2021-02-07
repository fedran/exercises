package org.fedran.stepic;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.fedran.stepic.CommonWordsProcessor.findCommonWords;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonWordsProcessorTest {
    @Test
    public void firstTest() {
        final String s = "Мама мыла-мыла-мыла раму!";
        final List<String> words = findCommonWords(s);
        assertEquals("[мыла, мама, раму]", words.toString());
    }

    @Test
    public void secondTest() {
        final String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at " +
                "faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit " +
                "tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula " +
                "mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio " +
                "nec mi tempor dignissim.";
        final List<String> words = findCommonWords(s);
        assertEquals("[consectetur, faucibus, ipsum, lorem, adipiscing, amet, dolor, eget, elit, mi]", words.toString());
    }
}
