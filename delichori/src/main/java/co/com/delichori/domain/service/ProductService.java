package co.com.delichori.domain.service;

import co.com.delichori.domain.Product;
import co.com.delichori.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //Métodos
    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){//Que retorne true si se eliminó o false si no
        //return productRepository.delete(productId);//No se puede hacer así porque delete no retorna nada.
        if (getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }else {
            return false;
        }
        /* OTRA FORMA: return getProduct(productId).map(product -> { //Verificar si existe el producto a eliminar
            productRepository.delete(productId);
            return true;
        }).orElse(false);*/
    }

}
