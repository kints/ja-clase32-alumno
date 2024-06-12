package mx.org.jamexico.clase32.alumno.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import mx.org.jamexico.clase32.alumno.model.Alumno;

@Controller
public class AlumnoController {

  @GetMapping("/")
  public ResponseEntity<Alumno> getAlumno() {
    Alumno alumno = new Alumno("Arturo Quintos", 38);
    return ResponseEntity.ok().body(alumno);
  }

}
