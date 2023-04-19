package org.homework4.repository.abstracts;

import org.homework4.entities.Officer;

import java.util.List;

public interface OfficerRepository {

    List<Officer> getOfficers();
    Officer getById(int id);
    Officer add(Officer officer);
    Officer update(int id,Officer officer);
    void delete(int id);
}
