//手势列表
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
    el: '.top_list'
})

new Vue({
    el: '.p_carousel'
})


var card_res = $.ajax({ url: "http://139.199.75.41:3000/mock/11/new_book", async: false }).responseJSON

new Vue({
    el: '#new_book',
    data: {
        post: {
            card_res: card_res.res
        }
    }
})

new Vue({
    el: '#hot_book',
    data: {
        post: {
            card_res: card_res.res
        }
    }
})


new Vue({
    el: '#favorite_book',
    data: {
        post: {
            card_res: card_res.res
        }
    }
})