package com.gustavo.pinto.middlewareservice.domain.dtos;

public class TokenDTO {
   private String token;

   public String getToken() {
      return token;
   }

   public void setToken(String token) {
      this.token = token;
   }

   @Override
   public String toString() {
      return "TokenDTO{" +
              "token='" + token + '\'' +
              '}';
   }
}