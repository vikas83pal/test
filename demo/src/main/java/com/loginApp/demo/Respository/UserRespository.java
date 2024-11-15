import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.loginApp.demo.Model.Users;

@Repository
public interface UserRespository extends MongoRepository<Users, String> {
    Optional<Users> findByUsername(String username);
}
