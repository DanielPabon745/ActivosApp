package com.activos.activos_fijos.security;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.activos.activos_fijos.dtos.TokenResponseDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTConfig {

	@Value("${security.jwt.uri:/users/auth/**}")
	private String uri;

	@Value("${security.jwt.header:Authorization}")
	private String header;

	@Value("${security.jwt.prefix:Bearer }")
	private String prefix;

	@Value("${security.jwt.expiration:#{24*60*60}}")
	private int expiration;

	@Value("${security.jwt.secret:JwtSecretKey}")
	private String secret;

	public TokenResponseDTO generateToken(Authentication auth) {
		Long now = System.currentTimeMillis();
		Date expiration = new Date(now + this.expiration * 1000);
		String token = Jwts.builder()
			.setSubject(auth.getName())	
			// Convert to list of strings. 
			// This is important because it affects the way we get them back in the Gateway.
			.claim("authorities", auth.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
			.setIssuedAt(new Date(now))
			.setExpiration(expiration)  // in milliseconds
			.signWith(SignatureAlgorithm.HS512, secret.getBytes())
			.compact();
		TokenResponseDTO responseDTO = new TokenResponseDTO();
		responseDTO.setExpiration(expiration);
		responseDTO.setCreatedAt(new Date(now));
		responseDTO.setToken(this.prefix + token);
		responseDTO.setType(this.prefix);
		return responseDTO;
	}

	public String getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public String getUri() {
		return uri;
	}

	public String getHeader() {
		return header;
	}

	public String getPrefix() {
		return prefix;
	}

	public int getExpiration() {
		return expiration;
	}

	public String getSecret() {
		return secret;
	}

}
