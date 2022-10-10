package br.com.example.musicx.controllers;

import br.com.example.musicx.dto.ArtistDTO;
import br.com.example.musicx.models.Artist;
import br.com.example.musicx.services.ArtistService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/artists")
public class ArtistController {
    final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public ResponseEntity<Object> saveArtist(@RequestBody @Valid ArtistDTO artistDTO) {
        if (artistService.existsByName(artistDTO.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Name already exists in database");
        }
        Artist artist = new Artist();
        BeanUtils.copyProperties(artistDTO, artist);
        artist.setRating(0);
        return ResponseEntity.status(HttpStatus.CREATED).body(artistService.save(artist));
    }

    @GetMapping
    public ResponseEntity<List<Artist>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(artistService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneById(@PathVariable(value = "id")UUID id) {
        Optional<Artist> artistOptional = artistService.findById(id);
        if (!artistOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Artist not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(artistOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateArtist(@PathVariable(value = "id") UUID id, @RequestBody @Valid ArtistDTO artistDTO) {
        Optional<Artist> artistOptional = artistService.findById(id);
        if (!artistOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Artist not found");
        }
        Artist artist = new Artist();
        BeanUtils.copyProperties(artistDTO, artist);
        artist.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(artistService.save(artist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeArtist(@PathVariable(value = "id") UUID id) {
        Optional<Artist> artistOptional = artistService.findById(id);
        if (!artistOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Artist not found");
        }
        artistService.remove(artistOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Artist delete successfully");
    }
}
