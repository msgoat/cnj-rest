package group.msg.at.cloud.cloudtrain.core.boundary;

import group.msg.at.cloud.cloudtrain.core.control.TaskRepository;
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
    private TaskRepository repository;

    @NotNull
    public UUID addTask(@NotNull @Valid Task newTask) {
        return this.repository.addTask(newTask);
    }

    public void modifyTask(@NotNull @Valid Task modifiedTask) {
        this.repository.setTask(modifiedTask);
    }

    public Task getTaskById(@NotNull UUID taskId) {
        return this.repository.getTaskById(taskId);
    }

    public void removeTask(@NotNull UUID taskId) {
        this.repository.removeTaskById(taskId);
    }

    public List<Task> getAllTasks() {
        return this.repository.getAllTasks();
    }
}
