package com.example.Library.dto;

public record UserDetailDTO(
    UserDTO user, String country, String city, String street, String house) {}
