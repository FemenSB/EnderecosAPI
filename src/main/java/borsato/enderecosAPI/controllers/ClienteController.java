package borsato.enderecosAPI.controllers;

import borsato.enderecosAPI.exceptions.NaoEncontradoException;
import borsato.enderecosAPI.models.Cliente;
import borsato.enderecosAPI.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private IClienteService clienteService;
    
    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable String id) throws NaoEncontradoException{
        try {
            return ResponseEntity.ok(clienteService.buscarPorId(id));
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable String id, @RequestBody Cliente cliente) throws NaoEncontradoException {
        try {
            clienteService.atualizar(id, cliente);
            return ResponseEntity.ok(cliente);
        } catch(Exception e) {
            throw e;
        }    
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) throws NaoEncontradoException {
        try {
            clienteService.deletar(id);
        } catch(Exception e) {
            throw e;
        }
        return ResponseEntity.ok().build();
    }
}
