package com.github.alinaberlin.security.payload.request;

import java.util.Objects;

public class LoginRequest {
    private String email;
    private String pasword;

    public LoginRequest(String email, String paswword) {
        this.email = email;
        this.pasword = paswword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String paswword) {
        this.pasword = paswword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginRequest that = (LoginRequest) o;
        return Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPasword(), that.getPasword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPasword());
    }

    @Override
    public String toString() {
        return "{" +
                "email='" + email + '\'' +
                ", pasword='" + pasword + '\'' +
                '}';
    }
}
