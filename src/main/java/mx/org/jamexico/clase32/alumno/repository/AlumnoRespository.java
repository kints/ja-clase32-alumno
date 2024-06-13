package mx.org.jamexico.clase32.alumno.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.org.jamexico.clase32.alumno.model.Alumno;

@Repository
public interface AlumnoRespository extends JpaRepository<Alumno, UUID> {

}
