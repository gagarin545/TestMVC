package ru;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.entity.ResultEntity;
import ru.entity.WorkerResultEntity;
import ru.service.IncidentService;
import ru.service.ResultService;
import ru.service.WorkerResultservice;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkerResultServiceTest {
    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Resource
    private WorkerResultservice workerResultservice;

    @Before
    public void setUp() throws Exception {        em = emf.createEntityManager();    }

    @Test
    public void  testResult(){
        int[] id = { 90, 4, 107, 109};
        List<WorkerResultEntity> res = workerResultservice.incidenListWorkers( id);
        res.forEach(ss-> System.out.println( ss.getTimeclose() + " " + ss.getCount() + " " + ss.getName() + " " ));
        System.out.println(res.size());

    }
}
