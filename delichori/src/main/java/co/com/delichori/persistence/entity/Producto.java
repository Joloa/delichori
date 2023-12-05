package co.com.delichori.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "descripcion_producto")
    private String descripcionProducto;

    @Column(name = "precio_costo")
    private Double precioCosto;

    @Column(name = "precio_venta")
    private Double precioVenta;


    @Column(name = "existencia_producto")
    private Integer existenciaProducto;


    //Relaciones DB
    @OneToMany(mappedBy = "producto")//Lista de pedidos que tiene un producto
    private List<DetallePedido> detallePedidos;


    //Getters and Setters

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getExistenciaProducto() {
        return existenciaProducto;
    }

    public void setExistenciaProducto(Integer existenciaPriducto) {
        this.existenciaProducto = existenciaPriducto;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }
}
