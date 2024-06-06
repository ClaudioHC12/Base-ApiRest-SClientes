package com.sventas.sventas.controller;

import com.sventas.sventas.exception.ModelNotFoundException;
import com.sventas.sventas.model.Cliente;
import com.sventas.sventas.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl service;

    @GetMapping("")
    public ResponseEntity<List<Cliente>> obtenerClientes(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente){
        return new ResponseEntity<>(service.create(cliente), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Object> actualizarCliente(@RequestBody Cliente cliente){
        return new ResponseEntity<>(service.update(cliente), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> consultarClientePorId(@PathVariable("id") Integer idCliente){
        Cliente cliente = service.findById(idCliente);
        if (cliente == null){
            throw new ModelNotFoundException("Cliente NO encontrado");
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<Object> borrarCliente(@PathVariable("id") Integer idCliente) throws Exception {
        Cliente cliente = service.findById(idCliente);
        if (cliente == null){
            throw new ModelNotFoundException("El cliente que desea eliminar no existe");
        }
        service.delete(idCliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
}
