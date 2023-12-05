package co.com.delichori.persistence.mapper;

import co.com.delichori.domain.Order;
import co.com.delichori.domain.OrderDetail;
import co.com.delichori.persistence.entity.DetallePedido;
import co.com.delichori.persistence.entity.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-30T13:37:59-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 11.0.21 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public Order toOrder(Pedido pedido) {
        if ( pedido == null ) {
            return null;
        }

        Order order = new Order();

        if ( pedido.getIdPedido() != null ) {
            order.setOrderId( pedido.getIdPedido() );
        }
        if ( pedido.getIdCliente() != null ) {
            order.setClientId( pedido.getIdCliente() );
        }
        order.setClientName( pedido.getNombreCliente() );
        order.setClientLastName( pedido.getApellidoCliente() );
        order.setClientAdress( pedido.getDireccionCliente() );
        order.setDate( pedido.getFechaPedido() );
        order.setComment( pedido.getComentario() );
        order.setState( pedido.getEstadoPedido() );
        order.setDetails( detallePedidoListToOrderDetailList( pedido.getDetallePedidos() ) );

        return order;
    }

    @Override
    public List<Order> toOrders(List<Pedido> pedidos) {
        if ( pedidos == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( pedidos.size() );
        for ( Pedido pedido : pedidos ) {
            list.add( toOrder( pedido ) );
        }

        return list;
    }

    @Override
    public Pedido toPedido(Order order) {
        if ( order == null ) {
            return null;
        }

        Pedido pedido = new Pedido();

        pedido.setIdPedido( order.getOrderId() );
        pedido.setIdCliente( order.getClientId() );
        pedido.setNombreCliente( order.getClientName() );
        pedido.setApellidoCliente( order.getClientLastName() );
        pedido.setDireccionCliente( order.getClientAdress() );
        pedido.setFechaPedido( order.getDate() );
        pedido.setComentario( order.getComment() );
        pedido.setEstadoPedido( order.getState() );
        pedido.setDetallePedidos( orderDetailListToDetallePedidoList( order.getDetails() ) );

        return pedido;
    }

    protected List<OrderDetail> detallePedidoListToOrderDetailList(List<DetallePedido> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDetail> list1 = new ArrayList<OrderDetail>( list.size() );
        for ( DetallePedido detallePedido : list ) {
            list1.add( orderDetailMapper.toOrderDetail( detallePedido ) );
        }

        return list1;
    }

    protected List<DetallePedido> orderDetailListToDetallePedidoList(List<OrderDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<DetallePedido> list1 = new ArrayList<DetallePedido>( list.size() );
        for ( OrderDetail orderDetail : list ) {
            list1.add( orderDetailMapper.toDetallePedido( orderDetail ) );
        }

        return list1;
    }
}
