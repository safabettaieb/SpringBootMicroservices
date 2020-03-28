package com.safa.userservice.config.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safa.userservice.dto.LoginRequest;
import com.safa.userservice.dto.UserDTO;
import com.safa.userservice.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private UserService userService;
	private Environment environment;

	public AuthenticationFilter(UserService userService, Environment environment,
			AuthenticationManager authenticationManager) {
		this.userService = userService;
		this.environment = environment;
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {
			LoginRequest loginRequest =new ObjectMapper()
                    .readValue(request.getInputStream(), LoginRequest.class);
			return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
					loginRequest.getEmail(), loginRequest.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		String email = ((User) authResult.getPrincipal()).getUsername();
		UserDTO userDTO = userService.getUserByEmail(email);

		String token = Jwts.builder().setSubject(userDTO.getEmail())
				.setExpiration(new Date(
						System.currentTimeMillis() + Long.parseLong(environment.getProperty("token.expiration_time"))))
				.signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret")).compact();

		response.addHeader("token", token);
		response.addHeader("email", email);
	}

}