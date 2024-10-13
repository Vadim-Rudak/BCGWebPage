package com.bears.webPage.webControllers;

import com.bears.webPage.domain.*;
import com.bears.webPage.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Controller
public class MainPageController {

    @Autowired
    private BlocksRepo blocksRepo;

    @Autowired
    private GamesImpInfoRepo gamesImpInfoRepo;

    @Autowired
    private GamePageInfoRepo gamePageInfoRepo;


    @Autowired
    private OtherRepo otherRepo;

    @GetMapping("/")
    public String startpage(@RequestParam(name="lang", required=false, defaultValue="ru") String lang,Map<String, Object> model) {
//        emailService.sendMessage(new Message("fejivi4337@safe-cart.com","hi test message"));

        if (lang.equals("ru")){
            List<Games_impotant_info> games_imp_info = gamesImpInfoRepo.findAllByIdNotAndAndLang(1,"ru",PageRequest.ofSize(4).withSort(Sort.by("id").ascending()));
            System.out.println(games_imp_info.size());
            model.put("games_imp_info", games_imp_info);
            return "MainPage_ru";
        }else {
            Iterable<Games_impotant_info> games_imp_info = gamesImpInfoRepo.findAllByIdNotAndAndLang(8,"en",PageRequest.ofSize(4).withSort(Sort.by("id").ascending()));
            model.put("games_imp_info", games_imp_info);
            return "MainPage_en";
        }
    }

    @GetMapping("/game")
    public String openGame(@RequestParam(name="id_game", required=false, defaultValue="1") int id_game,@RequestParam(name="lang", required=false, defaultValue="ru") String lang, Map<String, Object> model) {

        Game_page_info game_page_info = gamePageInfoRepo.findByGameidAndLang(id_game,lang);
        Iterable<Blocks> blocks = blocksRepo.findByIdgameAndLang(id_game,lang,Sort.by("id").ascending());
        model.put("obj_game", game_page_info);
        model.put("blocks", blocks);
        return "GamePage";
    }

    @GetMapping("/allGames")
    public String allGames(@RequestParam(name="lang", required=false, defaultValue="ru") String lang,Map<String, Object> model){

        Iterable<Games_impotant_info> listGames = gamesImpInfoRepo.findAllByLang(lang,Sort.by("id").ascending());
        model.put("ListGames", listGames);
        model.put("language",lang);
        return "AllGamesPage";
    }

    @GetMapping("/tower-of-magic-2/privacy.html")
    public String towerOfMagicPrivacy() {
        return "TowerOfMagicPrivacy";
    }

    @GetMapping("/i-can-do-it/privacy.html")
    public String ICanDoItPrivacy() {
        return "ICanDoItPrivacy";
    }


    @GetMapping("/swipe-all/privacy.html")
    public String SwipeAllPrivacy(){
        return "SwipeAllPrivacy";
    }


    @GetMapping("/fish-runner/privacy.html")
    public String FishRunnerPrivacy(){
        return "FishRunnerPrivacy";
    }


    @GetMapping("/binary-corgi/privacy.html")
    public String BinaryCorgiPrivacy(){
        return "BinaryCorgiPrivacy";
    }


    @GetMapping("/lifeline-growing-up/privacy.html")
    public String LifeLineGrowingUpPrivacy(){
        return "LifeLineGrowingUpPrivacy";
    }


    @GetMapping("/math-battle/privacy.html")
    public String MathBattlePrivacy(){
        return "MathBattlePrivacy";
    }



    @GetMapping("/maze-tag/privacy.html")
    public String MazeTagPrivacy(){
        return "MazeTagPrivacy";
    }


    @GetMapping("/pumpkin-clicker/privacy.html")
    public String PumpkinClickerPrivacy(){
        return "PumpkinClickerPrivacy";
    }


    @GetMapping("/stint-rift-apart/privacy.html")
    public String StintRiftApartPrivacy(){
        return "StintRiftApartPrivacy";
    }


    @GetMapping("/games/BinaryCorgi/index")
    public String openGameBinaryCorgi(){
        return "index";
    }

    @GetMapping("/games/shop/images")
    public ResponseEntity<byte[]> openImgBinaryCorgi(@RequestParam(name="img_id", required=false, defaultValue="0") int id_img){

        Other other = otherRepo.findById(id_img);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(Base64.getMimeDecoder().decode(other.getInfo()));
    }

    @GetMapping("/games/BinaryCorgi/images/for_repost.png")
    public ResponseEntity<byte[]> openImg(){

        Other other = otherRepo.findById(2);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(Base64.getMimeDecoder().decode(other.getInfo()));
    }

    @GetMapping("/games/BinaryCorgi/test/index")
    public String openGameTower(){
        return "testCorgi/index";
    }

    @GetMapping("/games/BinaryCorgi/BinaryCorgi_test/index")
    public String openBCTest(){
        return "test/index";
    }


    @GetMapping("/games/SwipeAll/index")
    public String openSwipeAll(){
        return "swipeAll/index";
    }

    @GetMapping("/games/CorgiTown/index")
    public String openGameCorgiTown(){
        return "corgiTown/index";
    }

    @GetMapping("/games/CorgiWorldTour/index")
    public String openGameCorgiWorldTour(){
        return "worldTour/index";
    }

    @RequestMapping(value= "/app-ads.txt", method= RequestMethod.GET)
    public ResponseEntity<?> getFile() throws FileNotFoundException {

        File file = new File("/home/web/ads_file/app-ads.txt");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(resource);
    }
}
