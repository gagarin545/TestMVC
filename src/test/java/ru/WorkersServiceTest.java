package ru;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.entity.WorkersEntity;
import ru.repository.WorkersEntityRepository;
import ru.service.WorkService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkersServiceTest {
    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Resource
    private WorkService workService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testWorkersRead() throws Exception {
        String imei = "1234567890";
        WorkersEntity worker =  workService.workGet(1);
        if( worker.getIddivision().length > 0)
            System.out.println( "->" + worker.getName() + ' ' + worker.getImei());
        List<WorkersEntity> workers = workService.worklist();
        workers.forEach(work-> System.out.println( work.getName()));
    }
}
