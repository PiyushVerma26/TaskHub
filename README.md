# The TaskHub Application Documentation

## Introduction
The TaskHub Application is a task management application that allows users to create and manage tasks. It follows the MVVM (Model-View-ViewModel) design pattern and utilizes local storage for data persistence using the Room database library.

## Features
The TaskHub Application offers the following features:

1. **Task Creation**: Users can create tasks by providing a title and description for each task.
2. **Task Listing**: All created tasks are displayed in a list format, showing the task title and description.
3. **Task Editing**: Users can edit the title and description of existing tasks.
4. **Task Deletion**: Users can delete tasks that are no longer needed.
5. **Data Persistence**: All tasks created by the user are saved locally using the Room database, allowing for data persistence across application launches.

## Installation
To install and run the TaskHub Application, follow these steps:

1. Clone the application repository from [GitHub Repository URL].
2. Open the project in [IDE of your choice] (e.g., Android Studio).
3. Build the project to resolve dependencies and compile the code.
4. Run the application on an Android emulator or physical device.

## Usage
Upon launching the TaskHub Application, users will be presented with the main screen, which displays the list of created tasks. Users can interact with the application in the following ways:

### Creating a Task
1. Click on the "+" button or the "Add Task" option to create a new task.
2. Enter a title and description for the task in the provided fields.
3. Click on the "Save" button to save the task. The task will appear in the task list.

### Editing a Task
1. Click on the desired task in the task list to open the task details screen.
2. Click on the "Edit" button to enable editing mode.
3. Modify the title or description of the task as desired.
4. Click on the "Save" button to save the changes.

### Deleting a Task
1. Click and hold on a task in the task list.
2. A confirmation dialog will appear, asking for confirmation to delete the task.
3. Click on the "Delete" button to remove the task from the list.

## Data Persistence
The TaskHub Application utilizes the Room database library for local data storage. The Room database provides an abstraction layer over SQLite, making it easier to work with and manage data. The application's data, including task titles and descriptions, are saved locally using Room's entity and DAO (Data Access Object) classes.

The Room database allows for efficient querying and retrieval of tasks, providing a seamless experience to the user. By utilizing local storage, The TaskHub Application ensures that tasks remain available even when the application is closed or the device is restarted.

## Conclusion
The TaskHub Application offers a convenient and intuitive way to manage tasks using the MVVM design pattern. With its ability to create, edit, and delete tasks, along with data persistence using Room database, the application provides users with a reliable task management solution.

Feel free to explore the application and organize your tasks efficiently!
