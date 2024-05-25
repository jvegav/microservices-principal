package com.latencia.latencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.stereotype.Service;

import com.latencia.latencia.dto.*;
import com.latencia.latencia.models.Cliente;
import com.latencia.latencia.repositories.ClienteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    public void crearCliente(Cliente cliente){
        clienteRepository.save(cliente);

        log.info("Cliente {} ha sido creado", cliente.getId());
    }

    public List<Cliente> darTodosLosClientes(){
        List<Cliente> clientes =  clienteRepository.findAll();
        return clientes;
    }


    
}

