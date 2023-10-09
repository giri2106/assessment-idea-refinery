# Task Management API

This is a simple RESTful API for managing tasks. You can perform basic Create, Read, Updateoperations on tasks using this API.

## Base Endpoint

All endpoints for this API are relative to the base URL: `/api`

## Task Model

A task object has the following properties:

- `id` (Integer): The unique identifier for the task.
- `title` (String): The title or name of the task.
- `description` (String): A description or additional information about the task.
- `completed` (Boolean): Indicates whether the task is completed (true) or not (false).
- `createDate` (Date): The date when the task was created, formatted as "dd-MM-yyyy".
- `completeDate` (Date): The date when the task was completed (if applicable), formatted as "dd-MM-yyyy".

## Endpoints

### Get All Tasks

- **URL:** `/tasks`
- **Method:** GET
- **Description:** Retrieve a list of all tasks.
- **Response:** JSON array of task objects.
- **Example Request:**
  ```http
  GET /api/tasks
  ```
- **Example Response:**
  ```json
  [
    {
      "id": 1,
      "title": "Task 1",
      "description": "This is the first task",
      "completed": false,
      "createDate": "10-10-2023",
      "completeDate": null
    },
    {
      "id": 2,
      "title": "Task 2",
      "description": "This is the second task",
      "completed": true,
      "createDate": "15-10-2023",
      "completeDate": "20-10-2023"
    }
  ]
  ```

### Get Task by ID

- **URL:** `/tasks/:id`
- **Method:** GET
- **Description:** Retrieve a specific task by its ID.
- **Parameters:** `:id` - The ID of the task to retrieve.
- **Response:** JSON object representing the task.
- **Example Request:**
  ```http
  GET /api/tasks/1
  ```
- **Example Response:**
  ```json
  {
    "id": 1,
    "title": "Task 1",
    "description": "This is the first task",
    "completed": false,
    "createDate": "10-10-2023",
    "completeDate": null
  }
  ```

### Create Task

- **URL:** `/tasks`
- **Method:** POST
- **Description:** Create a new task.
- **Request Body:** JSON object with task details (title, description, completed, createDate, completeDate).
- **Response:** JSON object representing the newly created task.
- **Example Request:**
  ```http
  POST /api/tasks
  ```
  Request Body:
  ```json
  {
    "title": "New Task",
    "description": "This is a new task",
    "completed": false,
    "createDate": "25-10-2023",
    "completeDate": null
  }
  ```
- **Example Response:**
  ```
  task created successfully
  ```

### Update Task by ID

- **URL:** `/tasks/:id`
- **Method:** PUT
- **Description:** Update an existing task by its ID.
- **Parameters:** `:id` - The ID of the task to update.
- **Request Body:** JSON object with task details (title, description, completed, createDate, completeDate).
- **Response:** JSON object representing the updated task.
- **Example Request:**
  ```http
  PUT /api/tasks/1
  ```
  Request Body:
  ```json
  {
    "title": "Updated Task",
    "description": "This task has been updated",
    "completed": true,
    "createDate": "10-10-2023",
    "completeDate": "30-10-2023"
  }
  ```
- **Example Response:**
  ```json
  task updated successfully
  ```

## Error Handling

- If a task with a specified ID does not exist, a 404 Not Found response will be returned.
- Invalid requests or missing parameters will result in appropriate error responses with status codes and error messages.
