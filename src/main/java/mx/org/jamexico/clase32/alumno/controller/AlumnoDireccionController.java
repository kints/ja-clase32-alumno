package mx.org.jamexico.clase32.alumno.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import mx.org.jamexico.clase32.alumno.model.Direccion;
import mx.org.jamexico.clase32.alumno.resource.AlumnoDireccionResource;
import mx.org.jamexico.clase32.alumno.service.AlumnoDireccionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/alumnoDireccion")
public class AlumnoDireccionController {

  @Autowired
  AlumnoDireccionService alumnoDireccionService;

  @PostMapping("/altaDireccion/{idAlumno}")
  public ResponseEntity<AlumnoDireccionResource> altaDireccionAlumno(@PathVariable UUID idAlumno,
      @RequestBody Direccion direccion) {

    return ResponseEntity.ok(
        alumnoDireccionService.crearDireccionAlumno(idAlumno, direccion));
  }

  @GetMapping("/encuentra/{idAlumno}")
  public ResponseEntity<AlumnoDireccionResource> regresaDireccionAlumno(@PathVariable UUID idAlumno) {
    return ResponseEntity.ok(
        alumnoDireccionService.encuentraDireccionAlumno(idAlumno));
  }

}
