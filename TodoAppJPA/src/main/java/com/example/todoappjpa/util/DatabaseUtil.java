package com.example.todoappjpa.util;

import com.example.todoappjpa.data.repository.RepositoryException;
import com.example.todoappjpa.service.DataServiceException;

import java.util.function.Consumer;

public final class DatabaseUtil {
    private DatabaseUtil() {

    }

    public static<R> R doWorkForRepository(ISupplierCallback<R> supplier, String msg) {
        try{
           return supplier.get();
        } catch (Throwable ex) {
            throw new RepositoryException(msg, ex);
        }
    }

    public static<R> R doWorkForService(ISupplierCallback<R> supplier, String msg) {
        try {
            return supplier.get();
        } catch (Throwable ex) {
            throw new DataServiceException(msg, ex);
        }
    }


}
