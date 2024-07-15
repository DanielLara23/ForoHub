package com.foro.foroHub.domain.topico;

import com.foro.foroHub.domain.model.DatosTopico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<DatosTopico, Long> {

}
