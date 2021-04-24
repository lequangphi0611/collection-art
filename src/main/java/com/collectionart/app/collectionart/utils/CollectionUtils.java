package com.collectionart.app.collectionart.utils;

import java.util.Collection;

public class CollectionUtils {

    public static <E> E last(Collection<E> collection) {
        E[] elements = (E[]) collection.toArray();
        return elements[collection.size() - 1];
    }

}
