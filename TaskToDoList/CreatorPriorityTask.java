package TaskToDoList;

public class CreatorPriorityTask extends CreatorTask {
  @Override
    public Task createTask(String title) {
        return new ConcretePriorityTask(title);
    }
}
