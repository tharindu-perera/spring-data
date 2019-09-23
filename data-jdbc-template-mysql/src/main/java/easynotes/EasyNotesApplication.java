package easynotes;

import easynotes.model.Employee;
import easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@SpringBootApplication
//@Configuration
//@ComponentScan

public class EasyNotesApplication implements CommandLineRunner {
    @Autowired
    NoteRepository noteRepository;

    public static void main(String[] args) {
//         new  AnnotationConfigApplicationContext(EasyNotesApplication.class);
        SpringApplication.run(EasyNotesApplication.class, args);
    }

    public void run(String... args) throws Exception {
        Employee emp = new Employee();
        int rand = new Random().nextInt(1000);
        emp.setId(rand);
        emp.setName("Pankaj");
        emp.setRole("Java Developer123");

        //Create
        noteRepository.save(emp);

        //Read
        Employee emp1 = noteRepository.getById((long) rand);
        System.out.println("data.Employee Retrieved::" + emp1);

    }
}
