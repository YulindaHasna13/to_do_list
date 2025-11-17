package TaskToDoList;

public class ConcretePriorityTask extends Task {
    public ConcretePriorityTask(String title) {
      super(title);
  }

  @Override
  public void displayTask() {
      System.out.println("[Priority] " + title + " - " + (completed ? "Done" : "Pending"));
  }

  @Override
  public void markCompleted() {
      completed = true;
      System.out.println("Priority Task '" + title + "' marked as completed.");
  }
}
