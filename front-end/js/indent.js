new Vue({
    el: '.title_container',
    data: {
        post: {
            activeIndex: '0'
        }
    }
})

var mainc=new Vue({
    el:'#mains',
    data: {
        data1:[
            {
                indent_id: '10000000',
                time_stamp:'2019-05-19 16:32:26',
                total_price:100,
                state:0,
                books:[{
                    books_price:30,
                    books_num:3,
                    book_price:10
                },{
                    books_price:70,
                    books_num:2,
                    book_price:35
                }]
            },{
                indent_id: '10000001',
                time_stamp:'2019-05-17 16:32:26',
                total_price:200,
                state:1,
                books:[{
                    books_price:150,
                    books_num:3,
                    book_price:50
                },{
                    books_price:50,
                    books_num:1,
                    book_price:50
                }]
            }
                ]
    },
    methods: {
        opendelete(item,event) {
            var e = event || window.event;
            this.$confirm('此操作将永久删除订单'+item+', 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.$message({
                    type: 'success',
                    message: '删除成功!'
                });
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });
            if (e && e.stopPropagation){
                e.stopPropagation();
            }else{
                e.cancelBubble=true;//兼容IE
            }

        },

        opencancle(item,event) {
            var e = event || window.event;
            this.$confirm('是否取消订单'+item+'?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.$message({
                    type: 'success',
                    message: '取消成功!'
                });
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消操作'
                });
            });
            if (e && e.stopPropagation){
                e.stopPropagation();
            }else{
                e.cancelBubble=true;//兼容IE
            }

        },

        openconfirm(item,event) {
            var e = event || window.event;
            this.$confirm('是否确认收货', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.$message({
                    type: 'success',
                    message: '确认收货成功!'
                });
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消确认'
                });
            });
            if (e && e.stopPropagation){
                e.stopPropagation();
            }else{
                e.cancelBubble=true;//兼容IE
            }

        },
        openpay(item,event) {
            var e = event || window.event;
            this.$confirm('是否支付订单'+item+'?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.$message({
                    type: 'success',
                    message: '支付成功!'
                });
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消支付'
                });
            });
            if (e && e.stopPropagation){
                e.stopPropagation();
            }else{
                e.cancelBubble=true;//兼容IE
            }

        }
    }
})
