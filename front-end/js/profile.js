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
            url: "http://139.199.75.41:8085/accounts/"+Cookies.get('uid'),
            type: "get",
            dataType: 'json',
            headers: {
                AUTHORIZE_UID: Cookies.get('uid'),
                AUTHORIZE_TOKEN: Cookies.get('token')
            }
        }).done(function (data) {
            //console.log(data)
            that.name = data.accountName
            that.phone = data.phone
        }).fail(function (xhr, status) {
            console.log('失败: ' + xhr.status + ', 原因: ' + status)
        })
    }
})

