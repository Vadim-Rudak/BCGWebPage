package com.bears.webPage.repos;

import com.bears.webPage.domain.Blocks;
import com.bears.webPage.domain.Game_page_info;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GamePageInfoRepo extends CrudRepository<Game_page_info,Integer> {
    Game_page_info findByGameidAndLang(int id_game,String lang);
}
