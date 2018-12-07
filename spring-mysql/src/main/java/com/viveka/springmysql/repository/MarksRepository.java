package com.viveka.springmysql.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.viveka.springmysql.model.MarksInfo;

public interface MarksRepository extends JpaRepository<MarksInfo, Long> {
  List<MarksInfo> findById(long id);

  MarksInfo findOne(long roll);
}
