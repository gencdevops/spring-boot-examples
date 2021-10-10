package com.example.todorestservisapp.util;

import com.example.todorestservisapp.data.repository.RepositoryException;
import com.example.todorestservisapp.service.DataServiceException;

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
