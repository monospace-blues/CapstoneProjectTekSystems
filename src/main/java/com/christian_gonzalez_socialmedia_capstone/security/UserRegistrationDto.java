package com.christian_gonzalez_socialmedia_capstone.security;

import javax.validation.constraints.AssertTrue;
// import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
    @FieldMatch(first = "username", second = "confirmUsername", message = "The username fields must match")
})
public class UserRegistrationDto {

    @NotEmpty
    private String username;

	@NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @AssertTrue
    private Boolean terms;
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Boolean getTerms() {
        return terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }
}