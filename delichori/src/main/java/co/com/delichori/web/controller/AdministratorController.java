package co.com.delichori.web.controller;

import co.com.delichori.domain.Administrator;
import co.com.delichori.domain.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrators")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/{id}")
    public ResponseEntity<Administrator> getAdministrator(@PathVariable("id") int managerId){
        return administratorService.getAdministrator(managerId)
                .map(administrator -> new ResponseEntity<>(administrator, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));//Lo que ocurre cuando el map no se ejecuta (no hay productos)
    }

    @PostMapping("/save")
    public ResponseEntity<Administrator> save(@RequestBody Administrator administrator){
        return new ResponseEntity<>(administratorService.save(administrator), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Administrator> update(@RequestBody Administrator administrator){
        return new ResponseEntity<>(administratorService.save(administrator), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int managerId){
        if (administratorService.delete(managerId)){
            return new ResponseEntity<>(HttpStatus.OK); //Si se pudo borrar
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND); //Si no encontró el producto
        }
    }

}
