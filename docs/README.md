# Nova User Guide

Nova is a **command-line task manager chatbot** that helps you organize and track your tasks efficiently.
Using simple text commands, you can manage **todos, deadlines, and events**, mark tasks as done, delete tasks, and search for tasks.

---

# Quick Start

Follow these steps to start using Nova.

1. Ensure **Java 17 or later** is installed on your computer.
2. Download the latest `Nova.jar` file from the project releases.
3. Open a terminal in the folder containing the jar file.
4. Run the command:

```
java -jar Nova.jar
```

5. You should see the welcome message:

```
Hello! I'm Nova
What can I do for you?
```

You can now start entering commands.

---

# Command Summary

| Command                                 | Description                         |
| --------------------------------------- | ----------------------------------- |
| `todo DESCRIPTION`                      | Adds a new todo task                |
| `deadline DESCRIPTION /by DATE`         | Adds a task with a deadline         |
| `event DESCRIPTION /from START /to END` | Adds an event with a time range     |
| `list`                                  | Displays all tasks                  |
| `mark TASK_NUMBER`                      | Marks a task as completed           |
| `unmark TASK_NUMBER`                    | Marks a task as not completed       |
| `delete TASK_NUMBER`                    | Deletes a task                      |
| `find KEYWORD`                          | Searches tasks containing a keyword |
| `bye`                                   | Exits the chatbot                   |

---

# Features

## Adding a Todo

Adds a simple task without any associated date or time.

**Format**

```
todo DESCRIPTION
```

**Example**

```
todo read book
```

---

## Adding a Deadline

Adds a task that must be completed before a specified date.

**Format**

```
deadline DESCRIPTION /by DATE
```

**Example**

```
deadline return book /by Sunday
```

---

## Adding an Event

Adds a task that occurs within a specific time period.

**Format**

```
event DESCRIPTION /from START /to END
```

**Example**

```
event project meeting /from Mon 2pm /to 4pm
```

---

## Listing Tasks

Displays all tasks currently stored in Nova.

**Format**

```
list
```

**Example Output**

```
Here are the tasks in your list:
1. [T][ ] read book
2. [D][ ] return book (by: Sunday)
```

---

## Marking a Task as Done

Marks a task as completed.

**Format**

```
mark TASK_NUMBER
```

**Example**

```
mark 2
```

---

## Unmarking a Task

Marks a completed task as not done.

**Format**

```
unmark TASK_NUMBER
```

**Example**

```
unmark 2
```

---

## Deleting a Task

Removes a task from the task list.

**Format**

```
delete TASK_NUMBER
```

**Example**

```
delete 3
```

---

## Finding Tasks

Searches for tasks that contain a specific keyword in their description.

**Format**

```
find KEYWORD
```

**Example**

```
find book
```

**Example Output**

```
Here are the matching tasks in your list:
1. [T][ ] read book
2. [D][ ] return book (by: Sunday)
```

---

## Exiting Nova

Closes the chatbot.

**Format**

```
bye
```

---

# Notes

* Commands are **case-insensitive** (`LIST`, `List`, `list` all work).
* Task numbers correspond to the order shown in the **list command**.
* Ensure commands follow the correct format to avoid errors.

---

# Data Storage

Nova automatically saves tasks to a local file so that your tasks remain available even after the program is closed.
The task data is stored locally and will be loaded again when Nova starts.
