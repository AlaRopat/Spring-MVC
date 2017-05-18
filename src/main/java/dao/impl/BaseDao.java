package dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Nikolay Shuvaev on 18.05.2017.
 */
abstract class BaseDao<T> {
    protected T repository;

    @Autowired
    public void setRepository(T repository) {
        this.repository = repository;
    }
}
