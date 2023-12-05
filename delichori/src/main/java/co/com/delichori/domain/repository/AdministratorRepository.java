package co.com.delichori.domain.repository;

import co.com.delichori.domain.Administrator;

import java.util.Optional;

public interface AdministratorRepository {

    Optional <Administrator> getAdministrator(int managerId);
    Administrator save(Administrator administrator);
    void delete(int managerId);

}
