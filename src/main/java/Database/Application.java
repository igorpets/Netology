package Database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class Application {

    public static void main (String[] args) {


        // For Annotation
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        MongoDBPOperations ops = new MongoDBPOperations();

        Student student = new Student("John", 15);

        //save student
        ops.saveStudent(mongoOperation, student);

        // get student based on search criteria
        ops.searchStudent(mongoOperation, "studentName", "John");

        //update student based on criteria
        ops.updateStudent(mongoOperation, "StudentName", "John", "studentAge", "18");
        // get student based on search criteria
        ops.searchStudent(mongoOperation, "studentName", "John");

        // get all the students
        ops.getAllStudent(mongoOperation);

        //remove student based on criteria
        ops.removeStudent(mongoOperation, "studentName", "John");
        // get all the students
        ops.getAllStudent(mongoOperation);


    }



}