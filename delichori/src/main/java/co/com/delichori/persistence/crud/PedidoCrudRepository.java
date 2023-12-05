package co.com.delichori.persistence.crud;

import co.com.delichori.persistence.entity.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface PedidoCrudRepository extends CrudRepository<Pedido, Integer> {

    Optional<List<Pedido>> findByIdCliente(int idCliente);

}
