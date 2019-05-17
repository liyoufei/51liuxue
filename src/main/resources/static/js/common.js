// JavaScript Document
/* $(document).ready(function(){
  $(".wechat-code-btn").click(function(){
	 $(".wechat-box").css("display","block");	
	 $(this).addClass('current');
	 $(this).removeClass('wechat-code-btn');
	  $(".current").click(function(){
		 $(".wechat-box").css("display","none");	
		 $(this).addClass('wechat-code-btn');
		 $(this).removeClass('current');
	  });
  });	
}); */ 
$(document).ready(function(){
	/* 微信二维码登录切换  */
	$(".current").click(function(){
	  if($(this).is('.wechat-code-btn')){
	    $(this).removeClass('wechat-code-btn');  
		$(".wechat-box").css("display","block");
		$("#account-login-box").css("display","none");
	   }
	  else{
		 $(".wechat-box").css("display","none");	
		 $("#account-login-box").css("display","block");
		 $(this).addClass('wechat-code-btn');
		 
		  }
  })
  /* school */

  $(".school-tep li").click(function(){
	$(this).addClass('active').siblings().removeClass('active');
  })
  /* index优势 */
  $(".advantage li").mousemove(function(){
    $(this).addClass('active').siblings().removeClass('active');
  })
  
  $(".progress-nav li").mousemove(function(){
    $(this).addClass('active').siblings().removeClass('active');
  })
  
  
  /*  */
  $('.projects-menu').click(function(){
	  $('.panes-box').css("display","block");
	  $('.projects-menu').css("display","none");
	  })
  $('.button-close').click(function(){
	  $('.panes-box').css("display","none");
	  $('.projects-menu').css("display","block");
	  })
  $('.free').click(function(){
	  $('#txt-service').text("免费在线申请");
	  $(".school-click").attr("data-target","#myModal-2");
	  $(".school-click").attr("href","");
	  });
  $('.scholarship').click(function(){
	  $('#txt-service').text("奖学金");
	  $(".school-click").attr("data-target","");
	   $(".school-click").attr("data-toggle","");
	  $(".school-click").attr("href","colleges-list.html");
	  });
  $('.school-xx').click(function(){
	  $('#txt-service').text("院校信息");
	  $(".school-click").attr("data-target","");
	   $(".school-click").attr("data-toggle","");
	  $(".school-click").attr("href","colleges-list.html");
	  });
  $('.lgtest').click(function(){
	  $('#txt-service').text("免费语言测试");
	  $(".school-click").attr("data-target","");
	  $(".school-click").attr("data-toggle","");
	  $(".school-click").attr("href","tools.html");
	  });
  $('.kindergarten').click(function(){
	  $('#txt-service').text("幼儿园");
	  $(".school-click").attr("data-target","#myModal-2");
	  $(".school-click").attr("href","");
	  });
  $('.middle-school').click(function(){
	  $('#txt-service').text("中小学");
	  $(".school-click").attr("data-target","#myModal-2");
	  $(".school-click").attr("href","");
	  });
  $('.high-school').click(function(){
	  $('#txt-service').text("高中预科");
	  $(".school-click").attr("data-target","#myModal-2");
	  $(".school-click").attr("href","");
	  });
  $('.university').click(function(){
	  $('#txt-service').text("大学");
	  $(".school-click").attr("data-target","#myModal-2");
	  $(".school-click").attr("href","");
	  });
   /* $('*').click(function(e){
		if ($(this).hasClass("country-sort-title")){
		  $('.nav-drop-menu').css("height","175",'px');
		  $('.nav-drop-menu').css("opacity","1");
		  }else{
		  $('.nav-drop-menu').css("height","0",'px');
		  $('.nav-drop-menu').css("opacity","0");  
			  }
	  });*/
  $(".country-sort-title").click(function(){
  $(this).siblings('.nav-drop-menu').slideToggle();
});
	
})
$(document).ready(function(){
	/*  留学问问回答收缩  */
$(".view-reply").click(function(){
  $(this).parent().parent().parent().siblings('.inquire-datails').slideToggle();
});
$(".panel-title").click(function(){
  $(this).parent().siblings('.register-box-modal').slideToggle();
});
  /* apply页面查看更多 */
$(".expand-answer").click(function(){
  $(this).css("display","none");
   $(this).siblings('.expand-answers').css("display","initial");
  $(this).parent().siblings('.hider').fadeIn(100);
});
$(".expand-answers").click(function(){
   $(this).css("display","none");
   $(this).siblings('.expand-answer').css("display","initial");
  $(this).parent().siblings('.hider').fadeOut(100);
});
/* 标签页焦点获取 */
$("#tab-1 .first-next").click(function(){
  $('.nav-tabs li:first-child').removeClass('active');
  $('.nav-tabs li:nth-child(2)').addClass('active');
});
$("#last-step").click(function(){
  $('.nav-tabs li:nth-child(2)').removeClass('active');
  $('.nav-tabs li:first-child').addClass('active');
});
$("#next-step").click(function(){
  $('.nav-tabs li:nth-child(2)').removeClass('active');
  $('.nav-tabs li:nth-child(3)').addClass('active');
});

$('.form-group').each(function() {
    var self = $(this),
        input = self.find('input');

    input.focus(function() {
        self.addClass('form-group-focus');
    })

    input.blur(function() {
        if (input.val()) {
            self.addClass('form-group-filled');
        } else {
            self.removeClass('form-group-filled');
        }
        self.removeClass('form-group-focus');
    });
});

$('.i-check').click(function(){
	if($(this).is('.active')){
		 $(this).removeClass('active');
		}else{
	     $(this).addClass('active');
	}
});

});


/* 是时候去飞动画  */
var tid = setInterval(tagline_vertical_slide, 2500);

function tagline_vertical_slide() {
    var curr = $("#tagline ul li.active");
    curr.removeClass("active").addClass("vs-out");
    setTimeout(function() {
        curr.removeClass("vs-out");
    }, 500);

    var nextTag = curr.next('li');
    if (!nextTag.length) {
        nextTag = $("#tagline ul li").first();
    }
    nextTag.addClass("active");
}


/* 验证码 */
var countdown=60; 
function settime(obj) { 
    if (countdown == 0) { 
        obj.removeAttribute("disabled");    
        obj.value="免费获取验证码"; 
        countdown = 60; 
        return;
    } else { 
        obj.setAttribute("disabled", true); 
        obj.value="重新发送(" + countdown + ")"; 
        countdown--; 
    } 
setTimeout(function() { 
    settime(obj) }
    ,1000) 
};
$(function () {
        //当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
        $(function () {
            $(window).scroll(function () {
                if ($(window).scrollTop() > 100) {
                    $(".back-to-top li:nth-child(4)").fadeIn(1500);
                }
                else {
                    $(".back-to-top li:nth-child(4)").fadeOut(1500);
                }
            });
            //当点击跳转链接后，回到页面顶部位置
            $(".back-to-top li:nth-child(1)").click(function () {
                $('body,html').animate({ scrollTop:450 }, 1000); //1000代表1秒时间回到顶点
                return false;
            });
			$(".back-to-top li:nth-child(2)").click(function () {
                $('body,html').animate({ scrollTop:1050 }, 1000); //1000代表1秒时间回到顶点
                return false;
            });
			$(".back-to-top li:nth-child(3)").click(function () {
                $('body,html').animate({ scrollTop:1550 }, 1000); //1000代表1秒时间回到顶点
                return false;
            });
			$(".back-to-top li:nth-child(4)").click(function () {
                $('body,html').animate({ scrollTop:0 }, 1000); //1000代表1秒时间回到顶点
                return false;
            });
			$(".progress-nav li:nth-child(1)").click(function () {
                $('body,html').animate({ scrollTop:0 }, 1000); //1000代表1秒时间回到顶点
                return false;
            });
			$(".progress-nav li:nth-child(2)").click(function () {
                $('body,html').animate({ scrollTop:600 }, 1000); //1000代表1秒时间回到顶点
                return false;
            });
			$(".progress-nav li:nth-child(3)").click(function () {
                $('body,html').animate({ scrollTop:1350 }, 1000); //1000代表1秒时间回到顶点
                return false;
            });
			$(".progress-nav li:nth-child(4)").click(function () {
                $('body,html').animate({ scrollTop:2600 }, 1000); //1000代表1秒时间回到顶点
                return false;
            });
			$(".progress-nav li:nth-child(5)").click(function () {
                $('body,html').animate({ scrollTop:3650 }, 1000); //1000代表1秒时间回到顶点
                return false;
            });
			$(".progress-nav li:nth-child(6)").click(function () {
                $('body,html').animate({ scrollTop:5000 }, 1000); //1000代表1秒时间回到顶点
                return false;
            });
        });
    });
$(document).ready(function() {
		var times = $('.a').text() * 100 ; // 60秒
		countTime = setInterval(function() {
			times = --times < 0 ? 0 : times;
			var ms = Math.floor(times / 100).toString();

			if(ms.length <= 1) {
				ms = "0" + ms;
			}
			var hm = Math.floor(times % 60).toString();
			if(hm.length <= 1) {
				hm = "0" + hm;
			}
			if(times == 0) {
				clearInterval(countTime);
			}
			// 获取分钟、毫秒数
			$(".a").html(ms);
			$(".b").html(hm);
		}, 1000);
	});
	
	
	
		
/*
  $(window).scroll(function(){
	  var isLoading = true;
		var scrollTop = $(this).scrollTop();
		var scrollHeight = $(document).height();
		var windowHeight = $(this).height();
		
		if(!isLoading){
			return false;
		}
		
		if((scrollTop + windowHeight + 50) >= scrollHeight){
			console.log(isLoading);
			//alert("you are in the bottom");
			clearTimeout(time);
			isLoading = false;
			var time = setTimeout(function(){//模拟请求数据延迟时间
				console.log('进入');
				$(".info-list").append('<li><div class="community-list-img"><img src="img/community-02.jpg" alt="查看原文"></div><div class="community-list-text"><p class="list-text-header"><a href="#">去英国留学时吃了这些你还有A4腰吗123？</a></p><p>爱美之心，人皆有之。你有A4腰吗？还是说你是横着的A4腰？哈哈，腾君没有别的意思，再看看别人，反手摸肚脐，锁骨放硬币，酒窝放笔，这群人简直是瘦的不要不要的。...  <a href="#" style="font-size:12px; color:#428bca;">更多></a></p><p class="output_tag"><small>标签 : </small><span><a href="#">英国</a></span></p></div><div class="community-list-date"><p>2016/07/26 已发表</p></div></li>');
				isLoading = true;
			},1000);
		}
	});
	
*/	
	