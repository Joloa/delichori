package co.com.delichori.persistence;

import co.com.delichori.persistence.crud.DetallePedidoCrudRepository;
import co.com.delichori.persistence.entity.DetallePedido;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DetallePedidoRepository {

    private DetallePedidoCrudRepository detallePedidoCrudRepository;

    //Buscar un detalle del pedido con el id del pedido
    public Optional<DetallePedido> getDetallePedido(int idPedido) {
        return detallePedidoCrudRepository.findById(idPedido);
    }

}
