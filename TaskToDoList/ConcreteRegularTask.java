package TaskToDoList;

public class ConcreteRegularTask extends Task {
    public ConcreteRegularTask(String title) {
      super(title);
  }

  @Override
  public void displayTask() {
      System.out.println("[Regular] " + title + " - " + (completed ? "Done" : "Pending"));
  }

  @Override
  public void markCompleted() {
      completed = true;
      System.out.println("Task '" + title + "' marked as completed.");
  }
}
