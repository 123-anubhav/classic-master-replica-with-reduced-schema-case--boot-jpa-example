package in.anubhav.db2.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.anubhav.db2.entity.ResultLite;

@Repository
public interface ResultLiteRepository extends JpaRepository<ResultLite, Integer> {

}
