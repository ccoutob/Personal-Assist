package br.com.Personal.Assist.repository.cliente;

import br.com.Personal.Assist.model.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
