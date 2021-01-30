package cs.spring.petclinic.repository;

import cs.spring.petclinic.model.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinaryRepository extends JpaRepository<Veterinary, Long> {
}
