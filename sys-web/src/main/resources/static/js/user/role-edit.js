layui.use(['element', 'form', 'laypage'], function () {
    const Role = {};
    $ = layui.jquery;
    var form = layui.form
        , layer = layui.layer;

    //自定义验证规则
    form.verify({
        username: function (value) {
            if (value.length < 3) {
                return '名称至少得3个字符啊';
            }
        }
    });

    form.on('checkbox(father)', function (data) {

        if (data.elem.checked) {
            $(data.elem).parent().siblings('td').find('input').prop("checked", true);
            form.render();
        } else {
            $(data.elem).parent().siblings('td').find('input').prop("checked", false);
            form.render();
        }
    });

    //监听提交
    form.on('submit(edit)', function (data) {
        //获取checkbox[name='permissions']的值
        const permissionIdSet = [];
        $("input:checkbox[name='permissions']:checked").each(function (i) {
            permissionIdSet[i] = $(this).val();
        });
        data.field.permissionIdSet = permissionIdSet;
        //发异步，把数据提交
        console.log(JSON.stringify(data.field));
        ajaxCommit(AdminConstant.API.ROLE_SAVE.URL, CommonConstant.AJAX_TYPE.POST, JSON.stringify(data.field), CommonConstant.CONTENT_TYPE.JSON, Role.saveSuccess, alert_error);
        return false;
    });

    Role.saveSuccess = function (data) {
        console.debug(data);
        layer.alert("保存成功", {icon: 6}, function () {
            // 获得frame索引
            const index = parent.layer.getFrameIndex(window.name);
            //关闭当前frame
            parent.layer.close(index);
        });
    }
});

