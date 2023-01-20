package com.hendisantika.repository;

import com.hendisantika.model.FilesReceivedEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilesReceivedRepository extends CrudRepository<FilesReceivedEntity, Long> {

    @Query(nativeQuery = true, value = "select * from file_executions where status not in ('FAILURE', 'ERROR') limit 5")
    List<FilesReceivedEntity> getFiveLatestFiles();

    @Query(nativeQuery = true, value = "select * from file_executions where status in ('FAILURE', 'ERROR') limit 5")
    List<FilesReceivedEntity> getFiveFailedLatestFiles();


}
