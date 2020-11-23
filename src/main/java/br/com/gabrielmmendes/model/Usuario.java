package br.com.gabrielmmendes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario {

    @Id
    private Long codigo;
    private String nomeCompleto;
    private String nomeSocial;
    private Date dataNascimento;
    private String sexo;
    private String email;
    private String estado;
    private String municipio;
    private Integer numeroAcessosCurso;
    private String situacaoCurso;
    private Date dataVinculo;
}
