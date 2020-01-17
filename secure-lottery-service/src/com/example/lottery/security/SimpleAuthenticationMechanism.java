package com.example.lottery.security;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.IdentityStore;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.glassfish.soteria.Utils;

@ApplicationScoped
public class SimpleAuthenticationMechanism implements HttpAuthenticationMechanism {

	@Inject
	private IdentityStore identityStore;

	public SimpleAuthenticationMechanism() {
		System.out.println("SimpleAuthenticationMechanism is created.");
	}

	@PostConstruct
	public void init() {
		System.out.println("identityStore is " + identityStore.getClass());
	}

	@Override
	public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response,
			HttpMessageContext httpMessageContext) throws AuthenticationException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if (Utils.notNull(name, password)) {
			AuthenticationStatus containerNotification = httpMessageContext
					.notifyContainerAboutLogin(identityStore.validate(new UsernamePasswordCredential(name, password)));
			if (containerNotification == AuthenticationStatus.SUCCESS)
				request.getSession().setAttribute("authenticated",true);
			return containerNotification;
		}
		if (Boolean.TRUE.equals(request.getSession().getAttribute("authenticated")))
			return AuthenticationStatus.SUCCESS;

		if (httpMessageContext.isProtected()) {
			return httpMessageContext.responseUnauthorized();
		}

		return httpMessageContext.doNothing();
	}

}
