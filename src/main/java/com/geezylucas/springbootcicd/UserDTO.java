package com.geezylucas.springbootcicd;

public record UserDTO(String username,
                      String firstName,
                      String lastName,
                      int age,
                      String email) {
}
