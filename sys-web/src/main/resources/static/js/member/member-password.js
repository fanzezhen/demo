layui.use(['form', 'layer'], function () {
    $ = layui.jquery;
    const form = layui.form, layer = layui.layer;

    //自定义验证规则
    form.verify({
        username: function (value) {
            if (value.length < 6) {
                return '登录名至少得6个字符啊';
            }
        },
        password: [/(.+){6,12}$/, '密码必须6到12位'],
        rePass: function () {
            if ($('#L_pass').val() !== $('#L_re_pass').val()) {
                return '两次密码不一致';
            }
        }
    });

    //监听提交
    form.on('submit(save)', function (data) {
        ajaxCommit(UserConstant.API.SAVE.URL, CommonConstant.AJAX_TYPE.POST, JSON.stringify(data.field), CommonConstant.CONTENT_TYPE.JSON, success, alert_error);
        return false;
    });

    function success(data) {
        if (data.data)
            layer.alert(data.msg, {icon: 6}, function () {
                // 获得frame索引
                const index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
        else
            layer.alert(data.msg, {icon: 6}, function () {
            });
    }
});
