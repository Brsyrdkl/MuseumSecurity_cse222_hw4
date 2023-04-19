package org.homework4.repository.concretes;

import org.homework4.entities.Officer;
import org.homework4.repository.abstracts.OfficerRepository;

import java.util.List;
import java.util.Stack;

public class ConcreteOfficerRepository implements OfficerRepository {

    Stack<Officer> officers;

    public ConcreteOfficerRepository() {

        officers = new Stack<Officer>();
        officers.push(new Officer(1,"sibelgulmez", "[rac()ecar]",74));
        officers.push(new Officer(2,"", "[rac()ecar]",74));
        officers.push(new Officer(3,"sibel1", "[rac()ecar]",74));
        officers.push(new Officer(4,"sibel", "pass[]",74));
        officers.push(new Officer(5,"sibel", "abcdabcd",74));
        officers.push(new Officer(6,"sibel", "[[[[]]]]",74));
        officers.push(new Officer(7,"sibel", "[no](no)",74));
        officers.push(new Officer(8,"sibel", "[rac()ecar]]",74));
        officers.push(new Officer(9,"sibel", "[rac()ecars]",74));
        officers.push(new Officer(10,"sibel", "[rac()ecar]",5));
        officers.push(new Officer(11,"sibel", "[rac()ecar]",35));
    }

    @Override
    public List<Officer> getOfficers() {
        return officers;
    }

    @Override
    public Officer getById(int id) {
        return officers.get(id-1);
    }

    @Override
    public Officer add(Officer officer) {
        officers.push(officer);
        return officer;
    }

    @Override
    public Officer update(int id, Officer officer) {
        return officers.set(id-1, officer);
    }

    @Override
    public void delete(int id) {
        officers.remove(id-1);
    }
}
