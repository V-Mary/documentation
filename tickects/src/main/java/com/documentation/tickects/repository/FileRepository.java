package com.documentation.tickects.repository;


import java.util.List;

public interface FileRepository {
    public List<String[]> readAll(String filepath);

    public void writeAll(String filepath, List<String[]> data);
}
