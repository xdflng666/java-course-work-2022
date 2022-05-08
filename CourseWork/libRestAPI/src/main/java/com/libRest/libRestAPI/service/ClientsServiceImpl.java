package com.libRest.libRestAPI.service;

import com.libRest.libRestAPI.entity.Clients;
import com.libRest.libRestAPI.exceptions.UserNotFoundException;
import com.libRest.libRestAPI.model.idModels.ClientsIdModel;
import com.libRest.libRestAPI.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientsServiceImpl implements ClientsService{

    @Autowired
    ClientsRepository clientsRepository;

    @Override
    public List<Clients> listClients() {
        return (List<Clients>) clientsRepository.findAll();
    }

    @Override
    public List<ClientsIdModel> listClientsIds() {
        return clientsRepository.findAll().stream().map(Clients::toIdModel).collect(Collectors.toList());
    }

    @Override
    public Clients addClient(Clients newClient) {
        return clientsRepository.save(newClient);
    }

    @Override
    public Clients findById(Long id) {
        return clientsRepository.findById(id).orElseThrow(()-> new RuntimeException("Client not found!"));
    }

    @Override
    public Long deleteClientById(Long id) {
        clientsRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Clients> findAllByFirstName(String name) {

        if(clientsRepository.findAllByFirstName(name).isEmpty()){
            throw new UserNotFoundException("User with name " + name + " not found!");
        }

        return clientsRepository.findAllByFirstName(name);
    }

    @Override
    public Clients editClient(Long id, Clients clientDetails) {

        Clients client = findById(id);

        client.setFirstName(clientDetails.getFirstName());
        client.setLastName(clientDetails.getLastName());
        client.setPatherName(clientDetails.getPatherName());
        client.setPassportSeria(clientDetails.getPassportSeria());
        client.setPassportNum(clientDetails.getPassportNum());

        return clientsRepository.save(client);

    }

}
