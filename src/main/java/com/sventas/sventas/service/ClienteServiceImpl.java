package com.sventas.sventas.service;

import com.sventas.sventas.model.Cliente;
import com.sventas.sventas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente create(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente findById(Integer id) {
        Optional<Cliente> clienteOptional = repository.findById(id);
        return clienteOptional.orElse(null);
    }

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
