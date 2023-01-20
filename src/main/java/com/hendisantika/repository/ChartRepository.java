package com.hendisantika.repository;

import com.hendisantika.model.ChartEntity;
import com.hendisantika.model.FilesReceivedEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChartRepository extends CrudRepository<ChartEntity, Long> {

}
