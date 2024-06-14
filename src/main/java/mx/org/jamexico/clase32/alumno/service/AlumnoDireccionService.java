package mx.org.jamexico.clase32.alumno.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.org.jamexico.clase32.alumno.model.Alumno;
import mx.org.jamexico.clase32.alumno.model.Direccion;
import mx.org.jamexico.clase32.alumno.repository.DireccionRepository;
import mx.org.jamexico.clase32.alumno.resource.AlumnoDireccionResource;

@Service
public class AlumnoDireccionService {

  @Autowired
  private AlumnoService alumnoService;
  @Autowired
  private DireccionRepository direccionRepository;

  public AlumnoDireccionResource crearDireccionAlumno(UUID idAlumno, Direccion direccionReq) {
    Alumno alumno = alumnoService.encuentraAlumnoId(idAlumno);
    direccionReq.setAlumno(alumno);
    direccionReq = direccionRepository.save(direccionReq);
    return contruyeAlumnoDireccionResource(direccionReq, alumno);
  }

  private AlumnoDireccionResource contruyeAlumnoDireccionResource(Direccion direccionReq, Alumno alumno) {
    AlumnoDireccionResource alumnoDireccionResource = new AlumnoDireccionResource();
    alumnoDireccionResource.setNombre(alumno.getNombre());
    alumnoDireccionResource.setApellidoPaterno(alumno.getApellidoPaterno());
    alumnoDireccionResource.setApellidoMaterno(alumno.getApellidoMaterno());
    alumnoDireccionResource.setCalle(direccionReq.getCalle());
    alumnoDireccionResource.setNumeroExterior(direccionReq.getNumeroExterior());
    alumnoDireccionResource.setColonia(direccionReq.getColonia());
    alumnoDireccionResource.setNumeroInterior(direccionReq.getNumeroInterior());
    alumnoDireccionResource.setMunicipio(direccionReq.getMunicipio());
    alumnoDireccionResource.setCodigoPostal(direccionReq.getCodigoPostal());
    alumnoDireccionResource.setEstado(direccionReq.getEstado());
    alumnoDireccionResource.setPais(direccionReq.getPais());
    return alumnoDireccionResource;
  }

  public AlumnoDireccionResource encuentraDireccionAlumno(UUID idAlumno) {
    Alumno alumno = alumnoService.encuentraAlumnoId(idAlumno);
    if (alumno.getDireccion() == null) {
      return null;
    }
    Direccion direccion = alumno.getDireccion();
    return contruyeAlumnoDireccionResource(direccion, alumno);
  }

}
