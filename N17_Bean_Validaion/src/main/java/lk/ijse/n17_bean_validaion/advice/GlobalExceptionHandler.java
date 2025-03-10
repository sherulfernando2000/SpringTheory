package lk.ijse.n17_bean_validaion.advice;

import lk.ijse.n17_bean_validaion.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleException(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();
        for (FieldError fieldError: exception.getBindingResult().getFieldErrors()){
            errors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ResponseDTO responseDTO = new ResponseDTO(
                401,
                "Validation Failed",
                errors
        );

        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);

    }
}
