package be.intecbrussel;

import be.intecbrussel.dao.*;
import be.intecbrussel.dao.impl.*;
import be.intecbrussel.model.*;
import be.intecbrussel.model.Module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class SchoolApp {
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-app");
//        EntityManager em = emf.createEntityManager();

        CourseDao courseDao = new CourseDaoImpl();
        ExamDao examDao = new ExamDaoImpl();
        ModuleDao moduleDao = new ModuleDaoImpl();
        PersonDao personDao = new PersonDaoImpl();
        UserDao userDao = new UserDaoImpl();
        GradeDao gradeDao = new GradeDaoImpl();


        Person person = new Person();
        person.setFirstName("Jonas");
        person.setFamilyName("Genc");
        person.setGender(Gender.MALE);

        person = personDao.save(person);

        User user = new User();
        user.setLogin("Admin5");
        user.setPasswordhash("1234523");
        user.setPerson(person);
        user.setActive(true);

        userDao.save(user);
////        personDao.remove(personDao.findById(3));
////        userDao.remove(userDao.findById("Admin"));

        Course course = new Course();
        course.setDescription("Web Development");
        course.setCode("WD");
        course.setActive(true);

        course = courseDao.save(course);

        Module module = new Module();
        module.setDescription("Bootstrap");
        module.setName("CSS");
        module.setCourse(course);


        module = moduleDao.save(module);

        Exam exam = new Exam();
        exam.setName("CSS1");
        exam.setDate(LocalDate.now());
        exam.setDescription("qwert");

        exam.setModule(module);
        exam = examDao.save(exam);

        Grade grade = new Grade();
        grade.setExam(exam);
        grade.setAbsent(true);
        grade.setPerson(person);
        grade.setDate(LocalDate.now());
        grade.setComment("This is a comment");

        gradeDao.save(grade);

    }
}
