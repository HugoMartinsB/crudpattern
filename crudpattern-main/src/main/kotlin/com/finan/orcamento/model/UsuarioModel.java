package com.finan.orcamento.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="usuario")
public class UsuarioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Notblank
    @Column(name="nome_usuario")
    private String nomeUsuario;

    @JsonIgnore
    @OneToMany(mappedBy ="Id")
    private List<OrcamentoModel> Orcamentos = new ArrayList<>();
}
