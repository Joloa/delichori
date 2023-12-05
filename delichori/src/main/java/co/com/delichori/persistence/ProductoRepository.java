package co.com.delichori.persistence;

import co.com.delichori.domain.Product;
import co.com.delichori.domain.repository.ProductRepository;
import co.com.delichori.persistence.crud.ProductoCrudRepository;
import co.com.delichori.persistence.entity.Producto;
import co.com.delichori.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository //Se le indica a Spring que esta clase interactúa directamente con la DB
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    //Buscar todos los productos
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    //Buscar un producto por id
    @Override
    public Optional<Product> getProduct(int productId){
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    //Guardar un producto
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product); //Save espera un producto, por eso se crea producto y se hace la conversión inversa
        return mapper.toProduct(productoCrudRepository.save(producto));
    }
    
    //Eliminar un producto con el id, no retorna nada
    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }

}
