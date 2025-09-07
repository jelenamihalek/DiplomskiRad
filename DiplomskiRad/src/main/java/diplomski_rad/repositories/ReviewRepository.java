package diplomski_rad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diplomski_rad.models.ReviewModel;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, Long> {

}
