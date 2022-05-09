package com.libRest.libRestAPI.service;

import com.libRest.libRestAPI.entity.Clients;
import com.libRest.libRestAPI.model.idModels.ClientsIdModel;

import java.util.List;
import java.util.Optional;

public interface ClientsService {

    List<Clients> listClients();

    List<ClientsIdModel> listClientsIds();

    Clients addClient(Clients newClient);

    Clients findById(Long id);

    Long deleteClientById(Long id);

    List<Clients> findAllByFirstName(String name);

    Clients editClient(Long id, Clients clientDetails);

}
