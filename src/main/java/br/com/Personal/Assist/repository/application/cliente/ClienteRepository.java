package br.com.Personal.Assist.repository.application.cliente;

import br.com.Personal.Assist.model.application.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
