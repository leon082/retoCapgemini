package com.challenge.capgemini.rest.services.my.bank.security;

import com.challenge.capgemini.rest.services.my.bank.constant.Constant;
import com.challenge.capgemini.rest.services.my.bank.constant.Constant.TokenParameter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
//Token
@Component
public class TokenHelper {

	private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

	public String generateToken(String username) {
		Date now = new Date();
		return Jwts.builder().setIssuer("webServiesMyBank").setSubject(username).setAudience(Constant.DEVICE)
				.setIssuedAt(now).setExpiration(new Date(now.getTime() + Constant.EXPIRES_IN * 1000))
				.signWith(SIGNATURE_ALGORITHM, Constant.SECRET).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final Claims dataToken = getAllClaimsFromToken(token);
		final String username = dataToken.getSubject();
		final Date expiration = dataToken.getExpiration();
		System.err.println("userName token: " + username + " userName UserDetail: " + userDetails.getUsername()
				+ " dateExpiration token " + expiration.toString() + " dateExpiration " + new Date().toString());
		return (username != null && username.equals(userDetails.getUsername()) && new Date().before(expiration));
	}

	public String refreshToken(String token) {
		String refreshedToken;
		Date now = new Date();
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			claims.setIssuedAt(now);
			refreshedToken = Jwts.builder().setClaims(claims)
					.setExpiration(new Date(now.getTime() + Constant.EXPIRES_IN * 1000))
					.signWith(SIGNATURE_ALGORITHM, Constant.SECRET).compact();
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}

	private Claims getAllClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(Constant.SECRET).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	public Object GetClimb(String token, TokenParameter key) {
		final Claims dataToken = getAllClaimsFromToken(token);
		Object response = null;
		if (dataToken != null) {
			switch (key) {
			case USER:
				response = dataToken.getSubject();
				break;
			case CREATED:
				response = dataToken.getIssuedAt();
				break;
			case EXPIRATION:
				response = dataToken.getExpiration();
				break;
			case AUDIENCE:
				response = dataToken.getAudience();
				break;
			}
		}
		return response;
	}

	public String getToken(HttpServletRequest request) {
		String authHeader = getAuthHeaderFromHeader(request);
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.substring(7);
		}

		return null;
	}

	public String getAuthHeaderFromHeader(HttpServletRequest request) {
		return request.getHeader(Constant.HEADER);
	}

}
