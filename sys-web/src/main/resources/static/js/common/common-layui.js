const CommonLayui = {};
layui.use('form', function () {
    const form = layui.form;

    //自定义验证规则
    form.verify({
        integer: function (value, item) {
            const $ = layui.$;
            const verifyName = $(item).attr('name')
                , verifyType = $(item).attr('type')
                , formElem = $(item).parents('.layui-form')//获取当前所在的form元素，如果存在的话
                , verifyElem = formElem.find('input[name=' + verifyName + ']')//获取需要校验的元素
                , focusElem = verifyElem.next().find('i.layui-icon');//焦点元素
            if (value && !NumberUtil.isInteger(value)) {
                //定位焦点
                focusElem.css(verifyType === 'radio' ? {"color": "#FF5722"} : {"border-color": "#FF5722"});
                //对非输入框设置焦点
                focusElem.first().attr("tabIndex", "1").css("outline", "0").blur(function () {
                    focusElem.css(verifyType === 'radio' ? {"color": ""} : {"border-color": ""});
                }).focus();
                return '只能输入数字';
            }
        },
        integerNotNullEn: function (value, item) {
            const $ = layui.$;
            const verifyName = $(item).attr('name')
                , verifyType = $(item).attr('type')
                , formElem = $(item).parents('.layui-form')//获取当前所在的form元素，如果存在的话
                , verifyElem = formElem.find('input[name=' + verifyName + ']')//获取需要校验的元素
                , focusElem = verifyElem.next().find('i.layui-icon');//焦点元素
            if (!value || !NumberUtil.isInteger(value)) {
                //定位焦点
                focusElem.css(verifyType === 'radio' ? {"color": "#FF5722"} : {"border-color": "#FF5722"});
                //对非输入框设置焦点
                focusElem.first().attr("tabIndex", "1").css("outline", "0").blur(function () {
                    focusElem.css(verifyType === 'radio' ? {"color": ""} : {"border-color": ""});
                }).focus();
                return 'Enter only Numbers(1 to 10) and cannot be null !';
            }
        },
        integerNotNullRangeOneAndTenEn: function (value, item) {
            const $ = layui.$;
            const verifyName = $(item).attr('name')
                , verifyType = $(item).attr('type')
                , formElem = $(item).parents('.layui-form')//获取当前所在的form元素，如果存在的话
                , verifyElem = formElem.find('input[name=' + verifyName + ']')//获取需要校验的元素
                , focusElem = verifyElem.next().find('i.layui-icon');//焦点元素
            if (!value || !NumberUtil.isInteger(value) || value > 10 || value < 1) {
                //定位焦点
                focusElem.css(verifyType === 'radio' ? {"color": "#FF5722"} : {"border-color": "#FF5722"});
                //对非输入框设置焦点
                focusElem.first().attr("tabIndex", "1").css("outline", "0").blur(function () {
                    focusElem.css(verifyType === 'radio' ? {"color": ""} : {"border-color": ""});
                }).focus();
                return 'Enter only Numbers and cannot be null !';
            }
        },
        otherReq: function (value, item) {
            const $ = layui.$;
            const verifyName = $(item).attr('name')
                , verifyType = $(item).attr('type')
                , formElem = $(item).parents('.layui-form')//获取当前所在的form元素，如果存在的话
                , verifyElem = formElem.find('input[name=' + verifyName + ']')//获取需要校验的元素
                , isTrue = verifyElem.is(':checked')//是否命中校验
                , focusElem = verifyElem.next().find('i.layui-icon');//焦点元素
            if (!isTrue || !value) {
                //定位焦点
                focusElem.css(verifyType === 'radio' ? {"color": "#FF5722"} : {"border-color": "#FF5722"});
                //对非输入框设置焦点
                focusElem.first().attr("tabIndex", "1").css("outline", "0").blur(function () {
                    focusElem.css(verifyType === 'radio' ? {"color": ""} : {"border-color": ""});
                }).focus();
                return '必填项不能为空';
            }
        },
        otherReqEn: function (value, item) {
            const $ = layui.$;
            const verifyName = $(item).attr('name')
                , verifyType = $(item).attr('type')
                , formElem = $(item).parents('.layui-form')//获取当前所在的form元素，如果存在的话
                , verifyElem = formElem.find('input[name=' + verifyName + ']')//获取需要校验的元素
                , isTrue = verifyElem.is(':checked')//是否命中校验
                , focusElem = verifyElem.next().find('i.layui-icon');//焦点元素
            if (!isTrue || !value) {
                //定位焦点
                focusElem.css(verifyType === 'radio' ? {"color": "#FF5722"} : {"border-color": "#FF5722"});
                //对非输入框设置焦点
                focusElem.first().attr("tabIndex", "1").css("outline", "0").blur(function () {
                    focusElem.css(verifyType === 'radio' ? {"color": ""} : {"border-color": ""});
                }).focus();
                return 'Required fields cannot be empty';
            }
        },
        moreThanTwo: function (value, item) {
            const $ = layui.$;
            const verifyName = $(item).attr('name')
                , verifyType = $(item).attr('type')
                , formElem = $(item).parents('.layui-form')//获取当前所在的form元素，如果存在的话
                , verifyElem = formElem.find('input[name=' + verifyName + ']')//获取需要校验的元素
                , isTrue = verifyElem.is(':checked')//是否命中校验
                , focusElem = verifyElem.next().find('i.layui-icon')//焦点元素
                , len = $("input:checkbox[name=" + verifyName + "]:checked").length;
            if (!isTrue || !value || len < 2) {
                //定位焦点
                focusElem.css(verifyType === 'radio' ? {"color": "#FF5722"} : {"border-color": "#FF5722"});
                //对非输入框设置焦点
                focusElem.first().attr("tabIndex", "1").css("outline", "0").blur(function () {
                    focusElem.css(verifyType === 'radio' ? {"color": ""} : {"border-color": ""});
                }).focus();
                return '至少选择两条';
            }
        },
        moreThanThree: function (value, item) {
            const $ = layui.$;
            const verifyName = $(item).attr('name')
                , verifyType = $(item).attr('type')
                , formElem = $(item).parents('.layui-form')//获取当前所在的form元素，如果存在的话
                , verifyElem = formElem.find('input[name=' + verifyName + ']')//获取需要校验的元素
                , isTrue = verifyElem.is(':checked')//是否命中校验
                , focusElem = verifyElem.next().find('i.layui-icon')//焦点元素
                , len = $("input:checkbox[name=" + verifyName + "]:checked").length;
            if (!isTrue || !value || len < 3) {
                //定位焦点
                focusElem.css(verifyType === 'radio' ? {"color": "#FF5722"} : {"border-color": "#FF5722"});
                //对非输入框设置焦点
                focusElem.first().attr("tabIndex", "1").css("outline", "0").blur(function () {
                    focusElem.css(verifyType === 'radio' ? {"color": ""} : {"border-color": ""});
                }).focus();
                return '至少选择三条';
            }
        },
        moreThanThreeEn: function (value, item) {
            const $ = layui.$;
            const verifyName = $(item).attr('name')
                , verifyType = $(item).attr('type')
                , formElem = $(item).parents('.layui-form')//获取当前所在的form元素，如果存在的话
                , verifyElem = formElem.find('input[name=' + verifyName + ']')//获取需要校验的元素
                , isTrue = verifyElem.is(':checked')//是否命中校验
                , focusElem = verifyElem.next().find('i.layui-icon')//焦点元素
                , len = $("input:checkbox[name=" + verifyName + "]:checked").length;
            if (!isTrue || !value || len < 3) {
                //定位焦点
                focusElem.css(verifyType === 'radio' ? {"color": "#FF5722"} : {"border-color": "#FF5722"});
                //对非输入框设置焦点
                focusElem.first().attr("tabIndex", "1").css("outline", "0").blur(function () {
                    focusElem.css(verifyType === 'radio' ? {"color": ""} : {"border-color": ""});
                }).focus();
                return 'Please select three items!';
            }
        },
        lessThanThree: function (value, item) {
            const $ = layui.$;
            const verifyName = $(item).attr('name')
                , verifyType = $(item).attr('type')
                , formElem = $(item).parents('.layui-form')//获取当前所在的form元素，如果存在的话
                , verifyElem = formElem.find('input[name=' + verifyName + ']')//获取需要校验的元素
                , isTrue = verifyElem.is(':checked')//是否命中校验
                , focusElem = verifyElem.next().find('i.layui-icon')//焦点元素
                , len = $("input:checkbox[name=" + verifyName + "]:checked").length;
            if (!isTrue || !value || len > 3) {
                //定位焦点
                focusElem.css(verifyType === 'radio' ? {"color": "#FF5722"} : {"border-color": "#FF5722"});
                //对非输入框设置焦点
                focusElem.first().attr("tabIndex", "1").css("outline", "0").blur(function () {
                    focusElem.css(verifyType === 'radio' ? {"color": ""} : {"border-color": ""});
                }).focus();
                return '必选且至多选择三条';
            }
        }
    });
});

function alert_info(info) {
    layer.msg(info, {icon: 6});
}

function alert_success(info) {
    layer.msg(JSON.stringify(info), {icon: 1});
}

function alert_error(info) {
    layer.msg(JSON.stringify(info), {icon: 2});
}

function alert_confirm(tip, ensure) {
    layer.confirm(tip, {
        skin: 'layui-layer-admin'
    }, function (index) {
        ensure(index);
    });
}

/**
 * 公共ajax提交
 * @param url
 * @param type
 * @param data
 * @param contentType
 * @param success
 * @param successFailure
 * @param error
 * @param isAsync
 * @param isShowLoading
 */
function ajaxCommit(url, type, data, contentType, success, successFailure, error, isAsync = true, isShowLoading = true) {
    const token = $("meta[name='_csrf']").attr("content");
    const header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
    $.ajax({
        async: isAsync,
        type: type,
        url: url,
        data: data,
        contentType: contentType,
        beforeSend: function () {
            if (isShowLoading)
                layer.load(0, {shade: [0.4, '#fff']});
        },
        success: function (result) {
            if (CommonConstant.RESPONSE_CODE.SUCCESS === result.code) {
                if (success) success(result.data);
                else alert_success(result.message);
            } else {
                if (successFailure) successFailure(result);
                else alert_error(result.message)
            }
            if (layer !== undefined) layer.closeAll('loading');
        },
        error: function (result) {
            if (error) error(result);
            else {
                if (result.responseJSON != null) alert_error(result.responseJSON.message + "!");
                else alert_error("请求失败!");
            }
            if (layer !== undefined) layer.closeAll('loading');
        },
        done: function () {
            if (layer !== undefined) layer.closeAll('loading');
        }
    });
}

/**
 * 放大图片预览
 * @param obj
 */
function showImg(obj) {
    const img = new Image();
    img.src = $("#" + obj).attr("src");
    let height = img.height; // 原图片大小
    let width = img.width; //原图片大小

    const winHeight = $(window).height() - 80;  // 浏览器可视部分高度
    const winWidth = $(window).width() - 100;  // 浏览器可视部分宽度

    // 如果图片高度或者宽度大于限定的高度或者宽度则进行等比例尺寸压缩
    if (height > winHeight || width > winWidth) {
        // 1.原图片宽高比例 大于等于 图片框宽高比例
        if (winWidth / winHeight <= width / height) {
            width = winWidth;   //以框的宽度为标准
            height = winWidth * (height / width);
        }

        // 2.原图片宽高比例 小于 图片框宽高比例
        if (winWidth / winHeight > width / height) {
            width = winHeight * (width / height);
            height = winHeight;   //以框的高度为标准
        }
    }
    const imgHtml = "<img src='" + img.src + "' width='" + width + "px' height='" + height + "px'  alt=''/>";
    //弹出层
    layer.open({
        type: 1,
        shade: [0.4, '#fff'],
        offset: 'auto',
        title: false,
        skin: 'layui-layer-admin',
        area: [width + 'px', height + 'px'],  //原图显示,高度+50是为了去除掉滚动条
        shadeClose: true,
        scrollbar: false,
        content: imgHtml, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
        cancel: function () {
            //layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', { time: 5000, icon: 6 });
        }
    });
}

CommonLayui.open = function (){
    layer.open({
        type: 2,
        title: '信息修改',
        maxmin: true,
        content: 'ins-xxxg.html',
        skin: 'layui-layer-admin',
        area: ['95%', '95%'],
        shade: false,
        moveOut: true,
    });
}
CommonLayui.openByApi = function (API, param){
    const uri = param ? API.URL + param : API.URL;
    layer.open({
        type: 2,
        title: API.DESC,
        maxmin: true,
        content: encodeURI(uri),
        skin: 'layui-layer-admin',
        area: ['95%', '95%'],
        shade: false,
        moveOut: true,
    });
}
