package group.msg.at.cloud.cloudtrain.core.boundary;

import group.msg.at.cloud.cloudtrain.core.control.TaskRepository;
import group.msg.at.cloud.cloudtrain.core.control.UserPermissionVerifier;
import group.msg.at.cloud.cloudtrain.core.entity.Task;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * Simple {@code Boundary} that manages {@code Task} entities.
 */
@Stateless
@RolesAllowed("CLOUDTRAIN_USER")
public class TaskManagement {

    @Inject
    UserPermissionVerifier verifier;
    @Inject
    private TaskRepository repository;

    @NotNull
    public UUID addTask(@NotNull @Valid Task newTask) {
        verifier.requirePermission("TASK_CREATE");
        return this.repository.addTask(newTask);
    }

    public void modifyTask(@NotNull @Valid Task modifiedTask) {
        verifier.requirePermission("TASK_UPDATE");
        this.repository.setTask(modifiedTask);
    }

    public Task getTaskById(@NotNull UUID taskId) {
        Task result = this.repository.getTaskById(taskId);
        if (result != null) {
            verifier.requirePermission("TASK_READ");
        }
        return result;
    }

    public void removeTask(@NotNull UUID taskId) {
        Task found = this.repository.getTaskById(taskId);
        if (found != null) {
            verifier.requirePermission("TASK_DELETE");
            repository.removeTaskById(found.getId());
        }
    }

    public List<Task> getAllTasks() {
        return this.repository.getAllTasks();
    }
}
