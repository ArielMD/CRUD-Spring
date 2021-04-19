package mx.uady.sicei.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class Maestro {

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @Positive(message = "El numero de empleado debe ser un numero")
    @NotNull(message = "El numero de empleado no puede estar en blaco")
    private Long numeroEmpleado;

    @PositiveOrZero(message = "Las horas no pueden ser negativas")
    private int horasClase;

    @Email(message = "el correo no es valido")
    @NotBlank(message = "El correo no puede estar en blanco")
    private String correo;

    public Maestro(String nombre, Long numeroEmpleado, int horasClase, String correo) {
        this.nombre = nombre;
        this.numeroEmpleado = numeroEmpleado;
        this.horasClase = horasClase;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(Long numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
