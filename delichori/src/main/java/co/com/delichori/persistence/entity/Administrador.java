package co.com.delichori.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador {

    @Id
    @Column(name = "cedula_administrador")
    private Integer cedulaAdministrador;

    @Column(name = "nombre_administrador")
    private String nombreAdministrador;

    @Column(name = "apellido_administrador")
    private String apellidoAdministrador;

    private String email;

    private String clave;

    //Getters and Setters

    public Integer getCedulaAdministrador() {
        return cedulaAdministrador;
    }

    public void setCedulaAdministrador(Integer cedulaAdministrador) {
        this.cedulaAdministrador = cedulaAdministrador;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getApellidoAdministrador() {
        return apellidoAdministrador;
    }

    public void setApellidoAdministrador(String apellidoAdministrador) {
        this.apellidoAdministrador = apellidoAdministrador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
