package com.collectionart.app.collectionart.utils;

import com.collectionart.app.collectionart.operation.Operator;

import java.util.Collection;
import java.util.function.BiConsumer;

public class CollectionUtils {

    @SuppressWarnings("unchecked")
    public static <E> E last(Collection<E> collection) {
        E[] elements = (E[]) collection.toArray();
        return elements[collection.size() - 1];
    }

    public interface ReduceConsumer<O, I> {
        O accept(O total, I input);
    }

    public static <O, I> O reduce(Iterable<I> list, O initValue, ReduceConsumer<O, I> consumer) {
        O result = initValue;
        for (I item : list) {
            result = consumer.accept(result, item);
        }
        return result;
    }

}
