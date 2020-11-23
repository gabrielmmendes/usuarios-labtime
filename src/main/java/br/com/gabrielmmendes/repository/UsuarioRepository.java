package br.com.gabrielmmendes.repository;

import br.com.gabrielmmendes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
