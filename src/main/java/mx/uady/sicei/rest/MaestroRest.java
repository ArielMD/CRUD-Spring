package mx.uady.sicei.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

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

import mx.uady.sicei.model.Maestro;
import mx.uady.sicei.service.MaestroService;

@RestController
@RequestMapping("/api")
public class MaestroRest {
    @Autowired
    private MaestroService maestroService;

    @GetMapping("/maestros")
    public ResponseEntity<List<Maestro>> getMaestros() {
        return ResponseEntity.ok().body(maestroService.getMaestros());
    }

    @GetMapping("/maestros/{numeroEmpleado}")
    public ResponseEntity<Maestro> getMaestro(@PathVariable Long numeroEmpleado) {
        return ResponseEntity.ok().body(maestroService.getMaestro(numeroEmpleado));
    }

    @PostMapping("/maestros")
    public ResponseEntity<Maestro> crearMaestro(@Valid @RequestBody Maestro maestro) throws URISyntaxException {
        Maestro maestroCreado = maestroService.crearMaestro(maestro);
        return ResponseEntity.created(new URI("/maestros/" + maestroCreado.getNumeroEmpleado())).body(maestroCreado);
    }

    @PutMapping("/maestros/{numeroEmpleado}")
    public ResponseEntity<Maestro> editarMaestro(@PathVariable long numeroEmpleado,
            @Valid @RequestBody Maestro maestro) {
        return ResponseEntity.ok().body(maestroService.editarMaestro(numeroEmpleado, maestro));
    }

    @DeleteMapping("/maestros/{numeroEmpleado}")
    public ResponseEntity<Void> eliminarMaestro(@PathVariable long numeroEmpleado) {
        maestroService.eliminarMaestro(numeroEmpleado);
        return ResponseEntity.ok().build();
    }
}
