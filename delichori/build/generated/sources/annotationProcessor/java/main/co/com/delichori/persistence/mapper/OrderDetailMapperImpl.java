package co.com.delichori.persistence.mapper;

import co.com.delichori.domain.OrderDetail;
import co.com.delichori.persistence.entity.DetallePedido;
import co.com.delichori.persistence.entity.DetallePedidoPK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-30T13:37:58-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 11.0.21 (Amazon.com Inc.)"
)
@Component
public class OrderDetailMapperImpl implements OrderDetailMapper {

    @Override
    public OrderDetail toOrderDetail(DetallePedido producto) {
        if ( producto == null ) {
            return null;
        }

        OrderDetail orderDetail = new OrderDetail();

        Integer idProducto = productoIdIdProducto( producto );
        if ( idProducto != null ) {
            orderDetail.setProductId( idProducto );
        }
        if ( producto.getCantidadProducto() != null ) {
            orderDetail.setQuantity( producto.getCantidadProducto() );
        }
        if ( producto.getValorTotalPedido() != null ) {
            orderDetail.setTotal( producto.getValorTotalPedido() );
        }

        return orderDetail;
    }

    @Override
    public DetallePedido toDetallePedido(OrderDetail detail) {
        if ( detail == null ) {
            return null;
        }

        DetallePedido detallePedido = new DetallePedido();

        detallePedido.setId( orderDetailToDetallePedidoPK( detail ) );
        detallePedido.setCantidadProducto( detail.getQuantity() );
        detallePedido.setValorTotalPedido( detail.getTotal() );

        return detallePedido;
    }

    private Integer productoIdIdProducto(DetallePedido detallePedido) {
        if ( detallePedido == null ) {
            return null;
        }
        DetallePedidoPK id = detallePedido.getId();
        if ( id == null ) {
            return null;
        }
        Integer idProducto = id.getIdProducto();
        if ( idProducto == null ) {
            return null;
        }
        return idProducto;
    }

    protected DetallePedidoPK orderDetailToDetallePedidoPK(OrderDetail orderDetail) {
        if ( orderDetail == null ) {
            return null;
        }

        DetallePedidoPK detallePedidoPK = new DetallePedidoPK();

        detallePedidoPK.setIdProducto( orderDetail.getProductId() );

        return detallePedidoPK;
    }
}
