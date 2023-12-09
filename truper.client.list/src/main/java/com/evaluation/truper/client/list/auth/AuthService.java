package com.evaluation.truper.client.list.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.evaluation.truper.client.list.auth.user.User;
import com.evaluation.truper.client.list.jwt.JwtService;
import com.evaluation.truper.client.list.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor	
public class AuthService {
	
	@Autowired
	private final UserRepository userRepository;

	@Autowired
	private final JwtService jwtService;
	
	@Autowired
    private final PasswordEncoder passwordEncoder;
    
	@Autowired
	private final AuthenticationManager authenticationManager;
	
	public AuthResponse login(LoginRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPass()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow(null);
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
	}
	
	public AuthResponse register(RegisterRequest request) {
		User user = User.builder().username(request.userName).password(request.pass).build();
		
		userRepository.save(user);
		
		return AuthResponse.builder().token(jwtService.getToken(user)).build();
	}
}
