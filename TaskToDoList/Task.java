package TaskToDoList;

public abstract class Task {
  protected String title;
  protected boolean completed;

  public Task(String title) {
      this.title = title;
      this.completed = false;
  }

  public abstract void displayTask();

  public abstract void markCompleted();

  public void addTask() {
      System.out.println("Adding task: " + title);
  }

  public void editTask(String newTitle) {
      System.out.println("Editing task '" + title + "' to '" + newTitle + "'");
      this.title = newTitle;
  }

  public void deleteTask() {
      System.out.println("Deleting task: " + title);
  }
}
