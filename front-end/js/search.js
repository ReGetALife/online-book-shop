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
    el: '.search_list',
    data: {
        post: {
            list_res: $.ajax({ url: "http://139.199.75.41:3000/mock/11/new_book", async: false }).responseJSON.res
        }
    }
})

