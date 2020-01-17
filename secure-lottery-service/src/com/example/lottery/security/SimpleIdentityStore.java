package com.example.lottery.security;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

@ApplicationScoped
public class SimpleIdentityStore implements IdentityStore {

	@Override
	public int priority() {
		return 100;
	}

	@Override
	public CredentialValidationResult validate(Credential credential) {
		UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
		System.out.println(usernamePasswordCredential.getCaller());
		System.out.println(usernamePasswordCredential.getPasswordAsString());
		if (usernamePasswordCredential.compareTo("jack", "secret"))
			return new CredentialValidationResult("jack", new HashSet<>(Arrays.asList("webuser")));
		if (usernamePasswordCredential.compareTo("kate", "secret"))
			return new CredentialValidationResult("kate", new HashSet<>(Arrays.asList("webuser", "admin")));
		return new CredentialValidationResult(usernamePasswordCredential.getCaller());
	}

	@Override
	public Set<ValidationType> validationTypes() {
		return EnumSet.of(ValidationType.VALIDATE);
	}

}
