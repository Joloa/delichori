package co.com.delichori.domain.service;

import co.com.delichori.domain.Administrator;
import co.com.delichori.domain.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    //Métodos

    public Optional<Administrator> getAdministrator(int managerId){
        return administratorRepository.getAdministrator(managerId);
    }
    public Administrator save(Administrator administrator){
        return administratorRepository.save(administrator);
    }

    public boolean delete(int managerId){
        if (getAdministrator(managerId).isPresent()){
            administratorRepository.delete(managerId);
            return true;
        }else {
            return false;
        }

    }

}


