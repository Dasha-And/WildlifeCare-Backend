package wildlife.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wildlife.care.model.Role;
import wildlife.care.model.Species;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findById(int id);
    Role findByName(String name);
}
