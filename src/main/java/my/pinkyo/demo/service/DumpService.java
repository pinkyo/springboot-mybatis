package my.pinkyo.demo.service;

import my.pinkyo.demo.model.DataCategory;

import java.util.List;

public interface DumpService<T> {
    List<T> dump();
    DataCategory getCategory();
}
