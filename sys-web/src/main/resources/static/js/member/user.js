const UserConstant = {
    API: {BASE: {URL: "/user", TYPE: "html", DESC: "用户首页"}}
};
// 初始化API接口列表
UserConstant.API["INFO"] = {URL: UserConstant.API.BASE.URL + "/info", TYPE: "data", DESC: "用户信息"};
UserConstant.API["LIST"] = {URL: UserConstant.API.BASE.URL + "/list", TYPE: "html", DESC: "用户列表"};
UserConstant.API["LIST_PAGE"] = {URL: UserConstant.API.BASE.URL + "/list/page", TYPE: "data", DESC: "用户列表分页查询"};
UserConstant.API["EDIT"] = {URL: UserConstant.API.BASE.URL + "/edit", TYPE: "html", DESC: "编辑用户"};
UserConstant.API["SAVE"] = {URL: UserConstant.API.BASE.URL + "/save", TYPE: "data", DESC: "保存用户"};
UserConstant.API["DEL_BATCH"] = {URL: UserConstant.API.BASE.URL + "/del/batch", TYPE: "data", DESC: "批量删除"};
UserConstant.API["CHANGE_PASSWORD"] = {URL: UserConstant.API.BASE.URL + "/change-password", TYPE: "html", DESC: "修改密码"};

const UserEnum = {
    SEX: {0: "女", 1: "男", 2: "未知的性别", 3: "未说明的性别"},
};

const User = {};
