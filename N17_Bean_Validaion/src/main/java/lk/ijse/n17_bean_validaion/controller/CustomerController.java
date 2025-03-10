package lk.ijse.n17_bean_validaion.controller;

import jakarta.validation.Valid;
import lk.ijse.n17_bean_validaion.dto.CustomerDTO;
import lk.ijse.n17_bean_validaion.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

   @PostMapping("save")
    public ResponseEntity<ResponseDTO> addCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        ResponseDTO responseDTO = new ResponseDTO(
                201,
                "Customer created",
                null
        );

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}
