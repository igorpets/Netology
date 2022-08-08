package Database;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class MongoDBPOperations {

    public void saveStudent(MongoOperations mongoOperation, Student student) {

        mongoOperation.save(student);
        System.out.println("Student saved successfully");
        // student object got created with id.
        System.out.println("student : " + student);
    }

    public void searchStudent(MongoOperations mongoOperation, String critera,String value) {
        // query to search student
        Query searchStudent = new Query(Criteria.where(critera).is(value));

        // find student based on the query
        Student resultStudent = mongoOperation.findOne(searchStudent, Student.class);
        System.out.println("Student found!!");
        System.out.println("Student details: " + resultStudent);
    }

    public void updateStudent(MongoOperations mongoOperation, String critera,String value, String updateCriteria, String updateValue) {
        // query to search student
        Query searchStudent = new Query(Criteria.where(critera).is(value));
        mongoOperation.updateFirst(searchStudent, Update.update(updateCriteria, updateValue),
                Student.class);
        System.out.println("Student got updated successfully");
    }
    public void getAllStudent(MongoOperations mongoOperation) {
        List listStudent = mongoOperation.findAll(Student.class);
        for(Object student:listStudent) {
            System.out.println("Student = " + (Student)student);
        }
    }
    public void removeStudent(MongoOperations mongoOperation, String critera,String value) {
        Query searchStudent = new Query(Criteria.where(critera).is(value));
        mongoOperation.remove(searchStudent, Student.class);
        System.out.println("Student removed successfully!! ");
    }
}