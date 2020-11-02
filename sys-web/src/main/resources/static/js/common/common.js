const Common = {};

Common.requiredVerify = function (id, msg) {
    const requiredElem = $("#" + id);
    if (requiredElem.val()) return true;
    else {
        //定位焦点
        requiredElem.css({"border-color": "#FF5722"}).focus();
        alert_error(msg);
        return false;
    }
}

Common.intVerify = function (id, msg) {
    const requiredElem = $("#" + id);
    if (requiredElem.val() && NumberUtil.isInteger(requiredElem.val())) return true;
    else {
        //定位焦点
        requiredElem.css({"border-color": "#FF5722"}).focus();
        alert_error(msg);
        return false;
    }
}

function redirect(url, isNew) {
    if (isNew) {
        window.open(url)
    } else {
        window.location.href = url
    }
}

function mainPage() {
    window.location.href = CommonConstant.API.HOME.URL
}

/**
 * 页面滑动定位到某元素
 * @param elementId
 */
function scrollTo(elementId) {
    $(document.getElementById(elementId)).parent()[0].scrollIntoView({behavior: "smooth", block: "center"})
}

/**
 * 获取URL中指定参数
 * @param name
 * @returns {string|boolean}
 */
function getUrlParamByName(name) {
    // 取得url中'?'后面的字符
    var query = window.location.search.substring(1);
    // 把参数按&拆分成数组
    var param_arr = query.split("&");
    for (var i = 0; i < param_arr.length; i++) {
        var pair = param_arr[i].split("=");
        if (pair[0] === name) {
            return pair[1];
        }
    }
    return false;
}

/**
 * layui表格渲染
 * @param option.table layui的表格组件
 * @param option.elem 表格id
 * @param option.url 渲染数据的后台接口
 * @param option.searchForm 表格筛选项的表单id
 * @param option.cols 表格的表头及对应数据项
 * @param option.done 渲染完毕的回调函数
 * @param option.initSort 排序方式
 */
function tableRender(option) {
    layui.use(['form'], function () {
        const head_csrf = {};
        head_csrf[$("meta[name='_csrf_header']").attr("content")] = $("meta[name='_csrf']").attr("content");
        const param = option.otherParam ? option.otherParam : {};
        const searchForm = layui.form.val(option.searchForm ? option.searchForm : "searchForm");
        if (searchForm)
            $.each(searchForm, function (key, value) {
                if (value) param[key] = value;
                else param[key] = null;
            });
        option.table.render({
            elem: '#' + option.elem,
            url: option.url,
            headers: head_csrf,
            method: CommonConstant.AJAX_TYPE.POST,
            where: {param: param, orders: option.orders},
            contentType: CommonConstant.CONTENT_TYPE.JSON,
            loading: true,
            page: option.page === undefined ? true : option.page,
            cols: option.cols,
            toolbar: option.toolbar,
            defaultToolbar: ['filter', 'print', 'exports'],
            parseData: function (res) { //res 即为原始返回的数据
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.message, //解析提示文本
                    "count": (res.data && res.data.total) ? res.data.total : 0, //解析数据长度
                    "data": (res.data && res.data.records) ? res.data.records : {} //解析数据列表
                };
            },
            request: {
                pageName: 'current',
                limitName: 'size'
            },
            done: option.done,
            response: {
                statusCode: 200 //规定成功的状态码，默认：0
            },
            initSort: option.initSort,
            totalRow: option.totalRow === undefined ? false : option.totalRow,
            limit: option.limit === undefined ? 10 : option.limit
        });
    })
}

/**
 * layui表格重载
 * @param option
 * @param option.table layui的table组件
 * @param option.elem 表格id
 * @param option.searchForm 表格筛选项的表单id
 * @param keepPage 是否保持当前页码
 */
function tableReload(option, keepPage) {
    layui.use(['form'], function () {
        const param = option.otherParam ? option.otherParam : {};
        const searchForm = layui.form.val(option.searchForm ? option.searchForm : "searchForm");
        if (searchForm)
            $.each(searchForm, function (key, value) {
                if (value) param[key] = value;
                else param[key] = null;
            });
        if (keepPage) {
            option.table.reload(option.elem, {
                where: {param: param, orders: option.orders}
            });
        } else {
            option.table.reload(option.elem, {
                where: {param: param, orders: option.orders},
                page: {
                    curr: 1
                }
            });
        }
    })
}
