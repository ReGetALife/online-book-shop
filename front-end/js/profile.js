new Vue({
    el: '#top',
    data: {
        post: {
            activeIndex: '1000-1'
        }
    }
})
new Vue({
    el: '#content',
    data: {
        name: '加载中...',
        phone: '加载中...',
        newName: '',
        newPass: '',
        isChangingName: false,
        isChangingPass: false,
        changeName: function () {

        }
    },
    created: function () {
        var that = this
        $.ajax({
            url: "http://139.199.75.41:3000/mock/11/accounts/{accountId}",
            type: "get",
            dataType: 'json'
        }).done(function (data) {
            //console.log(data)
            that.name = data.accountName
            that.phone = data.phone
        }).fail(function (xhr, status) {
            console.log('失败: ' + xhr.status + ', 原因: ' + status)
        })
    }
})

