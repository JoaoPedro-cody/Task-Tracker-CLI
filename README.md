# Task Tracker CLI

A simple **command-line application** built in **Java 17** to manage tasks efficiently.  
All tasks are stored in a JSON file, making it lightweight and portable.

---

## 📦 Installation

### Prerequisites
- **Java 17** or later installed on your machine

### Clone the Repository
```bash
git clone git@github.com:JoaoPedro-cody/Task-Tracker-CLI.git
```

---

## 🚀 Usage

### Add a new task
```bash
java -jar task-cli.jar add "New Task"
```

### Update a task description by ID
```bash
java -jar task-cli.jar update <task-id> "Updated Task Description"
```

### Delete a task by ID
```bash
java -jar task-cli.jar delete <task-id>
```

### Mark a task as done
```bash
java -jar task-cli.jar mark-done <task-id>
```

### Mark a task as in-progress
```bash
java -jar task-cli.jar mark-in-progress <task-id>
```

---

## 📋 List Tasks

- **All tasks**
```bash
java -jar task-cli.jar list
```

- **Completed tasks**
```bash
java -jar task-cli.jar list done
```

- **Pending tasks**
```bash
java -jar task-cli.jar list todo
```

- **In-progress tasks**
```bash
java -jar task-cli.jar list in-progress
```

---

## 🔄 Example Workflow
```bash
# Add a new task
java -jar task-cli.jar add "Study Java"

# List all tasks
java -jar task-cli.jar list

# Mark the first task as done
java -jar task-cli.jar mark-done 1
```

---

## ✅ Features
- Add tasks  
- Update task description by ID  
- Delete tasks  
- Mark tasks as **done** or **in-progress**  
- List tasks by status (all, done, todo, in-progress)  

---

## 👨‍💻 Author
Developed by **Joao** – [GitHub](https://github.com/JoaoPedro-cody)

