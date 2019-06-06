$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysdduinfo/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 50, key: true},
            {label: '名字', name: 'name', index: 'name', width: 80},
            {
                label: '性别', name: 'sex', index: 'sex', width: 80,
                formatter: function (item, index) {
                    console.log(item);
                    if (item === 0) {
                        return "男"
                    }
                    if (item === 1) {
                        return "女"
                    }
                }
            },
            {
                label: '账户', name: 'userId', index: 'user_id', width: 80
            },
            {
                label: '密码', name: 'password', index: 'password', width: 80,
                formatter: function (item, index) {
                    console.log(item);
                    if (item === null) {
                        return "密码为空"
                    } else {
                        return "******"
                    }
                }
            }
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        sysDduinfo: {},
        radioData: [
            {value: '0', show: '男'},
            {value: '1', show: '女'}
        ],
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.sysDduinfo = {};
        },
        update: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";
            vm.getInfo(id);

            console.log("vm:" + JSON.stringify(vm.sysDduinfo))

        },
        saveOrUpdate: function (event) {
            $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function () {
                var url = vm.sysDduinfo.id == null ? "sys/sysdduinfo/save" : "sys/sysdduinfo/update";
                console.log(JSON.stringify(vm.sysDduinfo));
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.sysDduinfo),
                    success: function (r) {
                        if (r.code === 0) {
                            layer.msg("操作成功", {icon: 1});
                            vm.reload();
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        } else {
                            layer.alert(r.msg);
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        }
                    }
                });
            });
        },
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }
            var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                if (!lock) {
                    lock = true;
                    $.ajax({
                        type: "POST",
                        url: baseURL + "sys/sysdduinfo/delete",
                        contentType: "application/json",
                        data: JSON.stringify(ids),
                        success: function (r) {
                            if (r.code == 0) {
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            } else {
                                layer.alert(r.msg);
                            }
                        }
                    });
                }
            }, function () {
            });
        },
        getInfo: function (id) {
            $.get(baseURL + "sys/sysdduinfo/info/" + id, function (r) {
                vm.sysDduinfo = r.sysDduinfo;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                page: page
            }).trigger("reloadGrid");
        },
        getRadioVal: function (value) {
            console.log(value)
            vm.sysDduinfo.sex = value;
        },
        getPasTpye: function () {
            if (demo_input.type == "password") {
                demo_input.type = "text";
                getpastype.classList.remove("glyphicon-eye-close")
                getpastype.classList.add("glyphicon-eye-open")
            }else {
                demo_input.type = "password";
                getpastype.classList.remove("glyphicon-eye-open")
                getpastype.classList.add("glyphicon-eye-close")
            }
        }
    }
});