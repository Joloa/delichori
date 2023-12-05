package co.com.delichori.persistence.mapper;

import co.com.delichori.domain.Order;
import co.com.delichori.persistence.entity.Pedido;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrderDetailMapper.class})
public interface OrderMapper {
    
    @Mappings({
            @Mapping(source = "idPedido", target = "orderId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "nombreCliente", target = "clientName"),
            @Mapping(source = "apellidoCliente", target = "clientLastName"),
            @Mapping(source = "direccionCliente", target = "clientAdress"),
            @Mapping(source = "fechaPedido", target = "date"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estadoPedido", target = "state"),
            @Mapping(source = "detallePedidos", target = "details")
    })
    Order toOrder(Pedido pedido);
    List<Order> toOrders(List<Pedido> pedidos); //Lista de pedidos

    @InheritInverseConfiguration
    Pedido toPedido(Order order);

}
