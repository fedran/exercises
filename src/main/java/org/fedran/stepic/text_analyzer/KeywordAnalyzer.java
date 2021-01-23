package org.fedran.stepic.text_analyzer;

abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    public Label processText(String text) {
        for (String s : getKeywords()) {
            if (text.contains(s)) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}
