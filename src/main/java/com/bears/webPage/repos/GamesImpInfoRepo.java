package com.bears.webPage.repos;

import com.bears.webPage.domain.Games_impotant_info;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GamesImpInfoRepo extends JpaRepository<Games_impotant_info,Integer> {
    List<Games_impotant_info> findAllByIdNotAndAndLang(int not_id,String lang, Pageable pageable);
    List<Games_impotant_info> findAllByLang(String lang, Sort sort);
}
