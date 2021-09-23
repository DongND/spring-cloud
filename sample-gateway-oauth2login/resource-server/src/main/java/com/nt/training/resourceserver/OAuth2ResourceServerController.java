
package com.nt.training.resourceserver;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuth2ResourceServerController {

	@GetMapping("/resource")
	public String resource(@AuthenticationPrincipal Jwt jwt) {
		System.out.println("Received Token: " + jwt.getTokenValue());
		return String.format("Resource accessed by %s (sub)", jwt.getSubject());
	}
}