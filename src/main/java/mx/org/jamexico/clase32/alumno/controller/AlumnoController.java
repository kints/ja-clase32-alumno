package mx.org.jamexico.clase32.alumno.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.org.jamexico.clase32.alumno.model.Alumno;
import mx.org.jamexico.clase32.alumno.service.AlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
  @Autowired
  AlumnoService alumnoService;

  @PostMapping("/alta")
  public ResponseEntity<Alumno> altaController(@RequestBody Alumno alumnoReq) {
    Alumno alumnoRes = alumnoService.altaAlumno(alumnoReq);
    return ResponseEntity.ok(alumnoRes);
  }

  @GetMapping("/busca/{idReq}")
  public ResponseEntity<Alumno> getMethodName(@PathVariable UUID idReq) {
    Alumno alumnoRes = alumnoService.encuentraAlumnoId(idReq);
    return ResponseEntity.ok(alumnoRes);
  }

  @PutMapping("/actualiza/{idReq}")
  public ResponseEntity<Alumno> putMethodName(@PathVariable UUID idReq, @RequestBody Alumno alumnoReq) {
    Alumno alumnoRes = alumnoService.actualizaAlumno(idReq, alumnoReq);

    return ResponseEntity.ok(alumnoRes);
  }

  @DeleteMapping("/borrar/{idReq}")
  public ResponseEntity<?> borrarAlumnoController(@PathVariable UUID idReq) {
    alumnoService.borrarAlumno(idReq);
    return ResponseEntity.noContent().build();
  }
}
