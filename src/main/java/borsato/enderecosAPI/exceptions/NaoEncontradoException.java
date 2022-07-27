package borsato.enderecosAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NaoEncontradoException extends Exception{
    public NaoEncontradoException(String msg) {
        super(msg);
    }    
}
