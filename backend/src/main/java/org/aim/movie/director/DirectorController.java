package org.aim.movie.director;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api/directors")
public class DirectorController {
    @Autowired
    private DirectorRepository directorRepository;

    @GetMapping(path = "")
    public Iterable<Director> getAllDirecors() {
        return directorRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Director getDirector(@PathVariable(value = "id") Integer id, HttpServletResponse response) {
        Optional<Director> director = directorRepository.findById(id);

        try {
            return director.get();

        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }
        return null;
    }

    @PostMapping(path = "/")
    public @ResponseBody String createDirector(@RequestBody Director director) {
        directorRepository.save(director);
        return "Saved";
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateDirector(@PathVariable(value = "id") Integer id,
            @RequestBody Director directorDetails) {
        Optional<Director> optialDirector = directorRepository.findById(id);
        Director director = optialDirector.get();

        director.setFirstName(directorDetails.getFirstName());
        director.setLastName(directorDetails.getLastName());
        director.setDateOfBirth(directorDetails.getDateOfBirth());

        directorRepository.save(director);
        return "Updated";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteActor(@PathVariable(value = "id") Integer id) {
        directorRepository.deleteById(id);
        return "Deleted";
    }

}