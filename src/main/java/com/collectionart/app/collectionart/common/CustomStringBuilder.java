package com.collectionart.app.collectionart.common;

import java.io.IOException;

public interface CustomStringBuilder extends Appendable, CharSequence {

    CustomStringBuilder appendComma();

    CustomStringBuilder appendSpace();

    CustomStringBuilder appendQuestionMask();

    CustomStringBuilder wrapParenthesis();

    CustomStringBuilder append(int i);

    CustomStringBuilder insert(int index, CharSequence csq);

    @Override
    CustomStringBuilder append(char c);

    @Override
    CustomStringBuilder append(CharSequence csq);

    @Override
    CustomStringBuilder append(CharSequence csq, int start, int end);
}
