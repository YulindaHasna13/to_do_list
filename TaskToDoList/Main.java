package TaskToDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        CreatorTask regularCreator = new CreatorRegularTask();
        CreatorTask priorityCreator= new CreatorPriorityTask();

        boolean running = true;

        while (running) {
            System.out.println("\n=== TASK TO-DO LIST ===");
            System.out.println("1. Tambah Task");
            System.out.println("2. Lihat Semua Task");
            System.out.println("3. Tandai Task Selesai");
            System.out.println("4. Edit Task");
            System.out.println("5. Hapus Task");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Judul Task: ");
                    String title = scanner.nextLine();
                    System.out.print("Jenis Task (1. Regular, 2. Priority): ");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    Task newTask = (type == 2)
                            ? priorityCreator.createTask(title)
                            : regularCreator.createTask(title);
                    taskList.add(newTask);
                    System.out.println("✅ Task berhasil ditambahkan.");
                    break;

                case 2:
                    if (taskList.isEmpty()) {
                        System.out.println("📭 Tidak ada task.");
                    } else {
                        System.out.println("\n📋 Daftar Task:");
                        for (int i = 0; i < taskList.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            taskList.get(i).displayTask();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nomor task yang ingin ditandai selesai: ");
                    int completeIndex = scanner.nextInt() - 1;
                    if (completeIndex >= 0 && completeIndex < taskList.size()) {
                        taskList.get(completeIndex).markCompleted();
                    } else {
                        System.out.println("❌ Nomor task tidak valid.");
                    }
                    break;

                case 4:
                    System.out.print("Nomor task yang ingin diedit: ");
                    int editIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (editIndex >= 0 && editIndex < taskList.size()) {
                        System.out.print("Judul baru: ");
                        String newTitle = scanner.nextLine();
                        taskList.get(editIndex).editTask(newTitle);
                    } else {
                        System.out.println("❌ Nomor task tidak valid.");
                    }
                    break;

                case 5:
                    System.out.print("Nomor task yang ingin dihapus: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    if (deleteIndex >= 0 && deleteIndex < taskList.size()) {
                        taskList.get(deleteIndex).deleteTask();
                        taskList.remove(deleteIndex);
                        System.out.println("🗑️ Task berhasil dihapus.");
                    } else {
                        System.out.println("❌ Nomor task tidak valid.");
                    }
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("❓ Pilihan tidak valid.");
            }
        }

        System.out.println("👋 Terima kasih telah menggunakan Task To-Do List!");
        scanner.close();
    }
}
