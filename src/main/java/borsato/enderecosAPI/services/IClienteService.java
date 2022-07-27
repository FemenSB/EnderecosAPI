package borsato.enderecosAPI.services;

import borsato.enderecosAPI.exceptions.NaoEncontradoException;
import borsato.enderecosAPI.models.Cliente;

public interface IClienteService {
    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(String id) throws NaoEncontradoException;

    void inserir(Cliente cliente);

    void atualizar(String id, Cliente cliente) throws NaoEncontradoException;

    void deletar(String id) throws NaoEncontradoException;
}
