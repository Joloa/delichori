package co.com.delichori.persistence;

import co.com.delichori.domain.Administrator;
import co.com.delichori.domain.repository.AdministratorRepository;
import co.com.delichori.persistence.crud.AdministradorCrudRepository;
import co.com.delichori.persistence.entity.Administrador;
import co.com.delichori.persistence.mapper.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AdministradorRepository implements AdministratorRepository {
    @Autowired
    private AdministradorCrudRepository administradorCrudRepository;
    @Autowired
    private AdministratorMapper mapper;

    //Buscar un administrador por id
    @Override
    public Optional<Administrator> getAdministrator(int managerId){
        return administradorCrudRepository.findById(managerId).map(administrador -> mapper.toAdministrator(administrador));
    }

    //Registrar un administrador
    @Override
    public Administrator save(Administrator administrator) {
        Administrador administrador = mapper.toAdministrador(administrator); //Save espera un producto, por eso se crea producto y se hace la conversión inversa
        return mapper.toAdministrator(administradorCrudRepository.save(administrador));
    }

    //Eliminar un administrador con el número de cédula
    @Override
    public void delete(int managerId){
        administradorCrudRepository.deleteById(managerId);
    }
}







