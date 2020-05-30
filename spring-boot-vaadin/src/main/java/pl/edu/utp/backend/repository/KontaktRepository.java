package pl.edu.utp.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.edu.utp.backend.entity.Kontakt;

public interface KontaktRepository extends JpaRepository<Kontakt, Long> {
	@Query("SELECT k FROM Kontakt k WHERE lower(k.imie) LIKE lower(concat('%', :warunekSzukania, '%')) OR lower(k.nazwisko) LIKE lower(concat('%', :warunekSzukania, '%'))")
	List<Kontakt> search(@Param("warunekSzukania") String warunekSzukania);
}