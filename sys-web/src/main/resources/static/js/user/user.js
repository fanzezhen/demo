const UserConstant = {
    API: {BASE: {URL: Constant.API.BASE.URL + "/user", TYPE: "html", DESC: "用户首页"}}
};
// 初始化API接口列表
UserConstant.API["LIST"] = {URL: UserConstant.API.BASE.URL + "/list", TYPE: "html", DESC: "管理员管理"};
UserConstant.API["LIST_PAGE"] = {URL: UserConstant.API.BASE.URL + "/list/page", TYPE: "data", DESC: "管理员分页查询"};
UserConstant.API["EDIT"] = {URL: UserConstant.API.BASE.URL + "/edit", TYPE: "html", DESC: "编辑角色"};
UserConstant.API["SAVE"] = {URL: UserConstant.API.BASE.URL + "/save", TYPE: "data", DESC: "保存用户"};
UserConstant.API["ADD_VIEW"] = {URL: UserConstant.API.BASE.URL + "/add", TYPE: "html", DESC: "新增用户页面"};
UserConstant.API["ADD_DATA"] = {URL: UserConstant.API.BASE.URL + "/add", TYPE: "data", DESC: "新增用户数据"};
UserConstant.API["DEL_BATCH"] = {
    URL: UserConstant.API.BASE.URL + "/del/batch",
    TYPE: "data",
    DESC: "批量删除"
};
UserConstant.API["ROLE"] = {URL: UserConstant.API.BASE.URL + "/role", TYPE: "html", DESC: "角色管理"};
UserConstant.API["ROLE_LIST_PAGE"] = {
    URL: UserConstant.API.BASE.URL + "/role/list/page",
    TYPE: "data",
    DESC: "用户列表分页查询"
};
UserConstant.API["ROLE_EDIT"] = {URL: UserConstant.API.BASE.URL + "/role/edit", TYPE: "html", DESC: "编辑角色"};
UserConstant.API["ROLE_EDIT_BUTTON"] = {URL: UserConstant.API.BASE.URL + "/role/edit-button", TYPE: "html", DESC: "编辑角色"};
UserConstant.API["ROLE_SAVE"] = {URL: UserConstant.API.BASE.URL + "/role/save", TYPE: "data", DESC: "保存角色"};
UserConstant.API["ROLE_SAVE_DETAIL"] = {URL: UserConstant.API.BASE.URL + "/role/save/detail", TYPE: "data", DESC: "保存角色"};
UserConstant.API["ROLE_SAVE_BUTTON"] = {URL: UserConstant.API.BASE.URL + "/role/save-button", TYPE: "data", DESC: "保存角色"};
UserConstant.API["ROLE_DEL_BATCH"] = {
    URL: UserConstant.API.BASE.URL + "/role/del/batch",
    TYPE: "data",
    DESC: "批量删除"
};
UserConstant.API["RULE_LIST"] = {URL: UserConstant.API.BASE.URL + "/rule", TYPE: "html", DESC: "权限管理"};
UserConstant.API["RULE_LIST_PAGE"] = {URL: UserConstant.API.BASE.URL + "/rule/page", TYPE: "data", DESC: "权限分页查询"};
UserConstant.API["RULE_EDIT"] = {URL: UserConstant.API.BASE.URL + "/rule/edit", TYPE: "html", DESC: "编辑权限"};
UserConstant.API["RULE_SAVE"] = {URL: UserConstant.API.BASE.URL + "/rule/save", TYPE: "data", DESC: "保存权限"};
UserConstant.API["RULE_DEL_BATCH"] = {
    URL: UserConstant.API.BASE.URL + "/rule/del/batch",
    TYPE: "data",
    DESC: "批量删除"
};

const UserEnum = {
    ROLE_TYPE: {0: "超级管理员", 1: "管理员", 2: "普通角色", 3: "访客角色"},
    RULE_TYPE: {1: "菜单", 2: "按钮"},
};

const User = {};

layui.use(['element', 'form', 'laypage'], function () {
    const form = layui.form;

    //监听提交
    form.on('submit(search)', function () {
        User.searchPage();
        return false;   // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

});

