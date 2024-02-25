package com.example.bank.repository;

import com.example.bank.model.Notices;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticesRepository extends CrudRepository<Notices, Long> {
    @Query(value = "from Notices where current date between notic_beg_dt and notic_end_dt") /*truy xuất tất cả thông báo ngày
    bắt đầu và kết thúc */
    List<Notices> findAllActiveNotices();
}
