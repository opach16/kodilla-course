package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface TaskDao extends CrudRepository<Task, Integer> {

    List<Task> findByDuration(int duration);

    @Query
    List<Task> retrieveLongTask();

    @Query
    List<Task> retrieveShortTask();

    @Query
    List<Task> retrieveTasksWithDurationLongerThan(@Param("DURATION") int duration);

    @Query(nativeQuery = true)
    List<Task> retrieveTaskWithEnoughTime();
}
