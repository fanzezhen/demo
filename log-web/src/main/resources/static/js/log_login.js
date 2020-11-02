const LogLoginConstant = {
    API: {BASE: {URL: LogConstant.API.BASE.URL + "/login", TYPE: "html", DESC: "日志"}}
};
// 初始化API接口列表
LogLoginConstant.API["PAGE"] = {URL: LogLoginConstant.API.BASE.URL + "/page", TYPE: "data/html", DESC: "登录日志"};


$(function () {
    const $table = $("#table");
    init();

    function init() {
        $table.bootstrapTable({
            url: LogLoginConstant.API.PAGE.URL,
            method: 'post',
            striped: true,
            minimumCountColumns: 1,
            queryParamsType: 'limit',
            queryParams: queryParams,
            pagination: true,
            idField: 'id',
            height: getHeight(),
            weight: '100%',
            pageSize: '50',
            pageList: '[50,100,200]',
            showFooter: true,
            sidePagination: 'server',
            responseHandler: responseHandler,
            detailView: true,
            toolbar: "#toolbar",
            columns: [
                {
                    field: 'username',
                    title: '用户名',
                    align: 'center',
                    valign: 'middle',
                    width: '8%'
                },
                {
                    field: 'logType',
                    title: '日志类型',
                    formatter: function (value, row, index) {
                        switch (value) {
                            case 1:
                                return "新增"
                            case 2:
                                return "删除"
                            case 3:
                                return "修改"
                        }
                    },
                    align: 'center',
                    width: '12%',
                    valign: 'middle',
                    sortable: true
                },
                {
                    field: 'ip',
                    title: 'IP地址',
                    align: 'center',
                    width: '12%',
                    valign: 'middle',
                    sortable: true
                },
                {
                    field: 'os',
                    title: '操作系统',
                    align: 'center',
                    width: '12%',
                    valign: 'middle',
                    sortable: true
                },
                {
                    field: 'browserName',
                    title: '浏览器名称',
                    align: 'center',
                    width: '12%',
                    valign: 'middle',
                    sortable: true
                },
                {
                    field: 'browserVersion',
                    title: '浏览器版本',
                    align: 'center',
                    valign: 'middle',
                    width: '12%',
                    sortable: true
                },
                {
                    field: 'remark',
                    title: '备注',
                    align: 'center',
                    valign: 'middle',
                    width: '12%',
                    sortable: true
                },
                {
                    field: 'createTime',
                    title: '时间',
                    align: 'center',
                    valign: 'middle',
                    width: '12%',
                    sortable: true
                },
                {
                    field: 'appCode',
                    title: '所属应用',
                    align: 'center',
                    valign: 'middle',
                    width: '12%',
                    sortable: true
                },
            ]
        });

        setTimeout(function () {
            $table.bootstrapTable('resetView');
        }, 200);

        $(window).resize(function () {
            $table.bootstrapTable('resetView', {
                height: getHeight()
            });
        });
    }

    function getHeight() {
        return Math.max($(window).height() - 250, $(window).height() - 100);
    }

    function queryParams(params) {
        params['title'] = $('#search-content-text1').val();
        params['title'] = $('#search-content-text2').val();
        params['projectCode'] = $('#projectCode').val();
        params['type'] = $('#searchType').val();
        params['daterange'] = $('#id-daterange').val();
        return params;
    }


    $('#btn_query').click(function () {
        $table.bootstrapTable('refreshOptions', {
            queryParams: queryParams,
            pageNumber: 1
        });
    });

    function responseHandler(res) {
        $.each(res.data.records, function (i, cate_data) {
            $('#cate_id_' + cate_data.id).text('(' + cate_data.count + ')');
        });
        res.cate_data = res.data.records;
        return {
            page: res.data.total,
            pages: res.data.total,
            count: res.data.total,
            total: res.data.total, //总页数,前面的key必须为"total"
            data: res.data.records, //行数据，前面的key要与之前设置的dataField的值一致.
            cate_data:res.data.records
        }
    }

    $('#daterange-btn').daterangepicker(
        {
            ranges: {
                '今天': [moment(), moment()],
                '昨天': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                '近一周': [moment().subtract(6, 'days'), moment()],
                '近30天': [moment().subtract(29, 'days'), moment()],
                '本月': [moment().startOf('month'), moment().endOf('month')]
            },
            startDate: moment().subtract(60, 'days'),
            opens: 'right', //日期选择框的弹出位置
            buttonClasses: ['btn btn-default'],
            applyClass: 'btn-small btn-primary blue',
            cancelClass: 'btn-small',
            endDate: moment(),
            format: 'YYYY-MM-DD', //控件中from和to 显示的日期格式
            separator: 'to',
            autoUpdateInput: false,
            locale: {
                applyLabel: '确定',
                cancelLabel: '取消',
                fromLabel: '起始时间',
                toLabel: '结束时间',
                customRangeLabel: '自定义',
                daysOfWeek: ['日', '一', '二', '三', '四', '五', '六'],
                monthNames: ['一月', '二月', '三月', '四月', '五月', '六月',
                    '七月', '八月', '九月', '十月', '十一月', '十二月'],
                firstDay: 1
            }
        },
        function (start, end) {
            $('#daterange-btn span').html(start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
            $('#id-daterange').val(start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
        }
    );
});

