// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(H)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd HH:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d H:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function (fmt) { //author: meizz
    const o = {
        "M+": this.getMonth() + 1,                 //月份
        "d+": this.getDate(),                    //日
        "h+": this.getHours(),                   //小时
        "m+": this.getMinutes(),                 //分
        "s+": this.getSeconds(),                 //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (const k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

const DateUtil = {
    initVar: function (date) {
        const dateTime = new Date(date)
        const YY = dateTime.getFullYear()
        const MM =
            dateTime.getMonth() + 1 < 10
                ? '0' + (dateTime.getMonth() + 1)
                : dateTime.getMonth() + 1
        const DD =
            dateTime.getDate() < 10 ? '0' + dateTime.getDate() : dateTime.getDate()
        const hh =
            dateTime.getHours() < 10
                ? '0' + dateTime.getHours()
                : dateTime.getHours()
        const mm =
            dateTime.getMinutes() < 10
                ? '0' + dateTime.getMinutes()
                : dateTime.getMinutes()
        const ss =
            dateTime.getSeconds() < 10
                ? '0' + dateTime.getSeconds()
                : dateTime.getSeconds()
        return {dateTime: dateTime, YY: YY, MM: MM, DD: DD, hh: hh, mm: mm, ss: ss}
    },
    /**
     * 处理java.time.LocalDateTime类型的数据
     * @param date
     * @returns {{dateTime: Date, YY: number, MM: string, DD: string, hh: string, mm: string, ss: string}}
     */
    initLocalDateVar: function (date) {
        return {dateTime: date, YY: date[0], MM: date[1], DD: date[2], hh: date[3], mm: date[4], ss: date[5]}
    },
    // 格式化date
    formatDate: function (date, isLocal) {
        if (date == null) return ''
        const varMap = isLocal ? this.initLocalDateVar(date) : this.initVar(date)
        return `${varMap.YY}-${varMap.MM}-${varMap.DD}`
    },
    // 格式化datetime
    formatDateTime: function (datetime, isLocal) {
        if (datetime == null) return ''
        const varMap = isLocal ? this.initLocalDateVar(datetime) : this.initVar(datetime)
        return `${varMap.YY}-${varMap.MM}-${varMap.DD} ${varMap.hh}:${varMap.mm}:${varMap.ss}`
    }
}
