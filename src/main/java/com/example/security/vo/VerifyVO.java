package com.example.security.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VerifyVO {
    private String verify;
    private String imageBase64;
}
