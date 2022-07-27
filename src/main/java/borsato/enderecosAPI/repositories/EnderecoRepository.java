package borsato.enderecosAPI.repositories;

import borsato.enderecosAPI.models.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, String>{
    
}
