const CommonConstant = {
    RESPONSE_CODE: {
        SUCCESS: 200
    },
    CONTENT_TYPE: {
        JSON: "application/json;charset=utf-8",
        FORM: "application/x-www-form-urlencoded;charset=utf-8"
    },
    AJAX_TYPE: {
        POST: "POST"
    },
    API: {
        BASE: {URL: "/framework", TYPE: "html", DESC: "前缀"}
    }
};

// 初始化API接口列表
CommonConstant.API["HOME"] = {URL: CommonConstant.API.BASE.URL + "/hello", TYPE: "html", DESC: "首页"};
