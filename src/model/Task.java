package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class Task {
    private Integer id;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;

    public Task() {
    }

    public Task(Integer id, String description) {
        this.id = id;
        this.description = description;
        this.status = "Todo";
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.updatedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static Task fromJson(String json) {
        json = json.replace("{", "")
                .replace("}", "")
                .trim();

        String[] jsons = json.split(",");

        String id = jsons[0].split(":", 2)[1].replace("\"", "").strip();
        String description = jsons[1].split(":", 2)[1].replace("\"", "").strip();
        String status = jsons[2].split(":", 2)[1].replace("\"", "").strip();
        String createdAt = jsons[3].split(":", 2)[1].replace("\"", "").strip();
        String updatedAt = jsons[4].split(":", 2)[1].replace("\"", "").strip();

        Task task = new Task();
        task.setId(Integer.parseInt(id));
        task.setDescription(description);
        task.setStatus(status);
        task.setCreatedAt(createdAt);
        task.setUpdatedAt(updatedAt);

        return task;
    }

    public String toJson(){
        return "{\"id\":\"" + id + "\", \"description\":\"" + description.strip() + "\", \"status\":\"" + status +
                "\", \"createdAt\":\"" + createdAt + "\", \"updatedAt\":\"" + updatedAt + "\"}";
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
