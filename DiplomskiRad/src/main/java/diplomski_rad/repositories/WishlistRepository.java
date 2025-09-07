package diplomski_rad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diplomski_rad.models.WishlistModel;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistModel, Long> {

}
