package co.com.delichori.domain.service;

import co.com.delichori.domain.Order;
import co.com.delichori.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    //Métodos

    public Optional<List<Order>> getByClient(int clientId){
        return orderRepository.getByClient(clientId);
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }

    public boolean delete(int clientId){
        if (getByClient(clientId).isPresent()){
            orderRepository.delete(clientId);
            return true;
        }else {
            return false;
        }

    }

}


