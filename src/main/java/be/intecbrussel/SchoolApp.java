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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-app");
        EntityManager em = emf.createEntityManager();

        CourseDao courseDao = new CourseDaoImpl();
        ExamDao examDao = new ExamDaoImpl();
        ModuleDao moduleDao = new ModuleDaoImpl();
        PersonDao personDao = new PersonDaoImpl();
        UserDao userDao = new UserDaoImpl();
        GradeDao gradeDao = new GradeDaoImpl();


//        Course course = new Course();
////        course.setId(1L);
//        course.setName("C#");
//        course.setDescription("C# Developer");
//        course.setCode("C#");
//        course.setActive(true);
//        course = courseDao.save(course);
//
//        Person person = new Person();
////        person.setId(17);
//        person.setFirstName("name4");
//        person.setFamilyName("surname4");
//        person.setGender(Gender.FEMALE);
//
//        person.setCourseActive(course);
//        person = personDao.save(person);
//
//        User user = new User();
//        user.setLogin("Admin4");
//        user.setPasswordhash("123");
//        user.setPerson(person);
//        user.setActive(true);
//
//        userDao.save(user);
//
//        Module module = new Module();
////        module.setId(3L);
//        module.setDescription("module2");
//        module.setName("MDL2");
//        module.setCourse(course);
//
//
//        module = moduleDao.save(module);
//
//        Exam exam = new Exam();
//        exam.setName("exam1");
//        exam.setDate(LocalDate.now());
//        exam.setDescription("qwert");
//        exam.setWeight(65);
//
//        exam.setModule(module);
//        exam = examDao.save(exam);
//
//        Grade grade = new Grade();
//        grade.setExam(exam);
//        grade.setAbsent(true);
//        grade.setPerson(person);
//        grade.setDate(LocalDate.now());
//        grade.setComment("This is a comment");
//        gradeDao.save(grade);

//        <--- Delete --->
/*            personDao.remove(personDao.findById(17));
            userDao.remove(userDao.findById("Admin23"));
            gradeDao.remove(gradeDao.findById(57L));
            courseDao.remove(courseDao.findById(53L));
            moduleDao.remove(moduleDao.findById(55L));*/

//        <--- Find all --->
/*        personDao.findAll().forEach(person -> System.out.println(person));
        courseDao.findAllCourseByActive().forEach(course -> System.out.println(course));

        Person person = new Person();
        person.setId(19);
        gradeDao.findAllGradesByPerson(person).forEach(grade -> System.out.println(grade));*/

//        <--- make passive (inactive) --->
//        personDao.makePassive(19);

//        <--- Average of grades (person) --->
/*        Person person = new Person();
        person.setId(2);
        System.out.println(gradeDao.getAverageByPerson(person));*/

//        <--- Average of grades (all persons in the same course) --->
/*        Person person = new Person();
        personDao.findAll().forEach(person -> System.out.println(gradeDao.getAverageByPerson(person)) );*/


    }
}
