package com.unicap.adotai.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
public class AdotanteDTO {

    @NotBlank(message = "O nome não pode estar em branco.")
    private String nome;

    @NotBlank(message = "A data de nascimento não pode estar em branco.")
    private String dtnascimento;

    @NotBlank(message = "O CPF/CNPJ não pode estar em branco.")
    private String cpfCnpj;

    @NotBlank(message = "O email não pode estar em branco.")
    @Email(message = "O email deve ser válido.")
    private String email;

    @JsonIgnore
    @NotBlank(message = "A senha não pode estar em branco.")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
    private String senha;

    @NotBlank(message = "O telefone não pode estar em branco.")
    private String telefone;

    @NotBlank(message = "O endereço não pode estar em branco.")
    private String endereco;

    @NotBlank(message = "A cidade não pode estar em branco.")
    private String cidade;

    @NotBlank(message = "O estado não pode estar em branco.")
    private String estado;

    public void setSenha(String senha) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.senha = passwordEncoder.encode(senha);
    }
}
