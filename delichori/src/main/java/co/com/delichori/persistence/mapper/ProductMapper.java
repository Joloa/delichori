package co.com.delichori.persistence.mapper;

import co.com.delichori.domain.Product;
import co.com.delichori.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source= "idProducto", target= "productId"),
            @Mapping(source= "nombreProducto", target= "name"),
            @Mapping(source= "descripcionProducto", target= "description"),
            @Mapping(source= "precioCosto", target= "costPrice"),
            @Mapping(source= "precioVenta", target= "sellingPrice"),
            @Mapping(source= "existenciaProducto", target= "stock")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos); //Recibe lista de productos y los convierte en lista de Products

    @InheritInverseConfiguration
    @Mapping(target = "detallePedidos", ignore = true)
    Producto toProducto(Product product);

}
