package be.intecbrussel.dao.impl;

import be.intecbrussel.dao.ExamDao;
import be.intecbrussel.dao.GradeDao;
import be.intecbrussel.dao.ModuleDao;
import be.intecbrussel.dao.PersonDao;
import be.intecbrussel.model.*;
import be.intecbrussel.model.Module;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.persistence.EntityManager;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GradeDaoImplTest {
    EntityManager em;
    @Mock
    private GradeDao gradeDao;
    @Mock
    private PersonDao personDao;
    @Mock
    private ExamDao examDao;



    @BeforeEach
    void init(){
        em = mock(EntityManager.class);

/*        Course course = new Course();
        course.setId(1L);
        course.setName("Java");
        course.setDescription("Java Developer");
        course.setCode("Java EE");
        course.setActive(true);

        module = new Module();
        module.setId(1L);
        module.setDescription("module1");
        module.setName("MDL1");
        module.setCourse(course);
        moduleDao = mock(ModuleDao.class);
        module = mock(Module.class);*/

        Person person = new Person();
//        person.setId(17);
        person.setFirstName("name4");
        person.setFamilyName("surname4");
        person.setGender(Gender.FEMALE);

//        person.setCourseActive(course);
//        person = personDao.save(person);

        User user = new User();
        user.setLogin("Admin4");
        user.setPasswordhash("123");
        user.setPerson(person);
        user.setActive(true);

//        userDao.save(user);

/*        Module module = new Module();
//        module.setId(3L);
        module.setDescription("module2");
        module.setName("MDL2");
        module.setCourse(course);


        module = moduleDao.save(module);*/

        Exam exam = new Exam();
        exam.setName("exam1");
        exam.setDate(LocalDate.now());
        exam.setDescription("qwert");
        exam.setWeight(65);

//        exam.setModule(module);
        exam = examDao.save(exam);
//
//        Grade grade = new Grade();
//        grade.setExam(exam);
//        grade.setAbsent(true);
//        grade.setPerson(person);
//        grade.setDate(LocalDate.now());
//        grade.setComment("This is a comment");
//        gradeDao.save(grade);
    }

    @Test
    void getAverageByPerson() {

    }
}