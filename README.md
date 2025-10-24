# Task Tracker CLI

A simple **command-line application** built in **Java 17** to manage tasks efficiently.  
All tasks are stored in a JSON file, making it lightweight and portable.

project : [https://github.com/JoaoPedro-cody/Task-Tracker-CLI
](https://roadmap.sh/projects/task-tracker)
---

## Installation

### Prerequisites
- **Java 17** or later installed on your machine

### Clone the Repository
```bash
git clone https://github.com/JoaoPedro-cody/Task-Tracker-CLI.git
```

---

## Usage

### Enter src and then compile
```bash
cd src
javac */*.java
```

### Add a new task
```bash
java app.Program add "New Task"
```

### Update a task description by ID
```bash
java app.Program update <task-id> "Updated Task Description"
```

### Delete a task by ID
```bash
java app.Program delete <task-id>
```

### Mark a task as done
```bash
java app.Program mark-done <task-id>
```

### Mark a task as in-progress
```bash
java app.Program mark-in-progress <task-id>
```

---

## List Tasks

- **All tasks**
```bash
java app.Program list
```

- **Completed tasks**
```bash
java app.Program list done
```

- **Pending tasks**
```bash
java app.Program list todo
```

- **In-progress tasks**
```bash
java app.Program list in-progress
```

---

## Example Workflow
```bash
# Add a new task
java app.Program add "Study Java"

# List all tasks
java app.Program list

# Mark the first task as done
java app.Program mark-done 1
```

---

## Features
- Add tasks  
- Update task description by ID  
- Delete tasks  
- Mark tasks as **done** or **in-progress**  
- List tasks by status (all, done, todo, in-progress)  

---

## Author
Developed by **Joao** – [GitHub](https://github.com/JoaoPedro-cody)

