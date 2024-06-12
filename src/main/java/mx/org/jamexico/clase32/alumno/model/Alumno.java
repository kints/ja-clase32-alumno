package mx.org.jamexico.clase32.alumno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
  private String nombre;
  private int edad;
}
