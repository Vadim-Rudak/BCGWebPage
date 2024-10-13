package com.bears.webPage.webControllers.games;

import com.bears.webPage.domain.shop.ShopEnt;
import com.bears.webPage.domain.shop.UserBuyEnt;
import com.bears.webPage.repos.ShopRepo;
import com.bears.webPage.repos.UserBuyEntRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
public class TowerOfMagicRESTController {

    @Autowired
    private ShopRepo shopRepo;

    @Autowired
    private UserBuyEntRepo userBuyEntRepo;

    @RequestMapping(value = "/TowerOfMagic/push", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object AddEvent(@RequestParam(name="notification_type", required=false, defaultValue="null") String notification_type,
                           @RequestParam(name="status", required=false, defaultValue="null") String status,
                           @RequestParam(name="item", required=false, defaultValue="0") String item,
                           @RequestParam(name="receiver_id", required=false, defaultValue="0") int receiver_id,
                           @RequestParam(name="item_price", required=false, defaultValue="0") int item_price,
                           @RequestParam(name="order_id", required=false, defaultValue="0") Integer order_id) {

        System.out.println(notification_type + " "  + status  + " " + order_id);

        System.out.println("Click id" + item);

        Random random = new Random();
        int num_random = random.nextInt(8000);
        System.out.println(num_random);

        switch (notification_type){
            case "get_item":{

                ShopEnt shopEnt = shopRepo.findByItemid(item);
                if (shopEnt!=null){

                    return new TowerShopResponse(new ResponseTower(
                            shopEnt.getTitle(), shopEnt.getPrice(), shopEnt.getPhotourl(),
                            shopEnt.getDiscount(), shopEnt.getItemid(), shopEnt.getExpiration()));

                }else{

                    ResponseStatusBuyError responseStatusBuyError = new ResponseStatusBuyError();
                    responseStatusBuyError.setError_code(21);
                    responseStatusBuyError.setError_msg("Нет в наличии");
                    responseStatusBuyError.setCritical(true);

                    return new TowerShopResponse(responseStatusBuyError);
                }

            }
            case "order_status_change":{

                if (status.equals("chargeable")){

                    UserBuyEnt userBuyEnt = new UserBuyEnt();
                    userBuyEnt.setOrderid(order_id);
                    userBuyEnt.setReceiverid(receiver_id);

                    userBuyEntRepo.save(userBuyEnt);

                    ResponseStatusBuyOk responseStatusBuyOk = new ResponseStatusBuyOk();
                    responseStatusBuyOk.setOrder_id(order_id);
                    responseStatusBuyOk.setApp_order_id(userBuyEnt.getId());//Add new num for transaction

                    return new TowerShopResponse(responseStatusBuyOk);
                }else{

                    ResponseStatusBuyError responseStatusBuyError = new ResponseStatusBuyError();
                    responseStatusBuyError.setError_code(21);
                    responseStatusBuyError.setError_msg("Нет в наличии");
                    responseStatusBuyError.setCritical(true);

                    return new TowerShopResponse(responseStatusBuyError);
                }

            }
            default:{

                return "";
            }
        }

    }

    @RequestMapping(value = "/TowerOfMagic/push/test", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object AddEventTest(@RequestParam(name="notification_type", required=false, defaultValue="null") String notification_type,
                           @RequestParam(name="status", required=false, defaultValue="null") String status,
                           @RequestParam(name="item", required=false, defaultValue="0") String item,
                           @RequestParam(name="receiver_id", required=false, defaultValue="0") int receiver_id,
                           @RequestParam(name="item_price", required=false, defaultValue="0") int item_price,
                           @RequestParam(name="order_id", required=false, defaultValue="0") Integer order_id) {

        System.out.println(notification_type + " "  + status  + " " + order_id);

        System.out.println("Click id" + item);

        Random random = new Random();
        int num_random = random.nextInt(8000);
        System.out.println(num_random);

        switch (notification_type){
            case "get_item_test":{

                ShopEnt shopEnt = shopRepo.findByItemid(item);
                if (shopEnt!=null){

                    return new TowerShopResponse(new ResponseTower(
                            shopEnt.getTitle(), shopEnt.getPrice(), shopEnt.getPhotourl(),
                            shopEnt.getDiscount(), shopEnt.getItemid(), shopEnt.getExpiration()));

                }else{

                    ResponseStatusBuyError responseStatusBuyError = new ResponseStatusBuyError();
                    responseStatusBuyError.setError_code(21);
                    responseStatusBuyError.setError_msg("Нет в наличии");
                    responseStatusBuyError.setCritical(true);

                    return new TowerShopResponse(responseStatusBuyError);
                }

            }
            case "order_status_change_test":{

                if (status.equals("chargeable")){

                    UserBuyEnt userBuyEnt = new UserBuyEnt();
                    userBuyEnt.setOrderid(order_id);
                    userBuyEnt.setReceiverid(receiver_id);

                    userBuyEntRepo.save(userBuyEnt);

                    ResponseStatusBuyOk responseStatusBuyOk = new ResponseStatusBuyOk();
                    responseStatusBuyOk.setOrder_id(order_id);
                    responseStatusBuyOk.setApp_order_id(userBuyEnt.getId());//Add new num for transaction

                    return new TowerShopResponse(responseStatusBuyOk);
                }else{

                    ResponseStatusBuyError responseStatusBuyError = new ResponseStatusBuyError();
                    responseStatusBuyError.setError_code(21);
                    responseStatusBuyError.setError_msg("Нет в наличии");
                    responseStatusBuyError.setCritical(true);

                    return new TowerShopResponse(responseStatusBuyError);
                }

            }
            default:{

                return "";
            }
        }

    }
}

@Getter
@Setter
@AllArgsConstructor
class TowerShopResponse{
    private Object response;
}

@Getter
@Setter
@AllArgsConstructor
class TowerShopError{
    private Object error;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class ResponseTower{
    private String title;
    private int price;
    private String photo_url;
    private int discount;
    private String item_id;
    private int expiration;
}

@Getter
@Setter
class ResponseStatusBuyOk{
    private int order_id;
    private int app_order_id;
}

@Getter
@Setter
class ResponseStatusBuyError{
    private int error_code;
    private String error_msg;
    private boolean critical;
}