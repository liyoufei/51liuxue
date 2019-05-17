$(document).ready(function() {
  $("input.form-text ").click(function () {
    $("ul.ul_input").toggle();
  });

  $(".header-top-a a ").click(function () {
    $("ul.ul_img").toggle();
  });

  $(".header-top-utf a ").click(function () {
    $("ul.ul_utf").toggle();





    if ($(".up").css("display") == "none") {
      $(".up").show();
      $(".down").hide();
    } else {
      $(".up").hide();
      $(".down").show();
    }
  });

  $(".fa-times").click(function(e){
    $(this).parent().parent().parent().parent().parent().remove();
  })





  $(".i-radio-check").click(function(e) {
    if($(this).children().eq(0).is(':checked')) {
    $(this).children().eq(1).animate({
      left:'50%'
    },100);
      $(this).children().eq(1).css({"background":"#f57a19"});
      $(this).css({"border":"2px solid #f57a19"});
    }else{
      $(this).children().eq(1).animate({
        left:'0%'
      },100);
      $(this).children().eq(1).css({"background":"#bfbfbf"});
      $(this).css({"border":"2px solid #bfbfbf"});
    }


  });
//滑动按钮
  $("#i-radio-1").click(function(e){
    $(".iCheck").animate({
      left:'50%'
    });
    $(this).css({"border":"2px solid #f57a19"});
    $(".iCheck").css({"background":"#f57a19"});
    $(".iCheck-1").animate({
      left:'0%'

    });
    $(".iCheck").css({"background":"#bfbfbf"});
    $(".iCheck").css({"border":"2px solid #bfbfbf"});
  });

  $("#i-radio-2").click(function(){
    $(this).css({"border":"2px solid #f57a19"});
    $(".iCheck-1").animate({
      left:'50%'


    });
    $(".iCheck-1").css({"background":"#f57a19"});
    $(".iCheck").animate({
      left:'0%'


    });
    $(".iCheck-1").css({"background":"#bfbfbf"});
    $(".iCheck-1").css({"border":"2px solid #bfbfbf"});
  });




$("em").click(function(e){
  $(this).removeClass("em");
  $(this).parent().parent().siblings().find("em").addClass("em");
})




  $(".ui-select-1 select").change(function () {
    var get = $(".ui-select-1 option:selected").text();
    $(".ui-select-1 p").text(get);
  });

  $(".ui-select-2 select").change(function () {
    var get = $(".ui-select-2 option:selected").text();
    $(".ui-select-2 p").text(get);
  });

  $(".ui-select-3 select").change(function () {
    var get = $(".ui-select-3 option:selected").text();
    $(".ui-select-3 p").text(get);
  });

//滚动监听
  $(window).scroll(function () {
    if ($(window).scrollTop() >= 100) {
      $("#header").css("top","-70px");

      $(".header-img").show(255);
      $(".community-info-main").css("margin-top", "220px");
      //$(".community-info-main").css("padding-top", "0px");
      $(".main-container").css("margin-top", "220px");
      //$(".main-container").css("padding-top", "0px");
      $(".user-content").css("margin-top", "220px");
      //$(".user-content").css("padding-top", "0px");
      $(".logo_small").show(255);
      $(".juedui").css("top", "350px");
      $(".seach").show(255);
    } else {
      $("#header").css("top","0px");
      $(".header-img").hide(255);
      $(".community-info-main").css("margin-top", "160px");
      $(".user-content").css("margin-top", "160px");
      $(".main-container").css("margin-top", "160px");
      $(".logo_small").hide();
      $(".juedui").css("top", "400px");
      $(".seach").hide(255);
    }
  });
  $(".more_1").click(function (e) {
    $(this).parent().parent().parent().next().fadeToggle();
    var str = '查看详情>';
    var str1 = $(this).text();
    if (str === str1) {
      $(this).text("点击收起");
    } else {
      $(this).text("查看详情>");
    }
  });




  $(".answer").click(function (e) {
    $(this).parent().parent().parent().parent().next().fadeToggle();

  });

$("a.comment-reply").click(function(e){
 $(this).next().css("display","block");
});

  $(".cancel-reply").click(function(e){
    $(this).parent().css("display","none");
  });
//关注 加入关注 对比加入对比
  $("span.txt-add-to-follow").click(function(e){
if($(this).html()=="关注") {
  $(this).text("已关注");
}else{
  $(this).text("关注");
}
  });

  $("span.txt-add-to-compare").click(function(e){
    if($(this).html()=="加入对比") {
      $(this).text("已加入对比");
    }else{
      $(this).text("加入对比");
    }
  });





//bootstrap tooltip();
  $(function(){
    $(".fa").tooltip();

  });





  //院校排行
  $("a.ranking-view-more").click(function(e){
    $(this).next().fadeToggle();

  });

  $(".add-to-follow").click(function (e) {
    if ($(this).hasClass("red")) {
      $(this).removeClass("red");
      $(this).attr("title", "点击收藏");
      $(this).addClass("fa-heart-o") && $(this).removeClass("fa-heart");
    }

    else {
      $(this).addClass("red");

      $(this).addClass("fa-heart") && $(this).removeClass("fa-heart-o");
      $(this).attr("title", "已收藏");
    }
  });
  $(".expand-tag").click(function() {

    if ($(".related-tags span").hasClass("span_hidden")){
      $(".related-tags span").removeClass("span_hidden");
      $(".expand-tag").text("收起");
      $(".related-tags").css("margin-bottom","60px")
    }else{
      $(".related-tags span").addClass("span_hidden");
      $(".expand-tag").text("展开");
      $(".related-tags").css("margin-bottom","0px");
    }
  });

//悬浮 小图标
  $("li.phone").mouseover(function(e){

    $(this).stop().animate({
      left:'-480%'

 //-480
    },180);

  });

  $("li.phone").mouseout(function(e){

    $(this).stop().animate({
      left:'0%'

    },180);

  });


  $(".start-here-a").mouseover(function(e){
    $(this).children().eq(1).show().css("top", "45%");
    //$(this).children().eq(1).animate({
    //  top:'45%',
    //  display:'block'
    //},180);
  });
  $(".start-here-a").mouseout(function(e){
    $(this).children().eq(1).hide().css("top", "75%");
    //$(this).children().eq(1).animate({
    //  top:'75%',
    //  opacity:'0'
    //},200);
  });




  $("#popup-gallery .popup-gallery-image ").mouseover(function(e){
    $(this).children().eq(1).animate({
      top:'40%',
      opacity:'1'
    },80);

  });
  $("#popup-gallery .popup-gallery-image ").mouseout(function(e){
    $(this).children().eq(1).animate({
      top:'70%',
      opacity:'0'
    },10);
  });
});



//滚动到顶部按钮---------------------------------------------------------------start
window.onload = function(){
  var obtn = document.getElementById('top-btn');
  //获取页面可视区的高度
  var clientHeight=document.documentElement.clientHeight;
  var timer = null;
  var isTop = true;

  window.onscroll=function(){
    var osTop=document.documentElement.scrollTop||document.body.scrollTop;
    if (osTop >= clientHeight/2){

      obtn.style.display='block';
    }else {

      obtn.style.display='none';
    }

    if(!isTop){
      clearInterval(timer);
    }
    isTop=false;

  }
  obtn.onclick = function(){

    timer = setInterval(function(){
      //获取滚动条距离顶部的高度
      var osTop=document.documentElement.scrollTop||document.body.scrollTop;

      var ispeed = Math.floor(-osTop / 10);
      document.documentElement.scrollTop = document.body.scrollTop = osTop +ispeed;

      isTop = true;

      if (osTop == 0){
        clearInterval(timer);
      }
    },30);
  }

}
//滚动到顶部按钮---------------------------------------------------------------end





//本地选择上传图片----------------------start
window.URL = window.URL || window.webkitURL;
var fileElem = document.getElementById("fileElem"),
      fileList = document.getElementById("fileList");
function handleFiles(obj) {
  var files = obj.files,
        img = new Image();
  if(window.URL){
    //File API
//      alert(files[0].name + "," + files[0].size + " bytes");
    img.src = window.URL.createObjectURL(files[0]); //创建一个object URL，并不是你的本地路径
    img.width = 300;
    img.onload = function(e) {
      window.URL.revokeObjectURL(this.src); //图片加载后，释放object URL
    }
    fileList.appendChild(img);
  }else if(window.FileReader){
    //opera不支持createObjectURL/revokeObjectURL方法。我们用FileReader对象来处理
    var reader = new FileReader();
    reader.readAsDataURL(files[0]);
    reader.onload = function(e){
      alert(files[0].name + "," +e.total + " bytes");
      img.src = this.result;
      img.width = 300;
      fileList.appendChild(img);
    }
  }else{
    //ie
    obj.select();
    obj.blur();
    var nfile = document.selection.createRange().text;
    document.selection.empty();
    img.src = nfile;
    img.width = 300;
//      img.onload=function(){
//        alert(nfile+","+img.fileSize + " bytes");
//      }
    fileList.appendChild(img);
  }
}
//本地上传图片----------------------------------end


