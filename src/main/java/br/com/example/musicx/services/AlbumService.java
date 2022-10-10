package br.com.example.musicx.services;

import br.com.example.musicx.models.Album;
import br.com.example.musicx.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    @Transactional
    public Album save(Album album) {
        return albumRepository.save(album);
    }

    public List<Album> getAll() {
        return albumRepository.findAll();
    }
}
