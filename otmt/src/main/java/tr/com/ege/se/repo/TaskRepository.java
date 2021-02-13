package tr.com.ege.se.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.ege.se.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
