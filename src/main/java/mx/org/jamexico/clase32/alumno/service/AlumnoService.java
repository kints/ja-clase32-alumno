package mx.org.jamexico.clase32.alumno.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.org.jamexico.clase32.alumno.model.Alumno;
import mx.org.jamexico.clase32.alumno.repository.AlumnoRespository;

@Service
public class AlumnoService {
  @Autowired
  private AlumnoRespository alumnoRespository;

  public Alumno altaAlumno(Alumno alumnoReq) {
    alumnoReq.setActivo(true);
    alumnoReq.setFechaBaja(null);
    Alumno alumnoRes = alumnoRespository.save(alumnoReq);
    return alumnoRes;
  }

  public Alumno encuentraAlumnoId(UUID idReq) {
    Optional<Alumno> alumnoOptional = alumnoRespository.findById(idReq);
    if (!alumnoOptional.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró el registro en la Base de Datos");
    }
    Alumno alumnoRes = alumnoOptional.get();
    return alumnoRes;
  }

  public Alumno actualizaAlumno(UUID idReq, Alumno alumnoReq) {
    Alumno alumnoParaActualizar = encuentraAlumnoId(idReq);
    alumnoParaActualizar.setNombre(alumnoReq.getNombre());
    alumnoParaActualizar.setApellidoPaterno(alumnoReq.getApellidoPaterno());
    alumnoParaActualizar.setApellidoMaterno(alumnoReq.getApellidoMaterno());
    alumnoParaActualizar.setCurp(alumnoReq.getCurp());
    alumnoParaActualizar.setGenero(alumnoReq.getGenero());
    alumnoParaActualizar.setFechaNacimiento(alumnoReq.getFechaNacimiento());
    Alumno alumnoRes = alumnoRespository.save(alumnoParaActualizar);
    return alumnoRes;
  }

  public void borrarAlumno(UUID idReq) {
    Alumno alumnoParaBorrar = encuentraAlumnoId(idReq);
    alumnoRespository.delete(alumnoParaBorrar);
  }

}
