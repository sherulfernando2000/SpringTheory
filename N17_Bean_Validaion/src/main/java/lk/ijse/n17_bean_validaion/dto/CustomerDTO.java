package lk.ijse.n17_bean_validaion.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class CustomerDTO {
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name should contain only letters and spaces")
    @Size(min=3,max=200)
   private String name;
   @Email(message = "Invalid email address")
   private String email;
   @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number")
   private String phoneNumber;

    public CustomerDTO() {

    }

    public CustomerDTO(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
