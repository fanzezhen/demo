// 分页查询
layui.use(['element', 'form', 'laypage'], function () {
    const $ = layui.$;
    const element = layui.element;
    const form = layui.form;
    const laypage = layui.laypage;
    let current = 1;    // 当前页
    let size = 5;   // 每页条数
    let total = 0; // 总条数

    //监听提交
    form.on('submit(search)', function () {
        User.searchPage();
        return false;   // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    User.queryData = function () {
        const searchForm = form.val("searchForm");
        return {
            "current": current,
            "size": size,
            "startDate": searchForm.start,
            "endDate": searchForm.end,
            "param": searchForm
        };
    };


    User.searchPage = function () {
        ajaxCommit(UserConstant.API.ROLE_LIST_PAGE.URL, CommonConstant.AJAX_TYPE.POST, JSON.stringify(User.queryData()), CommonConstant.CONTENT_TYPE.JSON, pageSuccess, alert_error);
    };

    function pageSuccess(data) {
        const $tbody = $("#tbody");
        $tbody.children().filter('tr').remove();
        data.records.forEach(function (role) {
            const $tr = $("<tr></tr>"); // 生成一个 tr 元素
            $tr.append($("<td><input type=\"checkbox\" name=\"id\" value=\"" + role.id + "\" lay-skin=\"primary\"></td>"));
            $tr.append($("<td>" + role.roleName + "</td>"));
            $tr.append($("<td>" + UserEnum.ROLE_TYPE[role.roleType] + "</td>"));
            $tr.append($("<td>" + role.description + "</td>"));
            $tr.append($("<td class=\"td-status\">" + CommonEnum.STATUS[role.status].HTML + "</td>"));
            const $tdManage = $(document.createElement('td')); // 生成一个 td 元素
            const $aStatus = $("<a href=\"javascript:;\"></a>");
            $aStatus.attr("title", CommonEnum.STATUS[CommonEnum.STATUS[role.status].CHANGE].NAME);
            $aStatus.attr("onclick", "role_stop('" + role.id + "', $(this), CommonEnum.STATUS[" + role.status + "])");
            $aStatus.append("<i class=\"layui-icon\">" + CommonEnum.STATUS[CommonEnum.STATUS[role.status].CHANGE].ICONFONT + "</i>");
            $tdManage.append($aStatus);
            const $aEdit = $("<a title=\"编辑\" href=\"javascript:;\"></a>");
            $aEdit.attr("onclick", "xadmin.open('修改角色', '" + UserConstant.API.ROLE_EDIT.URL + "?roleId=" + role.id + "', 700, 600)");
            $aEdit.append("<i class=\"layui-icon\">&#xe642;</i>");
            $tdManage.append($aEdit);
            const $aEditButton = $("<a title=\"编辑\" href=\"javascript:;\"></a>");
            $aEditButton.attr("onclick", "xadmin.open('修改角色按钮权限', '" + UserConstant.API.ROLE_EDIT_BUTTON.URL + "?roleId=" + role.id + "', 700, 600)");
            $aEditButton.append("<i class=\"layui-icon\">&#xe642;</i>");
            $tdManage.append($aEditButton);
            const $aDel = $("<a title=\"删除\" onclick=\"role_del(this, " + role.id + ")\" href=\"javascript:;\"></a>");
            $aDel.append("<i class=\"layui-icon\">&#xe640;</i>");
            $tdManage.append($aDel);
            $tr.append($tdManage);
            $tbody.append($tr);
        });

        total = data.total;
        User.paged();
        element.init();
        form.render();
    }

    /**
     * 分页方法
     */
    User.paged = function () {
        laypage.render({
            elem: 'ym',
            count: total, //数据总数，从服务端得到
            curr: current,
            limit: size,
            layout: ['prev', 'page', 'next', 'count', 'skip'],
            jump: function (obj, first) {
                current = obj.curr;
                total = obj.count;
                //首次不执行
                if (!first) {
                    User.searchPage();
                }
            }
        });
    };

    User.searchPage();
});

function delAll() {
    const idList = [];

    // 获取选中的id
    $('tbody input').each(function () {
        if ($(this).prop('checked')) {
            idList.push($(this).val())
        }
    });

    layer.confirm('确认要删除吗？' + idList.toString(), function () {
        //捉到所有被选中的，发异步进行删除
        ajaxCommit(UserConstant.API.ROLE_DEL_BATCH.URL, CommonConstant.AJAX_TYPE.POST, "idList=" + idList, CommonConstant.CONTENT_TYPE.FORM, successDel, alert_error);
    });
}

function successDel() {
    layer.msg('删除成功', {icon: 1});
    $(".layui-form-checked").not('.header').parents('tr').remove();
}

/*角色-启用/停用*/
function role_stop(roleId, $obj, STATUS) {
    layer.confirm('确认要' + $obj.attr('title') + '吗？', function () {
        ajaxCommit(UserConstant.API.ROLE_SAVE.URL, CommonConstant.AJAX_TYPE.POST, JSON.stringify({
            id: roleId,
            status: STATUS.CHANGE
        }), CommonConstant.CONTENT_TYPE.JSON, success, alert_error);
    });

    function success() {
        $obj.attr('title', STATUS.NAME);
        $obj.attr("onclick", "role_stop(this, CommonEnum.STATUS[" + STATUS.CHANGE + "])");
        $obj.find('i').html(STATUS.ICONFONT);
        $obj.parents("tr").find(".td-status").find('span')
            .removeClass('layui-btn-normal')
            .removeClass('layui-btn-disabled')
            .addClass(CommonEnum.STATUS[STATUS.CHANGE].BTN_CLASS)
            .html(CommonEnum.STATUS[STATUS.CHANGE].NAME);
        layer.msg("已" + CommonEnum.STATUS[STATUS.CHANGE].NAME, {
            icon: CommonEnum.STATUS[STATUS.CHANGE].ICON,
            time: 1000
        });
    }
}

/*角色-删除*/
function role_del(obj, userId) {
    layer.confirm('确认要删除吗？', function () {
        ajaxCommit(UserConstant.API.ROLE_SAVE.URL, CommonConstant.AJAX_TYPE.POST, JSON.stringify({
            id: userId,
            delFlag: 1
        }), CommonConstant.CONTENT_TYPE.JSON, success, alert_error);
    });

    function success() {
        $(obj).parents("tr").remove();
        layer.msg('已删除!', {icon: 1, time: 1000});
    }
}


