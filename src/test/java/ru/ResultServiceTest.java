package ru;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.entity.ResultEntity;
import ru.service.ResultService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResultServiceTest {
    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Resource
    private ResultService resultService;

    @Before
    public void setUp() throws Exception {        em = emf.createEntityManager();    }

    @Test
    public void  testResult(){
        Integer[] id = { 90, 4, 107, 109};

        List<ResultEntity> res = resultService.resultList( id);
        res.forEach(ss-> System.out.println(ss.getTimeclose() + " " + ss.getNamedivision() + " " + ss.getKvcount() + " " + ss.getSkvcount()));
        System.out.println(res.size());

    }
}
