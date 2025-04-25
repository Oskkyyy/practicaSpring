package com.daw.practicaSpring.controller;

import com.daw.practicaSpring.model.Tarea;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private List<Tarea> tareas = new ArrayList<>();

    public TareaController() {
        tareas.add(new Tarea(1, "Tarea 1", true));
        tareas.add(new Tarea(2, "Tarea 2", false));
        tareas.add(new Tarea(3, "Tarea 3", false));
    }
    @GetMapping
    public List<Tarea> getTareas() {
        return tareas;
    }

    @GetMapping("/{id}")
    public Tarea obtenerPorId(@PathVariable Integer id){
        return  tareas.stream().filter(tarea -> tarea.getId().equals(id)).findFirst().orElse(null);
    }
    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea nueva){
        tareas.add(nueva);
        return nueva;
    }
    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Integer id){
        tareas.remove(tareas.stream().filter(tarea -> tarea.getId().equals(id)).findFirst().orElse(null));
    }
}
