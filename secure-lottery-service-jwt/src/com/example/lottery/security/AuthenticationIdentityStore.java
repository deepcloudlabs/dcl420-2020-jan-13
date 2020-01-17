package com.example.lottery.security;

import static java.util.Collections.singleton;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import static javax.security.enterprise.identitystore.CredentialValidationResult.NOT_VALIDATED_RESULT;
import static javax.security.enterprise.identitystore.IdentityStore.ValidationType.VALIDATE;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

@RequestScoped
public class AuthenticationIdentityStore implements IdentityStore {

	private Map<String, String> callerToPassword;

	@PostConstruct
	public void init() {
		callerToPassword = new HashMap<>();
		callerToPassword.put("jack", "secret");
		callerToPassword.put("kate", "secret");
	}

	@Override
	public CredentialValidationResult validate(Credential credential) {
		CredentialValidationResult result;

		if (credential instanceof UsernamePasswordCredential) {
			UsernamePasswordCredential usernamePassword = (UsernamePasswordCredential) credential;
			String expectedPW = callerToPassword.get(usernamePassword.getCaller());
			if (expectedPW != null && expectedPW.equals(usernamePassword.getPasswordAsString())) {
				result = new CredentialValidationResult(usernamePassword.getCaller());
			} else {
				result = INVALID_RESULT;
			}
		} else {
			result = NOT_VALIDATED_RESULT;
		}
		return result;
	}

	@Override
	public Set<ValidationType> validationTypes() {
		return singleton(VALIDATE);
	}
}
