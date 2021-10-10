package be.intecbrussel.dao.impl;


import be.intecbrussel.dao.ModuleDao;
import be.intecbrussel.dao.impl.CourseDaoImpl;
import be.intecbrussel.dao.impl.ModuleDaoImpl;
import be.intecbrussel.model.Course;
import be.intecbrussel.model.Module;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.*;

public class ModuleDaoImplTest {

    EntityManager em;
    @Mock
    private ModuleDao moduleDao;
    @Mock
    private Module module;
    @InjectMocks
    private ModuleDaoImpl moduleDaoImpl;
/*    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }*/
    @BeforeEach
    void init(){
        em = mock(EntityManager.class);
        Course course = new Course();
        course.setId(1L);
        course.setName("Java");
        course.setDescription("Java Developer");
        course.setCode("Java EE");
        course.setActive(true);

        module = new Module();
        module.setId(3L);
        module.setDescription("module1");
        module.setName("MDL1");
        module.setCourse(course);
        moduleDao = mock(ModuleDao.class);
        module = mock(Module.class);
    }

    @Test
    void saveTest(){
        Module mdl = mock(Module.class);
        when(moduleDao.save(Matchers.any(Module.class))).thenReturn(mdl);
        Module moduleDao1 = moduleDao.save(module);
        when(mdl.getId()).thenReturn(1L);
        assertEquals(moduleDao1.getId(), module.getId());
        assertEquals(moduleDao1.getId(), 1L);
    }

    @Test
    void findByIdTest(){
        Long id = 24234234L;
        when(moduleDao.findById(id)).thenReturn(module);
    }

    @Test
    void update(){
        moduleDao.update(module);
    }

    @Test
    void remove(){
        moduleDao.remove(module);
    }

    @Test
    void findAllTest(){
        when(moduleDao.findAll()).thenReturn(List.of(module));
    }
}
