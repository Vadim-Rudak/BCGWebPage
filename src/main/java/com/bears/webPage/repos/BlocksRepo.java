package com.bears.webPage.repos;

import com.bears.webPage.domain.Blocks;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlocksRepo extends JpaRepository<Blocks,Integer> {
    List<Blocks> findByIdgameAndLang(int idGame,String lang, Sort sort);

    Blocks findById(int id);

}
