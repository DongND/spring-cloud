package com.nt.training.gwclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class GatewayApplication {

	@Autowired
	private TokenRelayGatewayFilterFactory filterFactory;

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		//@formatter:off
		return builder.routes()
				.route("resource", r -> r.path("/resource")
						.filters(f -> f.filter(filterFactory.apply()))
						.uri("http://localhost:9000"))
				.build();
		//@formatter:on
	}

	@GetMapping("/")
	public String index(Model model,
						@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
						@AuthenticationPrincipal OAuth2User oauth2User) {
		model.addAttribute("userName", oauth2User.getName());
		model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
		model.addAttribute("userAttributes", oauth2User.getAttributes());
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}