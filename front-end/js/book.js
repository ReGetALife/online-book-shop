new Vue({
    el: '.title_container',
    data: {
        post: {
            activeIndex: '-1'
        }
    }
})

new Vue({
    el: '.title_navigation'
})


new Vue({
    el: '.book_info',
    data: {
        post: {
            list_res: $.ajax({ url: "http://139.199.75.41:3000/mock/11/new_book", async: false }).responseJSON.res
        },
        currentPage: 1
    },
    computed: {
        showList() {
            console.log(this.post.list_res)
            return this.post.list_res;
        },
        count() {
            return eval(this.post.list_res).length;
        }
    },
    methods: {
        handleCurrentChange: function(val){
            this.currentPage = val;
            console.log(this.currentPage)
        },
        addToCart: function(val){
            console.log(val)
        }
    }
})

