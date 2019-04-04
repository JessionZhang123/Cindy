$(function(){
    var url=window.location.protocol+"//"+window.location.host+"/admin/";
    $(".logout").click(function(){         
        $.post(url+"logout",function(data,status){
            if(data=="success"){
                layer.msg("logout success");
                setTimeout(function(){
                    window.location.href=url+"index";
                },1000)
            }

        })

    })
})
