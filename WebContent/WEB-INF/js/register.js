$(function (){

    var timer = null;

    var Register = function(){

        //是否验证通过手机号
        this.validateMobile = false;

        //是否已经发送过验证码
        this.hasSendSmsCode = false;

        this.getSmsCodeUrl = '/msgService/getSmsCode';

        this.validateCodeUrl = '/validateCode';

    }

    Register.prototype = {

        constructor: Register,


        init: function(){

            this.attachEvent();

            this.formValidate();

        },

        //一些初始化的事件绑定
        attachEvent: function(){
            $(document.body).on('click', '.select-item', function(){
                if($(this).hasClass('active')){
                    return;
                }
                else {
                    $(this).siblings().removeClass('active');
                    $(this).addClass('active')
                }
                $('#memberType').val($('.active').attr('data-type'))
            })
        },

        //绑定验证码事件
        smsCodeActive: function(){

            var _this = this;

            //先把之前的所有事件移除
            $('.validate-btn').off('click');

            $('.validate-btn').addClass('active');
            $('.validate-btn').on('click', function(){
                //获取短信验证码
                _this.getSmsCode();
            })
        },

        //取消绑定验证码事件
        smsCodeDisabled: function(){
            $('.validate-btn').removeClass('active');
            $('.validate-btn').off('click');
        },

        //验证码倒计时
        smsCodeCountdown: function(){
            var _this = this;
            var timeout = 5;

            timer = window.setInterval(function(){
                console.info(timer)
                if (timeout == 1) {
                    window.clearInterval(timer);
                    _this.smsCodeRecovery();
                    return;
                }
                timeout --;
                $('.validate-btn').html(timeout + '秒后重发');
            }, 1000);
        },

        //倒计时结束后重新获取
        smsCodeRecovery: function(){

            if(timer){
                window.clearInterval(timer);
                timer = null;
            }

            $('.validate-btn').html('重新获取');
            this.smsCodeActive();
        },

        //获取短信验证码
        getSmsCode: function(){

            var _this = this;

            //避免多次请求
            this.smsCodeDisabled();

            var mobileNumber = $('#mobileNumber').val();
            var ip = $('#ip').val();

            var formData = {clientName:ivagner.clientName, ip:'', reffer:ivagner.getUrlParam('reffer'), auth:'', mobileNumber:mobileNumber};
            var data = JSON.stringify(formData);

            $.ajax({
                type: 'POST',
                dataType: "json",
                url: _this.getSmsCodeUrl,
                contentType : 'application/json',
                data: data,
                success: function(response){
                    if(response.resultCode == '0'){
                        _this.hasSendSmsCode = true;
                        _this.smsCodeCountdown();
                    }else {
                        alert('短信服务不给力, 请稍后再试')

                        console.info(response.resultMsg);
                        _this.smsCodeActive();
                    }
                },
                error: function(XMLHttpRequest, textStatus) {
                    console.info(XMLHttpRequest.status + ' / ' + textStatus);
                    //_this.smsCodeActive();


                    //debug
                    _this.hasSendSmsCode = true;
                    _this.smsCodeCountdown();
                }
            })
        },

        formValidate: function(){

            var _this = this;

            $('form').validate({
                onKeyup : true,
                sendForm: true,
                eachValidField : function() {
                    $(this).closest('div').removeClass('error').addClass('success');
                },
                eachInvalidField : function() {
                    $(this).closest('div').removeClass('success').addClass('error');
                },
                conditional :{
                    password : function() {
                        var pwd = $(this).val();
                        return /^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,20}$/.test(pwd) ;
                    },
                    passwordConfirm : function() {
                        return $(this).val() == $('#password').val();
                    },
                    mobileNumber: function(){
                        _this.validateMobile = /^1(3[0-9]|4[57]|5[0-35-9]|7[0678]|8[0-9])\d{8}$/.test($(this).val());
                        return _this.validateMobile
                    },
                    validateCode: function(){
                        var validate = false;
                        var validateCode = /^[A-Za-z0-9]{4,6}$/.test($(this).val());
                        if(!validateCode){
                            return validate
                        }
                        var formData = {};
                        var data = JSON.stringify(formData);
                        //ajax
                        $.ajax({
                            type: 'POST',
                            dataType: "json",
                            url: _this.validateCodeUrl,
                            contentType : 'application/json',
                            data: data,
                            async: false,
                            success: function(response){
                                if(response.resultCode == '0'){
                                    if(!_this.validateMobile){
                                        validate = false
                                    }
                                    _this.smsCodeActive();

                                    validate = true
                                }else {
                                    alert('服务器异常, 请稍后再试')
                                    console.info(response.resultMsg);

                                    validate = false
                                }
                            },
                            error: function(XMLHttpRequest, textStatus) {
                                console.info(XMLHttpRequest.status + ' / ' + textStatus);
                                //validate = false

                                //debug 假装成功了...
                                if(!_this.validateMobile){
                                    validate = false
                                }
                                _this.smsCodeActive();

                                validate = true
                            }
                        })

                        return validate
                    },
                    smsCode: function(){
                        var smsCode = /^[0-9]{6}$/.test($(this).val());
                        return smsCode && _this.hasSendSmsCode;
                    },
                }
            });
        }


    }

    var register = new Register();

    register.init();
})