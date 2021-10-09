package be.intecbrussel;


import be.intecbrussel.dao.ModuleDao;
import be.intecbrussel.model.Module;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ModuleDaoImplTest {

    ModuleDao moduleDao;
    Module module;
    @BeforeEach
    void init(){
        moduleDao = mock(ModuleDao.class);
        module = mock(Module.class);
    }

    @Test
    void saveTest(){
        when(moduleDao.save(module)).thenReturn(module);
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
