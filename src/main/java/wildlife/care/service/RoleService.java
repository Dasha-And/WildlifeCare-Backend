package wildlife.care.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wildlife.care.model.Role;
import wildlife.care.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(int id) {
        return roleRepository.findById(id);
    }

    public Role insertRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    public void deleteRole(int id) {
        roleRepository.deleteById(id);
    }

    public String getNameById(int id) {
        return roleRepository.findById(id).getName();
    }

    public int getIdByName(String name) {
        return roleRepository.findByName(name).getId();
    }

    public String getIconUrlByName(String name) {
        return roleRepository.findByName(name).getIcon_url();
    }
}

