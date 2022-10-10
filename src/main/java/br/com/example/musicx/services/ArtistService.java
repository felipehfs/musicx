package br.com.example.musicx.services;

import br.com.example.musicx.models.Artist;
import br.com.example.musicx.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArtistService {
    @Autowired
    ArtistRepository artistRepository;

    @Transactional
    public Object save(Artist artist) {
        return artistRepository.save(artist);
    }

    public boolean existsByName(String name) {
        return artistRepository.existsByName(name);
    }

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Optional<Artist> findById(UUID uuid) {
        return artistRepository.findById(uuid);
    }

    @Transactional
    public void remove(Artist artist) {
        artistRepository.delete(artist);
    }
}
