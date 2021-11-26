package wildlife.care.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wildlife.care.model.Worker;
import wildlife.care.service.RoleService;
import wildlife.care.web.model.WorkerDto;

@Component
public class WorkerConverter {
    @Autowired
    RoleService roleService;

    public Worker toDomainModel(WorkerDto workerDto) {
        int roleId = roleService.getIdByName(workerDto.getRole());
        return new Worker(workerDto.getId(), workerDto.getUsername(), workerDto.getName(), workerDto.getSurname(), workerDto.getPassword(), workerDto.getDate_of_birth(), workerDto.getNationalParkId(), roleId);
    }

    public WorkerDto toDto(Worker worker) {
        String roleName = roleService.getNameById(worker.getRole());
        return new WorkerDto(worker.getId(), worker.getUsername(), worker.getName(), worker.getSurname(), worker.getPassword(), worker.getDate_of_birth(), worker.getNationalParkId(), roleName);
    }
}
