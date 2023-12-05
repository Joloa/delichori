package co.com.delichori.web.controller;

import co.com.delichori.domain.Order;
import co.com.delichori.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<Order>> getByClient(@PathVariable("idClient") int clientId){
        return orderService.getByClient(clientId).map(
                orders -> new ResponseEntity<>(orders, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));//Lo que ocurre cuando el map no se ejecuta (no hay productos)
    }

    @PostMapping("/save")
    public ResponseEntity<Order> save(@RequestBody Order order){
        return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int orderId){
        if (orderService.delete(orderId)){
            return new ResponseEntity<>(HttpStatus.OK); //Si se pudo borrar
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND); //Si no encontró el producto
        }
    }


}
