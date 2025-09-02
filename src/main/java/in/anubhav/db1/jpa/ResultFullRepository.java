package in.anubhav.db1.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.anubhav.db1.entity.ResultFull;

@Repository
public interface ResultFullRepository extends JpaRepository<ResultFull, Integer>{

}
