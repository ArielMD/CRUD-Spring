package mx.uady.sicei.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mx.uady.sicei.exception.NotFoundException;
import mx.uady.sicei.model.Maestro;

@Service
public class MaestroService {

    private List<Maestro> maestros = new LinkedList<>();

    {
        maestros.add(new Maestro("maestro 1", (long) 00001, 2, "maestro1@correo.com"));
        maestros.add(new Maestro("maestro 2", (long) 00002, 2, "maestro2@correo.com"));
        maestros.add(new Maestro("maestro 3", (long) 00003, 2, "maestro3@correo.com"));
        maestros.add(new Maestro("maestro 4", (long) 00004, 2, "maestro4@correo.com"));
    }

    public List<Maestro> getMaestros() {
        return maestros;
    }

    public Maestro getMaestro(Long numeroEmpleado) {
        return maestros.stream().filter(m -> m.getNumeroEmpleado() == numeroEmpleado).findFirst()
                .orElseThrow(() -> new NotFoundException());
    }

    public Maestro crearMaestro(Maestro maestro) {
        maestros.add(maestro);
        return maestro;
    }

    public Maestro editarMaestro(long numeroEmpleado, Maestro maestro) {
        Optional<Maestro> encontrado = maestros.stream().filter(m -> numeroEmpleado == (m.getNumeroEmpleado()))
                .findFirst();

        if (!encontrado.isPresent()) {
            throw new NotFoundException();
        }
        encontrado.get().setNombre(maestro.getNombre());
        encontrado.get().setCorreo(maestro.getCorreo());
        encontrado.get().setHorasClase(maestro.getHorasClase());
        return encontrado.get();
    }

    public void eliminarMaestro(long numeroEmpleado) {
        boolean eliminado = maestros.removeIf(maestro -> maestro.getNumeroEmpleado() == numeroEmpleado);
        if (!eliminado) {
            throw new NotFoundException();
        }
    }

}
