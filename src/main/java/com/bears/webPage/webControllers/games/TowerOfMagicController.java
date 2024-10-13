package com.bears.webPage.webControllers.games;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.Map;


@Controller
public class TowerOfMagicController {


    @GetMapping("/games/TowerOfMagic/LandScape/index")
    public String openGameTowerOfMagicLandScape(Map<String, Object> model) throws IOException {

        return "tower/LandScape/index";
    }

    @GetMapping("/games/TowerOfMagic/Portrait/index")
    public String openGameTowerOfMagicPortrait(Map<String, Object> model) throws IOException {

        return "tower/Portrait/index";
    }


}
