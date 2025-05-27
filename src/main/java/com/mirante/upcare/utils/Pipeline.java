package com.mirante.upcare.utils;

import java.util.function.Function;

/**
 * Aplica uma sequência de funções.
 * @author David Gomesh
 */
public class Pipeline<A> {

    private final A value;

    private Pipeline(A value) {
        this.value = value;
    }

    public static <A> Pipeline<A> from(A value) {
        return new Pipeline<>(value);
    }

    public <B> Pipeline<B> then(Function<A, B> f) {
        return Pipeline.from(f.apply(value));
    }

    public A get() {
        return value;
    }
    
}
