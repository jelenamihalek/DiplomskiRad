package diplomski_rad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diplomski_rad.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
