package co.com.delichori.persistence.mapper;

import co.com.delichori.domain.Administrator;
import co.com.delichori.persistence.entity.Administrador;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-29T17:17:21-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 11.0.21 (Amazon.com Inc.)"
)
@Component
public class AdministratorMapperImpl implements AdministratorMapper {

    @Override
    public Administrator toAdministrator(Administrador Administrador) {
        if ( Administrador == null ) {
            return null;
        }

        Administrator administrator = new Administrator();

        if ( Administrador.getCedulaAdministrador() != null ) {
            administrator.setManagerId( Administrador.getCedulaAdministrador() );
        }
        administrator.setManagerName( Administrador.getNombreAdministrador() );
        administrator.setManagerLastName( Administrador.getApellidoAdministrador() );
        administrator.setPassword( Administrador.getClave() );
        administrator.setEmail( Administrador.getEmail() );

        return administrator;
    }

    @Override
    public Administrador toAdministrador(Administrator administrator) {
        if ( administrator == null ) {
            return null;
        }

        Administrador administrador = new Administrador();

        administrador.setCedulaAdministrador( administrator.getManagerId() );
        administrador.setNombreAdministrador( administrator.getManagerName() );
        administrador.setApellidoAdministrador( administrator.getManagerLastName() );
        administrador.setClave( administrator.getPassword() );
        administrador.setEmail( administrator.getEmail() );

        return administrador;
    }
}
