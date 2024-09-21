package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskFinancialDetailsDaoTestSuite {

    @Autowired
    TaskFinancialDetailsDao taskFinancialDetailsDao;

    @Test
    void testFindByPaid() {
        //given
        TaskFinancialDetails financialTask = new TaskFinancialDetails(new BigDecimal(115), false);
        taskFinancialDetailsDao.save(financialTask);

        //when
        List<TaskFinancialDetails> resultList = taskFinancialDetailsDao.findByPaid(false);

        //then
        assertEquals(1, resultList.size());

        //cleanUp
        taskFinancialDetailsDao.deleteById(resultList.getFirst().getId());
    }
}
