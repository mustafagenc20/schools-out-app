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


        Course course = new Course();
        course.setName("WD 3");
        course.setDescription("Web Development");
        course.setCode("WD");
        course.setActive(true);
        course = courseDao.save(course);

        Person person = new Person();
//        person.setId(2);
        person.setFirstName("Hakan");
        person.setFamilyName("Genc");
        person.setGender(Gender.MALE);

        person.setCourseActive(course);
        person = personDao.save(person);

        User user = new User();
        user.setLogin("Admin14");
        user.setPasswordhash("12323");
        user.setPerson(person);
        user.setActive(true);

        userDao.save(user);

        Module module = new Module();
        module.setDescription("Bootstrap");
        module.setName("CSS");
        module.setCourse(course);


        module = moduleDao.save(module);

        Exam exam = new Exam();
        exam.setName("CSS1");
        exam.setDate(LocalDate.now());
        exam.setDescription("qwert");
        exam.setWeight(60);

        exam.setModule(module);
        exam = examDao.save(exam);

        Grade grade = new Grade();
        grade.setExam(exam);
        grade.setAbsent(true);
        grade.setPerson(person);
        grade.setDate(LocalDate.now());
        grade.setComment("This is a comment");


        gradeDao.save(grade);

//        <--- Delete --->

//        personDao.remove(personDao.findById(6));
//        userDao.remove(userDao.findById("Admin"));
//        gradeDao.remove(gradeDao.findById(5L));
//        courseDao.remove(courseDao.findById(2L));
//        moduleDao.remove(3L);

//        <--- Find all --->
//        personDao.findAll().forEach(person -> System.out.println(person));

//        courseDao.findAllCourseByActive().forEach(course -> System.out.println(course));

//        Person person = new Person();
//        person.setId(17);
//        gradeDao.findAllGradesByPerson(person).forEach(grade -> System.out.println(grade));

    }
}
