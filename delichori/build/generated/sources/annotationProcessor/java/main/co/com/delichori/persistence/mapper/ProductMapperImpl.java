package co.com.delichori.persistence.mapper;

import co.com.delichori.domain.Product;
import co.com.delichori.persistence.entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-30T13:37:58-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 11.0.21 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        Product product = new Product();

        if ( producto.getIdProducto() != null ) {
            product.setProductId( producto.getIdProducto() );
        }
        product.setName( producto.getNombreProducto() );
        product.setDescription( producto.getDescripcionProducto() );
        if ( producto.getPrecioCosto() != null ) {
            product.setCostPrice( producto.getPrecioCosto() );
        }
        if ( producto.getPrecioVenta() != null ) {
            product.setSellingPrice( producto.getPrecioVenta() );
        }
        if ( producto.getExistenciaProducto() != null ) {
            product.setStock( producto.getExistenciaProducto() );
        }

        return product;
    }

    @Override
    public List<Product> toProducts(List<Producto> productos) {
        if ( productos == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productos.size() );
        for ( Producto producto : productos ) {
            list.add( toProduct( producto ) );
        }

        return list;
    }

    @Override
    public Producto toProducto(Product product) {
        if ( product == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setIdProducto( product.getProductId() );
        producto.setNombreProducto( product.getName() );
        producto.setDescripcionProducto( product.getDescription() );
        producto.setPrecioCosto( product.getCostPrice() );
        producto.setPrecioVenta( product.getSellingPrice() );
        producto.setExistenciaProducto( product.getStock() );

        return producto;
    }
}
