package tr.com.ege.se.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.ege.se.entity.ProjectPlan;

@Repository
public interface ProjectPlanRepository extends JpaRepository<ProjectPlan, Long>  {

}
