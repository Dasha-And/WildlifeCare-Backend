package wildlife.care.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wildlife.care.model.Role;
import wildlife.care.service.RoleService;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping(path = "/role_all")
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @PostMapping(path = "/create_role")
    public ResponseEntity<Role> insert(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.insertRole(role), HttpStatus.CREATED);
    }

    @GetMapping(path = "/role")
    public ResponseEntity<Role> findById(@RequestParam int id) {
        return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/update_role")
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.updateRole(role), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete_role")
    public void deleteRole(@RequestParam int id) {
        roleService.deleteRole(id);
    }
}

