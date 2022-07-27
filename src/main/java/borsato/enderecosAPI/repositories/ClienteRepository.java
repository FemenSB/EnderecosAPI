package borsato.enderecosAPI.repositories;

import borsato.enderecosAPI.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, String>{
    
}
