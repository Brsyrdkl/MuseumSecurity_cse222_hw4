package org.homework4.tests;

import org.homework4.business.concretes.OfficerManager;
import org.homework4.entities.Officer;
import org.homework4.repository.abstracts.OfficerRepository;
import org.homework4.repository.concretes.ConcreteOfficerRepository;

public class TestClass {

    public static void main(String[] args) {

        OfficerRepository repository = new ConcreteOfficerRepository();

        OfficerManager manager = new OfficerManager(repository);

        Officer officer1 = repository.getById(1);
        Officer officer2 = repository.getById(2);
        Officer officer3 = repository.getById(3);
        Officer officer4 = repository.getById(4);
        Officer officer5 = repository.getById(5);
        Officer officer6 = repository.getById(6);
        Officer officer7 = repository.getById(7);
        Officer officer8 = repository.getById(8);
        Officer officer9 = repository.getById(9);
        Officer officer10 = repository.getById(10);
        Officer officer11 = repository.getById(11);


        manager.checkAllValidations(officer11);
//

    }
}
