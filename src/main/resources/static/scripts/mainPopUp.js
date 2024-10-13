
$(document).ready(function(){
    //Скрыть PopUp при загрузке страницы
    PopUpHide();
    PopUpHideWork1();
    PopUpHideWork2();
});
//Функция отображения PopUp
function PopUpShow(){
    $("#coopPopUp").show();
}
function PopUpShowWork1(x){
    var text_job = document.getElementById("text_job");
    if(x === 1){
        text_job.textContent = "Android Developer"
    }else if(x === 2){
        text_job.textContent = "iOS Developer"
    }else {
        text_job.textContent = "Product Designer"
    }
    $("#PopUpWork1").show();
}
function PopUpShowWork1Send(){
    var text_job1 = document.getElementById("text_job").textContent;
    $("#PopUpWork1").hide();
    var text_job_send = document.getElementById("text_job_send");
    text_job_send.textContent = text_job1
    $("#PopUpWork2").show();
}
function PopUpShowWork2(){
    $("#PopUpWork2").show();
}

//Функция скрытия PopUp
function PopUpHide(){
    $("#coopPopUp").hide();
}
function PopUpHideWork1(){
    $("#PopUpWork1").hide();
}
function PopUpHideWork2(){
    $("#PopUpWork2").hide();
}