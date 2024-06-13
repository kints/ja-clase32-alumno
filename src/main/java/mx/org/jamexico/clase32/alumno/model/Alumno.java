package mx.org.jamexico.clase32.alumno.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alumno")
public class Alumno {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  @Enumerated(EnumType.ORDINAL)
  private Genero genero;
  @Enumerated(EnumType.STRING)
  private TipoSangre tipoSangre;
  @Column(name = "curp")
  private String curp;
  private LocalDate fechaNacimiento;
  private boolean activo;
  private LocalDate fechaBaja;

}
