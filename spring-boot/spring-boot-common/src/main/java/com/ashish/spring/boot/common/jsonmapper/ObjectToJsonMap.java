package com.ashish.spring.boot.common.jsonmapper;

public interface ObjectToJsonMap<O,I> {

    O convertObjectToJson(I input);
}
