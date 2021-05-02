package com.collectionart.app.collectionart.common.impl;

import com.collectionart.app.collectionart.common.CustomStringBuilder;
import com.collectionart.app.collectionart.common.StringConstants;

public class SimpleCustomStringBuilder implements CustomStringBuilder {

    private final StringBuilder stringBuilder;

    public SimpleCustomStringBuilder() {
        this.stringBuilder = new StringBuilder();
    }

    public SimpleCustomStringBuilder(CharSequence charSequence) {
        this.stringBuilder = new StringBuilder(charSequence);
    }

    @Override
    public CustomStringBuilder appendComma() {
        return this.append(StringConstants.COMMA);
    }

    @Override
    public CustomStringBuilder appendSpace() {
        return this.append(StringConstants.SPACE);
    }

    @Override
    public CustomStringBuilder appendQuestionMask() {
        return this.append(StringConstants.QUESTION_MASK);
    }

    @Override
    public CustomStringBuilder wrapParenthesis() {
        return this.insert(0, StringConstants.PARENTHESIS_LEFT)
                .insert(this.length(), StringConstants.PARENTHESIS_RIGHT);
    }

    @Override
    public CustomStringBuilder append(int i) {
        this.stringBuilder.append(i);
        return this;
    }

    @Override
    public CustomStringBuilder insert(int index, CharSequence csq) {
        this.stringBuilder.insert(index, csq);
        return this;
    }

    @Override
    public CustomStringBuilder append(CharSequence csq) {
        this.stringBuilder.append(csq);
        return this;
    }

    @Override
    public CustomStringBuilder append(CharSequence csq, int start, int end) {
        this.stringBuilder.append(csq, start, end);
        return this;
    }

    @Override
    public CustomStringBuilder append(char c) {
        this.stringBuilder.append(c);
        return this;
    }

    @Override
    public int length() {
        return this.stringBuilder.length();
    }

    @Override
    public char charAt(int index) {
        return this.stringBuilder.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.stringBuilder.subSequence(start, end);
    }

    @Override
    public String toString() {
        return this.stringBuilder.toString();
    }
}
