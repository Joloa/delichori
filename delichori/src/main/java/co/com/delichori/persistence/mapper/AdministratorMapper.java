package co.com.delichori.persistence.mapper;

import co.com.delichori.domain.Administrator;
import co.com.delichori.persistence.entity.Administrador;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdministratorMapper {

    @Mappings({
            @Mapping(source = "cedulaAdministrador", target = "managerId"),
            @Mapping(source = "nombreAdministrador", target = "managerName"),
            @Mapping(source = "apellidoAdministrador", target = "managerLastName"),
            @Mapping(source = "clave", target = "password") //Se omite email porque se llama igual en Administrador y Administrator
    })
    Administrator toAdministrator(Administrador Administrador);

    @InheritInverseConfiguration
    Administrador toAdministrador(Administrator administrator);


}
