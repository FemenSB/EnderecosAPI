package borsato.enderecosAPI.services;

import borsato.enderecosAPI.exceptions.NaoEncontradoException;
import borsato.enderecosAPI.models.Cliente;
import borsato.enderecosAPI.models.Endereco;
import borsato.enderecosAPI.repositories.ClienteRepository;
import borsato.enderecosAPI.repositories.EnderecoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private ViaCepService viaCepService;
    
    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(String id) throws NaoEncontradoException {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()) {
            throw new NaoEncontradoException("Cliente não encontrado");
        }
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(String id, Cliente cliente) throws NaoEncontradoException {
        if(!existeIdCliente(id)) {
            throw new NaoEncontradoException("Cliente não encontrado");
        }
        salvarClienteComCep(cliente);
    }

    @Override
    public void deletar(String id) throws NaoEncontradoException {
        if(!existeIdCliente(id)) {
            throw new NaoEncontradoException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
    
    private boolean existeIdCliente(String id) throws NaoEncontradoException {
        return clienteRepository.findById(id).isPresent();
    }
    
    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Optional<Endereco> endereco = enderecoRepository.findById(cep);
        if(endereco.isEmpty()) {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            cliente.setEndereco(novoEndereco);
        } else {
            cliente.setEndereco(endereco.get());
        }
        clienteRepository.save(cliente);
	}
    
}
