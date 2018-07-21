package com.x3800.consumer.repository;

import com.x3800.consumer.model.Consumer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;
import java.util.List;

public interface ConsumerRepository extends PagingAndSortingRepository<Consumer, Long> {

    // 소비자명으로 검색한다.
    List<Consumer> findByNameContaining(@Param("name") String name);

    // 출판일을 기준으로 검색한다.
//  List<Consumer> findByPublishdateAfter(@Param("after") @DateTimeFormat(iso = ISO.DATE) Date date);

    // 소비자명으로 검색한 건수를 확인한다.
    Long countByNameContaining(@Param("name") String name);

    // 출판일을 기준으로 검색한 건수를 확인한다.
//  Long countByPublishdateAfter(@Param("after") @DateTimeFormat(iso = ISO.DATE) Date date);

}
