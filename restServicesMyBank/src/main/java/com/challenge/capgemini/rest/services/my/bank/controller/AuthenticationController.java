package com.challenge.capgemini.rest.services.my.bank.controller;

import com.challenge.capgemini.rest.services.my.bank.constant.Constant;
import com.challenge.capgemini.rest.services.my.bank.entities.AuthenticationModel;
import com.challenge.capgemini.rest.services.my.bank.security.TokenHelper;
import com.challenge.capgemini.rest.services.my.bank.security.UserTokenState;
import java.io.IOException;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {


	@Autowired
	TokenHelper tokenHelper;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//login: user - user
	@PostMapping(value = "/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationModel authenticationModel,
			HttpServletResponse response) throws AuthenticationException, IOException {
                        System.out.println("LLego por aqui");
		// Perform the security
//		final Authentication authentication = authenticationManager
//				.authenticate(new UsernamePasswordAuthenticationToken(authenticationModel.getUsername(),
//						authenticationModel.getPassword()));
//            System.out.println("Llego por aca");
//		// Inject into security context
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//                
//		// token creation
//		User user = (User) authentication.getPrincipal();
		String jws = tokenHelper.generateToken(authenticationModel.getUsername());
		int expiresIn = Constant.EXPIRES_IN;
		// Return the token
		return ResponseEntity.ok(new UserTokenState(jws, expiresIn));
	}
	
	
	@PostMapping(value = "/refresh")
	public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request, HttpServletResponse response,
			Principal principal) {

		String authToken = tokenHelper.getToken(request);

		if (authToken != null && principal != null) {

			// TODO check user password last update
			String refreshedToken = tokenHelper.refreshToken(authToken);

			return ResponseEntity.ok(new UserTokenState(refreshedToken, Constant.EXPIRES_IN));
		} else {
			UserTokenState userTokenState = new UserTokenState();
			return ResponseEntity.accepted().body(userTokenState);
		}
	}
	

}
