package br.com.example.musicx.repositories;

import br.com.example.musicx.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, UUID> {
    boolean existsByName(String name);
}
