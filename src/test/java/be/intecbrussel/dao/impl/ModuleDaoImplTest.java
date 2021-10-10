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
    private Module module;


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
        module.setId(1L);
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
        Module savedModule = moduleDao.save(module);
        assertEquals(savedModule.getId(), module.getId());
    }

    @Test
    void findByIdTest(){
/*        Long id = 24234234L;
        when(moduleDao.findById(id)).thenReturn(module);

        Module mdl = mock(Module.class);
        when(moduleDao.findById(Matchers.any(Module.class))).thenReturn(mdl);
        Module savedModule = moduleDao.save(module);
        assertEquals(savedModule.getId(), module.getId());*/
    }

    @Test
    void updateTest(){
        Module mdl = mock(Module.class);
        when(moduleDao.save(Matchers.any(Module.class))).thenReturn(mdl);
        module.setDescription("updated");
        Module updatedModule = moduleDao.save(module);
        assertEquals("updated", updatedModule.getDescription());
    }

    @Test
    void removeTest(){
/*        Module mdl = mock(Module.class);
        when(moduleDao.remove(Matchers.any(Module.class));).thenReturn(mdl);
        Module removedModule = moduleDao.remove(module);
        assertEquals(removedModule.getId(), module.getId());*/
    }

    @Test
    void findAllTest(){
        when(moduleDao.findAll()).thenReturn(List.of(module));
    }
}
