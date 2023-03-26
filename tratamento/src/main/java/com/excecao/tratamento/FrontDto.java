package com.excecao.tratamento;

import jakarta.validation.constraints.NotNull;
public class FrontDto {

    @NotNull
    public String username;
    @NotNull
    public String password;
    @NotNull
    public Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
