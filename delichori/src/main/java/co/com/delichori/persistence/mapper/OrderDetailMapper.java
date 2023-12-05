package co.com.delichori.persistence.mapper;

import co.com.delichori.domain.OrderDetail;
import co.com.delichori.persistence.entity.DetallePedido;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class}) //Se hace referencia a producto entonces se usa su mapper
public interface OrderDetailMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidadProducto", target = "quantity"),
            @Mapping(source = "valorTotalPedido", target = "total")
    })
    OrderDetail toOrderDetail(DetallePedido producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "pedido", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idPedido", ignore = true)
    })
    DetallePedido toDetallePedido(OrderDetail detail);

}
