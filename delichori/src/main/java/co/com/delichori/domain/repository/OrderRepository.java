package co.com.delichori.domain.repository;

import co.com.delichori.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Optional<List<Order>> getByClient(int clientId);

    Order save(Order order);
    void delete(int orderId);

}
