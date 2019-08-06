/**
 * Created by BETTY on 2019/3/14.
 */

/* 登录 */
$("#loginBtn").click(function () {
    var username = $('input[name=uname]').val();
    var password = $('input[name=upwd]').val();

    if (username == "") {
        $('input[name=uname]').addClass("inp-hover");
        return false;
    }
    if (password == "") {
        $('input[name=upwd]').addClass("inp-hover");
        return false;
    }

    $(this).prop("disabled",true).html("<span class='loading'></span>");
    $.ajax({
        type: "POST",
        url: getWebRootPath()+"/user/login",
        data: JSON.stringify({"username":username, "password":password}),
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function(data,status,xhr){

            if (data.success) {
//                sessionStorage.identity = xhr.getResponseHeader("x-auth-token");
//                sessionStorage.userMsg = JSON.stringify({uName:username});
                window.location.href = "./index.html";
            } else {
                $('input[name=uname]').addClass("inp-hover");
                $('input[name=upwd]').addClass("inp-hover");

                $("#msgModal .modal-body").html(data.message);
                $('#msgModal').modal('show');
                $("#loginBtn").prop("disabled",false).html("登&nbsp;录");
            }
        },
        error: function (error) {
            $("#msgModal .modal-body").html("登录异常");
            $('#msgModal').modal('show');
            $("#loginBtn").prop("disabled",false).html("登&nbsp;录");
        }
    });
});

$(".form-control").blur(function () {
    $(".form-control").removeClass("inp-hover");
});
$(".form-control").keyup(function () {
    $(".form-control").removeClass("inp-hover");
});

function onEnter() {
    if (event.keyCode == 13){
        document.getElementById("loginBtn").click();
    }
}

var getWebRootPath = function () {
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPath = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/uimcardprj
    // var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPath);
};
/* 返回 */
$(".a2").click(function () {
    window.location.href = "./index.html";
});

/* 点击注册 */
$("#login").on("click",".a3",function () {
    $("#login").hide();
    $("#register").show();

});
// $("#registerBtn").click(function () {
//     var username=$('input[name=uname2]').val();
//     var mobile=$('input[name=uphone2]').val();
//     var password=$('input[name=upwd2]').val();
//     $(this).attr("disabled","true").html("<span class='loading'></span>");
//         $.ajax({
//             type: "POST",
//             url: getWebRootPath()+"/api/admin/user",
//             data: JSON.stringify({"username":username, "password":password,"mobile":mobile}),
//             contentType: "application/json;charset=utf-8",
//             dataType: "json",
//             success: function(data){
//                 if (data.success) {
//                     //sessionStorage.identity = xhr.getResponseHeader("x-auth-token");
//                     alert("注册成功");
//                     window.location.href = "./index.html";
//                 } else {
//                     alert("注册失败");
//                     //location.reload();
//                 }
//             }
//         });
// });

/* 点击登录 */
$("#register").on("click",".a3",function () {
    $("#register").hide();
    $("#login").show();
});