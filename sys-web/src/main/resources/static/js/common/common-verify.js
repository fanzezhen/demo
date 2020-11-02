const CommonVerify = {};

CommonVerify.requiredVerify = function (id, msg) {
    const requiredElem = $("#" + id);
    if (requiredElem.val()) return true;
    else {
        //定位焦点
        requiredElem.css({"border-color": "#FF5722"}).focus();
        alert_error(msg);
        return false;
    }
}

CommonVerify.intVerify = function (id, msg) {
    const requiredElem = $("#" + id);
    if (requiredElem.val() && NumberUtil.isInteger(requiredElem.val())) return true;
    else {
        //定位焦点
        requiredElem.css({"border-color": "#FF5722"}).focus();
        alert_error(msg);
        return false;
    }
}
