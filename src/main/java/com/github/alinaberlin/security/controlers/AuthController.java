package com.github.alinaberlin.security.controlers;


import com.github.alinaberlin.security.components.JWTEncoderDecoder;
import com.github.alinaberlin.security.models.User;
import com.github.alinaberlin.security.payload.request.LoginRequest;
import com.github.alinaberlin.security.payload.response.ErrorRes;
import com.github.alinaberlin.security.payload.response.LoginRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;


    private JWTEncoderDecoder jwtEncoderDecoder ;
    public AuthController(AuthenticationManager authenticationManager, JWTEncoderDecoder  jwtEncoderDecoder) {
        this.authenticationManager = authenticationManager;
        this.jwtEncoderDecoder = jwtEncoderDecoder;

    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginRequest loginReq)  {

        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPasword()));
            String email = authentication.getName();
            User user = new User(loginReq.getEmail(), loginReq.getPasword());
            String token = jwtEncoderDecoder.createToken(user);
            LoginRes loginRes = new LoginRes(email,token);

            return ResponseEntity.ok(loginRes);

        }catch (BadCredentialsException e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (Exception e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
