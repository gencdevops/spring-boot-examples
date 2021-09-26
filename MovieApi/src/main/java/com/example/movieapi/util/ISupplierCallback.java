package com.example.movieapi.util;

@FunctionalInterface
public interface ISupplierCallback<R> {
    R get() throws Exception;
}
