package lk.ijse.n16_spring_security.service;

import lk.ijse.n16_spring_security.entity.Users;
import lk.ijse.n16_spring_security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationManager authManager;

    JWTService jwtService = new JWTService();

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);   // need to make a object from BCrypt

    public Users saveUser(Users user){
        user.setPassword(encoder.encode(user.getPassword()));   // set Password
        return userRepo.save(user);
    }

    public String verifyUser(Users user) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());

        return "Failed";

    }
}
