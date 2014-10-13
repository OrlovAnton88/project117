package ru.aorlov.util;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * Created by anton on 12.10.14.
 */
public class MySQL5UTF8InnoDBDialect extends MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return super.getTableTypeString() + " DEFAULT CHARSET=utf8";
    }
}
