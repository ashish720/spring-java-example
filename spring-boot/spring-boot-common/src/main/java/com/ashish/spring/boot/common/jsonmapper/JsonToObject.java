package com.ashish.spring.boot.common.jsonmapper;

public interface JsonToObject<O,I> {
    O responseBodyToObject(I input);
}
