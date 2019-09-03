;(function(global){

	"use strict";
    //构造函数定义一个类    传参数
    function Wxouath2(el,options) {
        //some code
 
    };
	 Wxouath2.prototype = {
        //定义方法
        getOpenId: function(url) {
            //先看url上面是否有openId
			var openId = this.getUrlParms('openId');
			if(openId == null ){
				openId = Cookies.get('openId');
				alert('从cookie中拿openId');
				alert(openId);
			}else{
				//范进cookie
				Cookies.set('openId',openId);
			}
			//typeof(openId)=='undefined'&&
			if(openId == null){
				var reUrl = window.location.href;
				//alert(reUrl);
				//alert("开始授权")
				window.location.href = url+'?reUrl='+reUrl;
			}else{
				//获取列表
				//alert('获取列表');
				this.getAsset(openId);
			}
        }
        
    };

	global.Wxouath2= Wxouath2;
})(this);