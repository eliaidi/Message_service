/**
 * @ Desc: 股神微信分享函数
 * @ Dependency: //res.wx.qq.com/open/js/jweixin-1.0.0.js
 * @ Execute:
 *   weixin({
          "url": "//m.jdpay.com/open/ticketSignature",
          "params":{
              "url": 分享地址,
              "callback":"jsonpcallback",
              "title": 分享标题,
              "desc": 分享描述,
              "imgUrl": 分享图片
          }
      })
 */
window.__wxReady = false;
function weixin(config){
    window.jsonpcallback= function (data) {
        wx.config({
            debug:false,
            appId:data.resultData.appId,
            timestamp:data.resultData.timestamp,
            nonceStr:data.resultData.nonceStr,
            signature:data.resultData.signature,
            jsApiList:['onMenuShareTimeline','onMenuShareAppMessage','onMenuShareQQ']
        });
        wx.ready(function () {
            setShareInfo();
            __wxReady = true;
        });
    };
    function sendJsonp(){
        var params={url:config.params.url,callback:config.params.callback},
        //pux测试用
        //var params=config.params,
            codeSearch= function (params) {
                var str='';
                for(var i in params){
                    if(str){
                        str+='&'+i+'='+encodeURIComponent(params[i]);
                    }else{
                        str+='?'+i+'='+encodeURIComponent(params[i]);
                    }
                }
                return str;
            },
            script=null;
        script=document.createElement('script');
        script.src=config.url+codeSearch(params);
        script.async='async';
        document.head.appendChild(script);
    }
    function setShareInfo() {
        wx.onMenuShareTimeline({
            title: config.params.title,
            link: config.params.url,
            imgUrl: config.params.imgUrl,
            success: function () {
                config.params.successCallBack && config.params.successCallBack()
            },
            cancel: function () {
            }
        });
        wx.onMenuShareAppMessage({
            title: config.params.title,
            desc: config.params.desc, // 分享描述
            link: config.params.url, // 分享链接
            imgUrl: config.params.imgUrl,
            type: '', // 分享类型,music、video或link，不填默认为link
            dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
            success: function () {
                config.params.successCallBack && config.params.successCallBack()
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
        wx.onMenuShareQQ({
            title: config.params.title, // 分享标题
            desc: config.params.desc, // 分享描述
            link: config.params.url, // 分享链接
            imgUrl: config.params.imgUrl, // 分享图标
            success: function () {
                config.params.successCallBack && config.params.successCallBack()
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
    }

    __wxReady ? setShareInfo() : sendJsonp();
}