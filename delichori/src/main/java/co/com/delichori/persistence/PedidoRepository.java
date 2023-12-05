package co.com.delichori.persistence;

import co.com.delichori.domain.Order;
import co.com.delichori.domain.repository.OrderRepository;
import co.com.delichori.persistence.crud.PedidoCrudRepository;
import co.com.delichori.persistence.entity.Pedido;
import co.com.delichori.persistence.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PedidoRepository implements OrderRepository {

    @Autowired
    private PedidoCrudRepository pedidoCrudRepository;
    @Autowired
    private OrderMapper mapper;


    //Buscar un pedido por cédula de cliente
    @Override
    public Optional<List<Order>> getByClient(int clientId){
        return pedidoCrudRepository.findByIdCliente(clientId)
                .map(pedidos -> mapper.toOrders(pedidos));
    }

    //Guardar un pedido
    @Override
    public Order save(Order order) {
        Pedido pedido = mapper.toPedido(order);
        pedido.getDetallePedidos().forEach(detallePedido -> detallePedido.setPedido(pedido));//cada uno de los detalles que
        // recorre le asigna el pedido que se acaba de convertir
        return mapper.toOrder(pedidoCrudRepository.save(pedido));
    }

    //Eliminar un pedido con el id, no retorna nada
    @Override
    public void delete(int orderId){
        pedidoCrudRepository.deleteById(orderId);
    }

}
