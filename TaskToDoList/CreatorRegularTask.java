package TaskToDoList;

public class CreatorRegularTask extends CreatorTask {
  @Override
    public Task createTask(String title) {
        return new ConcreteRegularTask(title);
    }
}
