// 分页查询
layui.use(['element', 'form', 'laypage'], function () {
    const $ = layui.$;
    const element = layui.element;
    const form = layui.form;
    const laypage = layui.laypage;
    let current = 1;    // 当前页
    let size = 5;   // 每页条数
    let total = 0; // 总条数

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
        ajaxCommit(AdminConstant.API.RULE_LIST_PAGE.URL, CommonConstant.AJAX_TYPE.POST, JSON.stringify(User.queryData()), CommonConstant.CONTENT_TYPE.JSON, pageSuccess, alert_error);
    };

    function pageSuccess(data) {
        const $tbody = $("#tbody");
        $tbody.children().filter('tr').remove();
        data.records.forEach(function (rule) {
            const $tr = $("<tr></tr>"); // 生成一个 tr 元素
            $tr.append($("<td><input type=\"checkbox\" name=\"id\" value=\"" + rule.id + "\" lay-skin=\"primary\"></td>"));
            $tr.append($("<td>" + rule.name + "</td>"));
            $tr.append($("<td>" + (rule.parentPermission != null ? rule.parentPermission.name : "") + "</td>"));
            $tr.append($("<td>" + rule.operationUrl + "</td>"));
            $tr.append($("<td>" + AdminEnum.RULE_TYPE[rule.type] + "</td>"));
            const $tdManage = $(document.createElement('td')); // 生成一个 td 元素
            const $aEdit = $("<a title=\"编辑\" href=\"javascript:;\"></a>");
            $aEdit.attr("onclick", "xadmin.open('修改权限', '" + AdminConstant.API.RULE_EDIT.URL + "?ruleId=" + rule.id + "', 700, 500)");
            $aEdit.append("<i class=\"layui-icon\">&#xe642;</i>");
            $tdManage.append($aEdit);
            const $aDel = $("<a title=\"删除\" onclick=\"admin_del(this, " + rule.id + ")\" href=\"javascript:;\"></a>");
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
        ajaxCommit(AdminConstant.API.DEL_BATCH.URL, CommonConstant.AJAX_TYPE.POST, "idList=" + idList, CommonConstant.CONTENT_TYPE.FORM, successDel, alert_error);
    });
}

function successDel() {
    layer.msg('删除成功', {icon: 1});
    $(".layui-form-checked").not('.header').parents('tr').remove();
}

/*角色-启用/停用*/
function admin_stop(adminId, $obj, STATUS) {
    layer.confirm('确认要' + $obj.attr('title') + '吗？', function () {
        ajaxCommit(AdminConstant.API.SAVE.URL, CommonConstant.AJAX_TYPE.POST, JSON.stringify({
            id: adminId,
            status: STATUS.CHANGE
        }), CommonConstant.CONTENT_TYPE.JSON, success, alert_error);
    });

    function success() {
        $obj.attr('title', STATUS.NAME);
        $obj.attr("onclick", "admin_stop(this, CommonEnum.STATUS[" + STATUS.CHANGE + "])");
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
function admin_del(obj, ruleId) {
    layer.confirm('确认要删除吗？', function () {
        ajaxCommit(AdminConstant.API.SAVE.URL, CommonConstant.AJAX_TYPE.POST, JSON.stringify({
            id: ruleId,
            delFlag: 1
        }), CommonConstant.CONTENT_TYPE.JSON, success, alert_error);
    });

    function success() {
        $(obj).parents("tr").remove();
        layer.msg('已删除!', {icon: 1, time: 1000});
    }
}


