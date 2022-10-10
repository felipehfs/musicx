package br.com.example.musicx.controllers;

import br.com.example.musicx.dto.AlbumDTO;
import br.com.example.musicx.models.Album;
import br.com.example.musicx.services.AlbumService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<Album>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(albumService.getAll());
    }

    @PostMapping
    public ResponseEntity<Object> createAlbum(@RequestBody AlbumDTO albumDTO) {
        Album album = new Album();
        BeanUtils.copyProperties(albumDTO, album);
        return ResponseEntity.status(HttpStatus.OK).body(albumService.save(album));
    }
}
