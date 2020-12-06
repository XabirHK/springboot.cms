package com.zabir.springboot.cms.contollers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zabir.springboot.cms.models.ERole;
import com.zabir.springboot.cms.models.Role;
import com.zabir.springboot.cms.models.User;
import com.zabir.springboot.cms.payload.request.LoginRequest;
import com.zabir.springboot.cms.payload.request.SignupRequest;
import com.zabir.springboot.cms.payload.response.JwtResponse;
import com.zabir.springboot.cms.payload.response.MessageResponse;
import com.zabir.springboot.cms.repositories.RoleRepository;
import com.zabir.springboot.cms.repositories.UserRepository;
import com.zabir.springboot.cms.security.jwt.JwtUtils;
import com.zabir.springboot.cms.security.services.UserDetailsImpl;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Validated LoginRequest loginRequest) {
		System.out.println("User name is - " +  loginRequest.getUsername());
		System.out.println("User pass is - " +  loginRequest.getPassword());
		if (loginRequest.getUsername() == null ) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username can not be empty"));
		}
		
		
		if (loginRequest.getPassword() == null ) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Password can not be empty"));
		}

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Validated SignupRequest signUpRequest) {
		
		if (signUpRequest.getUsername() == null ) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username can not be empty"));
		}
		
		if (signUpRequest.getEmail() == null ) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email can not be empty"));
		}
		
		if (signUpRequest.getPassword() == null ) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Password can not be empty"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		
		System.out.println("User name is - " +  signUpRequest.getUsername());
		System.out.println("User email is - " +  signUpRequest.getEmail());
		System.out.println("User pass is - " +  signUpRequest.getPassword());
		
		
		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRole(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
